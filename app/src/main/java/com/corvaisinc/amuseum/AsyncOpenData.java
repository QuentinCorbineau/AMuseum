package com.corvaisinc.amuseum;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * This class is an asynchronous thread that is executed in the background to retrieve the opendata as JSON from "https://corvaisinc.000webhostapp.com/museum.json"
 * Created by quent on 20/11/2017.
 */

public class AsyncOpenData extends AsyncTask<Void, Integer, ArrayList<Museum>> {

    private String URL="https://corvaisinc.000webhostapp.com/museum.json";
    // if this URL doesn't work please try : https://amuseum.000webhostapp.com/Museum_Paris.json
    ProgressDialog progressDialog;
    private MainActivity mainActivity;
    private MapFragment mapFragment;
    public static ArrayList<Museum> listmuseum = new ArrayList<Museum>();

    /**
     *
     * @param mainActivity needs the reference to the MainActivity to link the opendata to the museum list and its user interface
     */
    AsyncOpenData (MainActivity mainActivity) {this.mainActivity = mainActivity; }

    /**
     * Before the retrieval of the opendata is started, a progress dialog is initialized to show to the user that the application is retrieving the data
     */
    @Override
    protected void onPreExecute() {

        super.onPreExecute();
        progressDialog = new ProgressDialog(mainActivity);
        progressDialog.setTitle("Database's Udapte");
        progressDialog.setMax(100);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    /**
     * Shows the progress of the data retrieval
     * @param values the value of the progress
     */
    @Override
    protected void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values);
        // update a ProgressBar
        progressDialog.setProgress((Integer) values[0]);
    }

    /**
     * The actual task of this thread : retrieving the opendata from an external server
     * @param arg0 void
     * @return the list of the museums (that has been retrieved from an external JSON file)
     */
    @Override
    protected ArrayList<Museum> doInBackground(Void... arg0) {
        Log.i("info : ","on est dans le background");

        try {
            Log.i("info : ","avant connexion");

            //the url of the web site where the data is retrieved from
            String myurl= URL;

            URL url = new URL(myurl);
            //the connection to this server is started
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            //an input stream is put in place to receive the data
            InputStream inputStream = connection.getInputStream();
            Log.i("info : ","connection url");

            //InputStreamOperations is a complementary class:
            // It contains a method called InputStreamToString.
            // If the fields is available, museum parameter is set

            JSONArray jsonarray = new JSONArray(StreamOp.InputStreamToString(inputStream));
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                JSONObject field = jsonobject.getJSONObject("fields");
                JSONObject geometry = jsonobject.getJSONObject("geometry");
                JSONArray coordinates = geometry.getJSONArray("coordinates");
                Museum museum = new Museum();

                Log.i("info : ","musée n° : "+i);
                try {
                    if (field.getString("nom_du_musee") != null){
                        museum.setName(field.getString("nom_du_musee"));
                        Log.i("test : ", listmuseum.get(i).getName());}

                }
                catch (Exception e) {
                e.printStackTrace();
                }

                try {
                    if (field.getString("ville") != null){
                        museum.setCity(field.getString("ville"));
                        Log.i("test : ", listmuseum.get(i).getCity());}
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    if (field.getString("adr") != null){
                        museum.setAdress(field.getString("adr"));
                        Log.i("test : ", listmuseum.get(i).getAdress());}
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    if (field.getString("sitweb") != null){
                        museum.setSite(field.getString("sitweb"));
                        Log.i("test : ", listmuseum.get(i).getSite());}
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    if (field.getString("telephone1") != null){
                        museum.setPhone(field.getString("telephone1"));
                        Log.i("test : ", listmuseum.get(i).getPhone());}
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    if (field.getString("fermeture_annuelle") != null){
                        museum.setClose(field.getString("fermeture_annuelle"));
                        Log.i("test : ", listmuseum.get(i).getClose());}
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    if (coordinates.getString(1) != null){
                        museum.setLat(coordinates.getString(1));
                        Log.i("test : ", listmuseum.get(i).getLat());}
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    if (coordinates.getString(0) != null){
                        museum.setLon(coordinates.getString(0));
                        Log.i("test : ", listmuseum.get(i).getLon());}
                }
                catch (Exception e) {
                    e.printStackTrace();
                }


                // Add museum to the list
                listmuseum.add(museum);


            }
            MuseumFragment.museumAdapter.notifyDataSetChanged();
            android.os.SystemClock.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return listmuseum;
    }

    @Override
    protected void onPostExecute(ArrayList<Museum> result) {
        progressDialog.dismiss();

}


}
