package com.corvaisinc.amuseum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This is the fragment related to the tab Map and that shows the list of the museums.
 */
public class MuseumFragment extends Fragment {

    public static final String BUNDLE_PARAM_MUSEUMS = "BUNDLE_PARAM_MUSEUMS";

    private ListView list_museum;
    public static MuseumAdapter museumAdapter;
    private ArrayList<Museum> museums = AsyncOpenData.listmuseum;
    public static int museum_id;

    /**
     * This empty constructor is needed.
     */
    public MuseumFragment() {
    }

    /**
     * The onCreate function creates the museum adapter.
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Get list of bottles to display from fragment arguments
            museums = (ArrayList<Museum>) getArguments().getSerializable(BUNDLE_PARAM_MUSEUMS);
        }
        museumAdapter = new MuseumAdapter(getContext(), museums);
    }

    /**
     * The onCreateView function inflates the fragment's layout and initializes the list view with the museum's adapter.
     * @param inflater needed to create the view
     * @param container
     * @param savedInstanceState
     * @return the view for the fragment with the list of the museums that will be filled once the opendata has been retrieved
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_museum, container, false);

        list_museum = (ListView) rootView.findViewById(R.id.f_museum);

        list_museum.setAdapter(museumAdapter);

        //if item clicked
        list_museum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                museum_id = position;

                Intent intent = new Intent(getActivity(),InfoActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
