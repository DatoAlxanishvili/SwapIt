package ge.koala.swapit.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ge.koala.swapit.R;
import ge.koala.swapit.adapters.AdsListAdapter;
import ge.koala.swapit.adapters.CategoryListAdapter;
import ge.koala.swapit.objects.AdObject;

/**
 * Created by dalkh on 18-Dec-15.
 */
public class AdsFragment extends Fragment {

    public AdsFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context context=getActivity().getApplicationContext();
        View rootView = inflater.inflate(R.layout.ads_fragment, container, false);
        ListView adsView= (ListView) rootView.findViewById(R.id.ad_list);
        ArrayList<AdObject> adList=new ArrayList<>();
        AdsListAdapter adsListAdapter=new AdsListAdapter(context,adList);
        try {
            System.out.println(getArguments().getString("message"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return rootView;
    }
}
