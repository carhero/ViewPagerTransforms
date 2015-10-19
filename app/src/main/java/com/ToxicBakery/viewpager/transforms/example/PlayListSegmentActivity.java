package com.ToxicBakery.viewpager.transforms.example;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by adsoft on 15. 10. 19.
 */
public class PlayListSegmentActivity extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;

    public PlayListSegmentActivity(Activity context,
                      String[] web, Integer[] imageId) {
        super(context, R.layout.play_list_segment, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }

//    static int cnt1 = 0;
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.play_list_segment, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.listViewLargeText);
        TextView txtSubTitle = (TextView) rowView.findViewById(R.id.listViewSubText);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.listViewDataIcon);

        imageView.setImageResource(imageId[position]);
        txtTitle.setText(web[position]);
        txtSubTitle.setText(web[position]);

/*        cnt1 += 1;
        Log.d("PlayListSegmentActivity", "PlayListSegmentActivity-getView" + cnt1);*/

        return rowView;
    }

    /*public Integer mIcon;
    public String mTitle;
    public String mSubTitle;;

    public PlayListSegmentActivity(ImageView icon, String title, String subTitle)
    {
        mIcon = icon;
        mTitle.setText(title);
        mSubTitle.setText(subTitle);
    }
    */
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

*//*        mIcon = (ImageView) findViewById(R.id.listViewDataIcon);
        mTitle = (TextView) findViewById(R.id.listViewLargeText);
        mSubTitle = (TextView) findViewById(R.id.listViewSubText);*//*
    }*/
}
