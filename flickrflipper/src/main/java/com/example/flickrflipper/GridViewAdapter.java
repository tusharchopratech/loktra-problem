package com.example.flickrflipper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by tc on 7/7/16.
 */
 class GridViewAdapter extends BaseAdapter{
        GridViewData[] gridViewData;
            LayoutInflater inflater;
            LinearLayout linearLayout;
            TextView name;
            TextView description ;
            TextView location ;
            Context context;

        public GridViewAdapter(GridViewData[] gridViewData,Context context) {
            this.gridViewData = gridViewData;
            this.context=context;
        }

        @Override
        public int getCount() {
            return gridViewData.length;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            linearLayout = (LinearLayout) inflater.inflate(R.layout.inflate_gridview, null);
            name = (TextView) linearLayout.findViewById(R.id.textViewName);
            description = (TextView) linearLayout.findViewById(R.id.textViewDescription);
            location = (TextView) linearLayout.findViewById(R.id.textViewLocation);
            final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.imageiew);
            final LinearLayout linearLayoutItem = (LinearLayout) linearLayout.findViewById(R.id.linearLayoutItem);

            name.setText(gridViewData[i].getName());
            description.setText(gridViewData[i].getDescription());
            location.setText(gridViewData[i].getLocation());
            imageView.setImageResource(gridViewData[i].getResourceId());


            Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            width = width / 2;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, width);
            imageView.setLayoutParams(params);
            linearLayoutItem.setLayoutParams(params);


            linearLayoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                            linearLayoutItem.setVisibility(View.GONE);
                            imageView.setVisibility(View.VISIBLE);
                    }
            });

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                            imageView.setVisibility(View.GONE);
                            linearLayoutItem.setVisibility(View.VISIBLE);
                }
            });

            return linearLayout;
        }
}

