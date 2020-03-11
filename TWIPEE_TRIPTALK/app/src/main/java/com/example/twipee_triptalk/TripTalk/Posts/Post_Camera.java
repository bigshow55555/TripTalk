package com.example.twipee_triptalk.TripTalk.Posts;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twipee_triptalk.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Post_Camera extends Fragment {


    public Post_Camera() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post__camera, container, false);
    }

}
