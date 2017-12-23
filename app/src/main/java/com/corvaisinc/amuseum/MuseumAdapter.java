package com.corvaisinc.amuseum;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * This is the adapter for the museum to give the museum's information according to its position in the view as we have a list of museums.
 *
 * Created by quent on 23/11/2017.
 */

public class MuseumAdapter extends ArrayAdapter<Museum> {
    /**
     * This is the constructor.
     * @param context
     * @param objects
     */
    public MuseumAdapter(@NonNull Context context,@NonNull List<Museum> objects) {
        super(context, 0, objects);
    }

    /**
     *
     * @param position position of the element of the museums list
     * @param convertView not needed for the override
     * @param parent parent view group to inflate the layout of the initial museums element view.
     * @return the view of one item of the museums list with its name and the city
     */
    @NonNull
    @Override
    public View getView(int position,@Nullable View convertView,@NonNull ViewGroup parent) {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.item_museum, parent, false);

        TextView txvName = rootView.findViewById(R.id.i_museum_name);
        TextView txvCity = rootView.findViewById(R.id.i_museum_city);

        Museum museumToDisplay = getItem(position);

        txvName.setText(museumToDisplay.getName());
        txvCity.setText(museumToDisplay.getCity());

        return rootView;
    }
}
