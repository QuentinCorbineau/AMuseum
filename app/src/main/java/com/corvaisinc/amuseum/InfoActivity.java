package com.corvaisinc.amuseum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * This activity is created when a specific museum is selected and shows then detailed information about the selected museum.
 */
public class InfoActivity extends FragmentActivity {

    final ArrayList<Museum> museums = AsyncOpenData.listmuseum;
    private TextView museumName;
    private TextView museumCity;
    private TextView museumAdress;
    private TextView museumSite;
    private TextView museumPhone;
    private TextView museumClose;
    private TextView museumCoordinates;
    private Button back;
    private Button map;

    /**
     * The onCreate method initializes all the information fields and the layout for the user interface and has even a button to situate the museum on the map.
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //the layout is set
        setContentView(R.layout.activity_info);
        Intent intent = getIntent();
        //the information fields are set
        museumName=(TextView)findViewById(R.id.name);
        museumName.setText(museums.get(MuseumFragment.museum_id).getName());

        museumCity=(TextView)findViewById(R.id.city);
        museumCity.setText(museums.get(MuseumFragment.museum_id).getCity());

        museumAdress=(TextView)findViewById(R.id.adr);
        museumAdress.setText(museums.get(MuseumFragment.museum_id).getAdress());

        museumSite=(TextView)findViewById(R.id.site);
        museumSite.setText(museums.get(MuseumFragment.museum_id).getSite());

        museumPhone=(TextView)findViewById(R.id.phone);
        museumPhone.setText(museums.get(MuseumFragment.museum_id).getPhone());

        museumClose=(TextView)findViewById(R.id.close);
        museumClose.setText(museums.get(MuseumFragment.museum_id).getClose());

        museumCoordinates=(TextView)findViewById(R.id.coordinates);
        String coordinates = museums.get(MuseumFragment.museum_id).getLat() + " , " + museums.get(MuseumFragment.museum_id).getLon();
        museumCoordinates.setText(coordinates);

        //the button to situate the museum on the map is initiated
        map = (Button) findViewById(R.id.map_button);
        //when the button is clicked the map is shown and displays this museum's position and the current activity is closed
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.actionBar.setSelectedNavigationItem(1);
                MapFragment.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Double.parseDouble(museums.get(MuseumFragment.museum_id).getLat()),Double.parseDouble(museums.get(MuseumFragment.museum_id).getLon())),15f));
                finish();
            }
        });

        //the return button is initialized
        back=(Button) findViewById(R.id.back_button);

        //when the return button is clicked the current activity is closed and we will return to the previous activity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
