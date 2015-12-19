package ge.koala.swapit.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import ge.koala.swapit.MainActivity;
import ge.koala.swapit.R;
import ge.koala.swapit.adapters.AdsListAdapter;
import ge.koala.swapit.adapters.CategoryListAdapter;
import ge.koala.swapit.objects.AdObject;

/**
 * Created by dalkh on 18-Dec-15.
 */
public class AdsFragment extends Fragment {
    private static String TAG = MainActivity.class.getSimpleName();
    private Context context;
    private String url;
    private RequestQueue requestQueue;
    private ArrayList<AdObject> adList;
    private AdsListAdapter adsListAdapter;
    private SwipeRefreshLayout refreshLayout;

    public AdsFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=getActivity().getApplicationContext();
        View rootView = inflater.inflate(R.layout.ads_fragment, container, false);
        final ListView adsView= (ListView) rootView.findViewById(R.id.ad_list);

        refreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swiperefresh);
        adList=new ArrayList<>();
        adsListAdapter=new AdsListAdapter(context,adList);
        adsView.setAdapter(adsListAdapter);
        url="http://mediacitys.com/swap/Main/allswaps";
        requestQueue = Volley.newRequestQueue(context);
        cacheJson();
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                fetchJsonData(requestQueue, url, adList, adsListAdapter, refreshLayout);

            }
        });
        adsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity().getBaseContext(),
                        MainActivity.class);
                Bundle args=new Bundle();
                args.putString("title", adList.get(i).getName());
                args.putString("description", adList.get(i).getDescription());
                args.putString("image", adList.get(i).getImageUrl());
                args.putString("location", adList.get(i).getLocation());
                args.putString("state", adList.get(i).getState());
                intent.putExtra("bundle", args);
                intent.putExtra("title","eete");
                getActivity().startActivity(intent);
            }
        });

        return rootView;
    }
    private void cacheJson(){
        Cache cache = requestQueue.getCache();
        Cache.Entry entry = cache.get(url);

        if (entry != null) {
            try {
                String data = new String(entry.data, "UTF-8");
                Log.d("CACHE DATA", data);

                JSONArray jsonArray = new JSONArray(data);

                setData(jsonArray,adList, adsListAdapter, refreshLayout);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            // Cache data not exist.
           /* refreshLayout.post(new Runnable() {
                @Override public void run() {
                    refreshLayout.setRefreshing(true);
                }
            });*/
            fetchJsonData(requestQueue, url, adList, adsListAdapter, refreshLayout);
            //refreshLayout.setRefreshing(false);
        }
    }
    private void fetchJsonData(RequestQueue requestQueue, String url,
                               final ArrayList<AdObject> list,
                               final AdsListAdapter adapter,
                               final SwipeRefreshLayout refreshLayout){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url,new Response.Listener<JSONArray>() {


            @Override
            public void onResponse(JSONArray jsonArray) {
                 setData(jsonArray,list,adapter,refreshLayout);
            }
        },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        Toast.makeText(getActivity().getApplicationContext(),
                                "საჭიროა ინტერნეტთან კავშირი", Toast.LENGTH_SHORT).show();
                        // hide the progress dialog
                        // hidepDialog();
                        refreshLayout.setRefreshing(false);
                    }
                });

        requestQueue.add(jsonArrayRequest);


    }
    private void setData(JSONArray jsonArray,
                         final ArrayList<AdObject> list,
                         final AdsListAdapter adapter,
                         final SwipeRefreshLayout refreshLayout){
        list.clear();
        for (int i = 0; i < jsonArray.length(); ++i) {
            JSONObject obj = null;
            try {
                obj = jsonArray.getJSONObject(i);

                AdObject adObject=new AdObject(obj.getString("title"),obj.getString("description"),obj.getJSONObject("swapImages").getString("img_url"),obj.getString("status"),obj.getString("state"));
                list.add(adObject);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        adapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
    }

}
