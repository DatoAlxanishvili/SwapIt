package ge.koala.swapit.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

import ge.koala.swapit.R;

public class AdsDetailFragment extends Fragment {
    private SliderLayout imageSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        Context context=getActivity().getApplicationContext();
        View rootView = inflater.inflate(R.layout.ad_detail_fragment, container, false);
        imageSlider= (SliderLayout) rootView.findViewById(R.id.slider);
        imageSlider.stopAutoCycle();
        TextView titleView= (TextView) rootView.findViewById(R.id.ad_detail_title);
        TextView descriptionViw=(TextView) rootView.findViewById(R.id.ad_detail_description);
        String url= null;
        String title=null;
        String description=null;
        try {
            url = getArguments().getString("image");
            title=getArguments().getString("title");
            description=getArguments().getString("description");
            descriptionViw.setText(description);
            titleView.setText(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://mediacitys.com/swap/images/" + url);
        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(context);
            // initialize a SliderLayout
            textSliderView
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);




            imageSlider.addSlider(textSliderView);
        }
         return rootView;
    }

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        imageSlider.stopAutoCycle();
        super.onStop();
    }

}
