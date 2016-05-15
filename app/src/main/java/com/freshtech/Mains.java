package com.freshtech;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KUSUM DEVI on 14-05-2016.
 */
public class Mains extends Fragment {
    ListView listView;
    List<RowItem> row;
    FeedList feed;
    public Mains() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("HOME_FRAGMENT", "");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.mains, container, false);
        Log.e("HOME_FRAGMENT", "");
        listView = (ListView) rootview.findViewById(R.id.listView);
        row=new ArrayList<RowItem> ();
        String price[] = {"112","178","151","251"};
        String desc[] = {"112","178","151","251"};
        int like[] = {13,51,47,31};
        TypedArray menuIcons = getResources().obtainTypedArray(R.array.mains);
        for (int i = 0; i < price.length; i++) {
            RowItem items = new RowItem(price[i], menuIcons.getResourceId(
                    i, -1),desc[i],like[i]);
              row.add(items);
        }
        feed=new FeedList(this.getActivity(),row);
        listView.setAdapter(feed);
         return  rootview;
    }
}
