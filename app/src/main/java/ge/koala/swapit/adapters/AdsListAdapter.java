package ge.koala.swapit.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ge.koala.swapit.R;
import ge.koala.swapit.objects.AdObject;

/**
 * Created by Geolabedu on 19.12.15.
 */
public class AdsListAdapter extends BaseAdapter {

    private ArrayList<AdObject> ads;
    private Context context;

    public AdsListAdapter(Context context, ArrayList<AdObject> ads) {
        this.context = context;
        this.ads = ads;
    }

    @Override
    public int getCount() {
        return ads.size();
    }

    @Override
    public Object getItem(int i) {
        return this.ads.get(i);
    }


    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View itemView;
        ViewHolder holder = null;
        if (convertView == null) {
            itemView = View.inflate(context, R.layout.ad_list_item, null);
            ImageView photoView = (ImageView) itemView.findViewById(R.id.photo);
            TextView titleView = (TextView) itemView.findViewById(R.id.ad_title);
            TextView stateView = (TextView) itemView.findViewById(R.id.state);
            TextView locationView = (TextView) itemView.findViewById(R.id.location);
            holder = new ViewHolder();

            holder.photoView = photoView;
            holder.titleView = titleView;
            holder.stateView = stateView;
            holder.locationView = locationView;
            itemView.setTag(holder);
        } else {
            itemView = convertView;
            holder = (ViewHolder) itemView.getTag();
        }


        AdObject adObject = (AdObject) getItem(i);


        holder.titleView.setText(adObject.getName());
        holder.stateView.setText("მდგომარეობა : "+adObject.getState());
        holder.locationView.setText("მდებარეობა : "+adObject.getLocation());
        Picasso.with(context).load("http://mediacitys.com/swap/images/" + adObject.getImageUrl()).into(holder.photoView);


        return itemView;
    }

    private class ViewHolder {
        ImageView photoView;
        TextView titleView;
        TextView stateView;
        TextView locationView;
    }

}
