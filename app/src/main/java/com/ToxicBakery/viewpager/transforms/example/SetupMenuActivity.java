
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
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
public class SetupMenuActivity extends Fragment {
    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;

    /**
     * SetupMenu에서 사용하는 list view string table
     */
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arrayList;
    private ListView setupListView;
    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static SetupMenuActivity create(int pageNumber) {
        SetupMenuActivity fragment = new SetupMenuActivity();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public SetupMenuActivity() {
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
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_setup_page, container, false);

        Button button = (Button)rootView.findViewById(R.id.slide1_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Slide 1 Button clicked", Toast.LENGTH_LONG).show();
            }
        });

        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);

        /*List View Data 정의*/
        arrayAdapter.add("11111111");
        arrayAdapter.add("222222222");
        arrayAdapter.add("33333333333");
        arrayAdapter.add("44444444444");
        arrayAdapter.add("55555555555");
        arrayAdapter.add("66666666666");
        arrayAdapter.add("7777777777");
        arrayAdapter.add("8888888888");
        arrayAdapter.add("99999999999");
        arrayAdapter.add("000000000000");
        arrayAdapter.add("8888888888");
        arrayAdapter.add("99999999999");
        arrayAdapter.add("000000000000");
        arrayAdapter.add("8888888888");
        arrayAdapter.add("99999999999");
        arrayAdapter.add("000000000000");

        // List View를 Inflate시킨다.
        setupListView = (ListView)rootView.findViewById(R.id.setupListView);

        //ListView에 Adapter를 연결한다.
        setupListView.setAdapter(arrayAdapter);
        //setupListView.setDrawingCacheBackgroundColor(Color.BLACK);

        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
