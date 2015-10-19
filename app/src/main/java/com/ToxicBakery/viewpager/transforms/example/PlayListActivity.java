
/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ToxicBakery.viewpager.transforms.example;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A fragment representing a single step in a wizard. The fragment shows a dummy title indicating
 * the page number, along with some dummy text.
 *
 * <p>This class is used by the {@link CardFlipActivity} and {@link
 * ScreenSlideActivity} samples.</p>
 */
public class PlayListActivity extends Fragment {
    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;

    private ListView listView;

    private ArrayList<PlayListSegmentActivity> arrayList;

    //ListView list;
    String[] web = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal",
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal",
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal",
    } ;
    Integer[] imageId = {
            R.drawable.afghanistan,
            R.drawable.bangladesh,
            R.drawable.india,
            R.drawable.japan,
            R.drawable.skorea,
            R.drawable.nepal,
            R.drawable.srilanka,
            R.drawable.afghanistan,
            R.drawable.bangladesh,
            R.drawable.india,
            R.drawable.japan,
            R.drawable.skorea,
            R.drawable.nepal,
            R.drawable.srilanka,
            R.drawable.afghanistan,
            R.drawable.bangladesh,
            R.drawable.india,
            R.drawable.japan,
            R.drawable.skorea,
            R.drawable.nepal,
            R.drawable.srilanka,
    };

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static PlayListActivity create(int pageNumber) {
        PlayListActivity fragment = new PlayListActivity();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlayListActivity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_playlist_page, container, false);

        PlayListSegmentActivity adapter = new PlayListSegmentActivity(getActivity(), web, imageId);

        listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        Intent i = new Intent(getActivity(), NowPlayingActivity.class);

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "listView pressed " + position, Toast.LENGTH_LONG).show();

                startActivity(i);
            }
        });

        listView.setBackgroundColor(Color.BLUE);

        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
