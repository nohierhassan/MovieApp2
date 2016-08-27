package movieapp.nohier.com.movieapp2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment
        {
    GridView gv ;
    private static final long serialVersionUID = 1L;
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
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Image object = (Image) gv.getAdapter().getItem(position);

                Intent intent= new Intent(getActivity(),DetailedActivity.class);
                intent.putExtra("Image",object);
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onStart() {
        // check for the connection first;
            SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
            String s = sharedPrefs.getString(getString(R.string.sortingOrderKey), getString(R.string.sortingOrderDefualtValue));
            FetchData fetch = new FetchData(getContext(), gv, s);
            fetch.execute();
            super.onStart();
        }


}

