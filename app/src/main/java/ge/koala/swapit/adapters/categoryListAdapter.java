package ge.koala.swapit.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ge.koala.swapit.R;

/**
 * Created by dalkh on 19-Dec-15.
 */
public class categoryListAdapter extends RecyclerView.Adapter<categoryListAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RobotoTextView dateView, tempMaxView, tempMinView;
        DejaVUSansTextView weekDayView;
        ImageView iconView;

        public ViewHolder(View itemView) {
            super(itemView);
            dateView = (RobotoTextView) itemView.findViewById(R.id.date);
            weekDayView = (DejaVUSansTextView) itemView.findViewById(R.id.weekDay);
            iconView = (ImageView) itemView.findViewById(R.id.icon);
            tempMaxView = (RobotoTextView) itemView.findViewById(R.id.temp_max);
            tempMinView = (RobotoTextView) itemView.findViewById(R.id.temp_min);

        }
    }
}