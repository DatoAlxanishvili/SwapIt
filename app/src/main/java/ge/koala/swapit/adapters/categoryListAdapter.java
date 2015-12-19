package ge.koala.swapit.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ge.koala.swapit.R;
import ge.koala.swapit.objects.CategoryObject;

/**
 * Created by Geolabedu on 19.12.15.
 */
public class CategoryListAdapter extends BaseAdapter {

    private ArrayList<CategoryObject> categories;
    private Context context;

    public CategoryListAdapter(Context context, ArrayList<CategoryObject> categories) {
        this.context = context;
        this.categories = categories;
    }
    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return this.categories.get(i);
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
            itemView = View.inflate(context, R.layout.categories_list_item, null);
             ImageView categoryIconView= (ImageView) itemView.findViewById(R.id.category_icon);
             TextView nameView= (TextView) itemView.findViewById(R.id.category_name);
            holder = new ViewHolder();

            holder.categoryIconView = categoryIconView;
            holder.nameView = nameView;

            itemView.setTag(holder);
        } else {
            itemView = convertView;
            holder = (ViewHolder) itemView.getTag();
        }


        CategoryObject categoryObject = (CategoryObject) getItem(i);


        holder.nameView.setText(categoryObject.getName());
        holder.categoryIconView.setImageResource(categoryObject.getCategoryIcon());


        return itemView;
    }

    private class ViewHolder {
        ImageView categoryIconView;
        TextView nameView;

    }

}
