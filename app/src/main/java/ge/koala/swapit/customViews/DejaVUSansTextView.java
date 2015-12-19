package ge.koala.swapit.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Geolabedu on 19.12.15.
 */
public class DejaVUSansTextView extends TextView {
    public DejaVUSansTextView(Context context, AttributeSet attr){
        super(context,attr);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/bpg_dejavu_sans_0.ttf"));
    }
}