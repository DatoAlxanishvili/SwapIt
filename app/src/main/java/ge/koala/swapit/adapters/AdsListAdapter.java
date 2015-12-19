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
            ImageView photoView= (ImageView) itemView.findViewById(R.id.photo);
            TextView titleView= (TextView) itemView.findViewById(R.id.ad_title);
            TextView descriptionView= (TextView) itemView.findViewById(R.id.brief_description);
            holder = new ViewHolder();

            holder.photoView = photoView;
            holder.titleView = titleView;
            holder.descriptionView=descriptionView;
            itemView.setTag(holder);
        } else {
            itemView = convertView;
            holder = (ViewHolder) itemView.getTag();
        }


        AdObject adObject = (AdObject) getItem(i);


        holder.titleView.setText(adObject.getName());
        Picasso.with(context).load(adObject.getImageUrl()).into(holder.photoView);


        return itemView;
    }

    private class ViewHolder {
        ImageView photoView;
        TextView titleView;
        TextView descriptionView;
    }

}
