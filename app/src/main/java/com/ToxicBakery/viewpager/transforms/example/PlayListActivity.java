
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
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


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
        mPageNumber = getArguments().getInt(ARG_PAGE);ㅏ
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_playlist_page, container, false);

        // Button임시 삭제함.
        /*Button button = (Button) rootView.findViewById(R.id.slide3_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Slide 3 Button clicked", Toast.LENGTH_LONG).show();
            }
        });*/

        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
