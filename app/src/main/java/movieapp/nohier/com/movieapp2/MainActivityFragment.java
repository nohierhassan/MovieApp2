package movieapp.nohier.com.movieapp2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    GridView gv ;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate the whole xml file then get the grid view by id

        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);
        gv = (GridView) rootView.findViewById(R.id.gridView);


        return rootView;
    }

    @Override
    public void onStart() {
        // here we want to check for the check for the unites selected by the user
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());


        String s = sharedPrefs.getString(getString(R.string.sortingOrderKey), getString(R.string.sortingOrderDefualtValue));
       Log.v("*****************",s);

        FetchData fetch = new FetchData(getContext(),gv,s);
        fetch.execute();
        Log.v("****************","ONSTART");
        super.onStart();
    }
}
