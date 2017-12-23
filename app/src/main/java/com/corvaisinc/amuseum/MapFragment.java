package com.corvaisinc.amuseum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * This is the fragment that includes the googlemap.
 */
public class MapFragment extends Fragment {

    public static final String BUNDLE_PARAM_MUSEUMS = "BUNDLE_PARAM_MUSEUMS";

    MapView mapView;
    public static  GoogleMap googleMap;


    public MapFragment() {
    }

    /**
     * The onCreateView function inflates the fragment's layout and instantiates the user's interface view with the googlemap and the markers on the museums positions.
     * @param inflater
     * @param container the parent view this user interface should be attached to
     * @param savedInstanceState
     * @return the fragment's view with the googlemap (once the opendata is retrieved it has the markers for the museums positions)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        mapView = (MapView) rootView.findViewById(R.id.map);

        mapView.onCreate(savedInstanceState);

        mapView.onResume();

        //if there is already a mapView (needs to be tested), a marker will be added for each museum on the list
        if (mapView != null) {
            final ArrayList<Museum> museums = AsyncOpenData.listmuseum;
            mapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap mMap) {
                    googleMap = mMap;


                    // For dropping a marker at a point on the Map

                    //the markers are added (one for each museum) with the museums information
                    for (int i = 0; i<museums.size();i++) {
                        double lat;
                        // String toto = communes.get(i).getLattitude();

                        lat=Double.parseDouble(museums.get(i).getLat());
                        double longi;
                        longi=Double.parseDouble(museums.get(i).getLon());
                        LatLng museum_coordinates = new LatLng(lat,longi);
                        googleMap.addMarker(new MarkerOptions().position(museum_coordinates).title(museums.get(i).getName()).snippet("Ville de Paris"));


                    }

                    LatLng defaultcoordinates = new LatLng(48.8234100,2.3488000);

                    //zoom buttons are enabled and the displayed map shows Paris
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(defaultcoordinates));
                    googleMap.getUiSettings().setZoomControlsEnabled(true);
                    googleMap.animateCamera(CameraUpdateFactory.zoomTo(12));

                    //when a marker is clicked, this generates a new activity to show more detailed information about the selected museum
                    googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            //the whole list is browsed to find the museum that has been clicked on
                            for (int i = 0; i<museums.size() ; i++) {
                                if (marker.getPosition().latitude == Double.parseDouble(museums.get(i).getLat()) && marker.getPosition().longitude == Double.parseDouble(museums.get(i).getLon())) {
                                    MuseumFragment.museum_id = i;
                                    Intent intent = new Intent(getActivity(),InfoActivity.class);
                                    startActivity(intent);
                                    return;
                                }
                            }
                        }
                    });
                }






            });

        }
        return rootView;
    }}