package movieapp.nohier.com.movieapp2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate the whole xml file then get the grid view by id

        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);
        gv = (GridView) rootView.findViewById(R.id.gridView);
        FetchData fetch = new FetchData(getContext(),gv);
        fetch.execute();

        return rootView;
    }
}
