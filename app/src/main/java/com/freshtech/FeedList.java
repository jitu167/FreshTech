package com.freshtech;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KUSUM DEVI on 14-05-2016.
 */
public class FeedList extends BaseAdapter implements View.OnClickListener{
    Context context;
    int item_count = 0;
    List<RowItem> row;
    Activity activity;
    public FeedList(Context context,List<RowItem> row){
        this.context = context;
        this.row=row;
    }

    @Override
    public int getCount() {
        return row.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       final ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.image=(ImageView)convertView.findViewById(R.id.bac);
            viewHolder.lie_layout=(RelativeLayout)convertView.findViewById(R.id.gridLayout);
            viewHolder.unlieb = (ImageButton)convertView.findViewById(R.id.unlikeb);
            viewHolder.liketext=(TextView)convertView.findViewById(R.id.like);
            viewHolder.plus = (ImageButton)convertView.findViewById(R.id.plus);
            viewHolder.desc=(TextView)convertView.findViewById(R.id.tv2);
            viewHolder.txt_quantity = (TextView) convertView.findViewById(R.id.addM);
            viewHolder.minus = (ImageButton)convertView.findViewById(R.id.minus);

            convertView.setTag(viewHolder);
        }

        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final RowItem rw=row.get(position);
        viewHolder.image.setImageBitmap(
                decodeSampledBitmapFromResource(context.getResources(),rw.getIcon(), 100, 100));
        viewHolder.liketext.setText(String.valueOf(rw.getLikes()));
        viewHolder.desc.setText(rw.getDesc());
        if(rw.getItems()<=0){
        viewHolder.txt_quantity.setVisibility(View.GONE);
        viewHolder.minus.setVisibility(View.GONE);}
        viewHolder.lie_layout.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View v) {
                                                         if (rw.isLiked()) {
                                                             rw.setLiked(false);
                                                             rw.setLikes(rw.getLikes() - 1);
                                                             viewHolder.liketext.setText(String.valueOf(rw.getLikes()));
                                                             viewHolder.unlieb.setVisibility(ImageButton.VISIBLE);
                                                         } else {
                                                             rw.setLiked(true);
                                                             rw.setLikes(rw.getLikes() + 1);
                                                             viewHolder.liketext.setText(String.valueOf(rw.getLikes()));
                                                             viewHolder.unlieb.setVisibility(ImageButton.GONE);
                                                         }
                                                     }
                                                 }
        );
        viewHolder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.txt_quantity.setVisibility(View.VISIBLE);
                viewHolder.minus.setVisibility(View.VISIBLE);
                int item=rw.getItems();
                rw.setItems(item+1);
                viewHolder.txt_quantity.setText(String.valueOf(rw.getItems()) + "");
            }
        });
        viewHolder.txt_quantity.setOnClickListener(this);
        viewHolder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("Alert");
                builder.setMessage("Do you want remove");
                builder.setPositiveButton("Remove", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int item = rw.getItems();
                        if (item > 0)
                        {
                           item-=1;
                            rw.setItems(item);
                            viewHolder.txt_quantity.setText(item + "");
                            if(item<=0)
                            {
                                viewHolder.txt_quantity.setVisibility(View.GONE);
                                viewHolder.minus.setVisibility(View.GONE);
                            }
                        }
                        else {
                            viewHolder.txt_quantity.setVisibility(View.GONE);
                            viewHolder.minus.setVisibility(View.GONE);
                        }

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();


            }
        });
        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.plus:
                break;

            case R.id.addM:
                break;

            case R.id.minus:


                break;
        }
    }

    public static class ViewHolder{
        ImageButton plus,unlieb;
        TextView txt_quantity,liketext,desc;
        ImageButton minus;
        ImageView image;
        RelativeLayout lie_layout;
    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
