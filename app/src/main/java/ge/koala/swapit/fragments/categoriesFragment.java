package ge.koala.swapit.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ge.koala.swapit.MainActivity;
import ge.koala.swapit.R;
import ge.koala.swapit.adapters.CategoryListAdapter;
import ge.koala.swapit.data.Categories;
import ge.koala.swapit.objects.CategoryObject;

/**
 * Created by dalkh on 18-Dec-15.
 */
public class CategoriesFragment extends Fragment {
    public CategoriesFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.categories_fragment, container, false);
        ListView categoryView= (ListView) rootView.findViewById(R.id.category_list);
        final ArrayList<CategoryObject> list=new ArrayList<>();

        for (int i = 0; i < Categories.names.length; i++) {
             CategoryObject categoryObject=new CategoryObject(Categories.names[i],Categories.icons[i]);
            list.add(categoryObject);
        }
        CategoryListAdapter categoryListAdapter=new CategoryListAdapter(getActivity().getApplicationContext(),list);
        categoryView.setAdapter(categoryListAdapter);
         categoryView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                 Intent intent = new Intent(getActivity().getBaseContext(),
//                         MainActivity.class);
//                 intent.putExtra("message", list.get(i).getName());
//                 getActivity().startActivity(intent);

             }
         });

        return rootView;
    }
}
