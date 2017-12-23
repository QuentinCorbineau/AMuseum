package com.corvaisinc.amuseum;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * This fragment contains information about the application itself (what opendata has been used, what licences ...)
 */
public class AboutFragment extends Fragment {

    /**
     * The onCreateView function inflates the fragment's layout and instantiates the user's interface view with the information about this application.
     * @param inflater
     * @param container the parent view this user interface should be attached to
     * @param savedInstanceState
     * @return the fragment's view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        return rootView;
    }
}
