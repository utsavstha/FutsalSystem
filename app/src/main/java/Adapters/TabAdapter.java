package Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import Fragments.ListOfAllFutsals;

/**
 * Created by utsav on 8/24/2015.
 */
public class TabAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[] = {"All"," Nearby", "Recommended"};
    int NumbOfTabs;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) // if the position is 0 we are returning the First tab
        {
            ListOfAllFutsals futsals = new ListOfAllFutsals();
            return futsals;
        }
        else{
            ListOfAllFutsals futsals = new ListOfAllFutsals();
            return futsals;
        }

    }

    @Override
    public int getCount() {
        return Titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }
}
