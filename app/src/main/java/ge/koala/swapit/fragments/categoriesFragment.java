package ge.koala.swapit.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ge.koala.swapit.R;

/**
 * Created by dalkh on 18-Dec-15.
 */
public class categoriesFragment extends Fragment {
    public categoriesFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.categories_fragment, container, false);
        return rootView;
    }
}
