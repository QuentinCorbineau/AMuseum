package com.corvaisinc.amuseum;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * This Adapter manages to get the right fragment when a tab is clicked.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	/**
	 *
	 * @param index the index of the clicked tab
	 * @return the related fragment and null if the index is out of the existing range
	 */
	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Museum Rated fragment activity
			return new MuseumFragment();
		case 1:
			// Map fragment activity
			return new MapFragment();
		case 2:
			// About fragment activity
			return new AboutFragment();
		}

		return null;
	}

	/**
	 *
	 * @return the number of tabs
	 */
	@Override
	public int getCount() {
		// get item count -> equal to number of tabs
		return 3;
	}

}
