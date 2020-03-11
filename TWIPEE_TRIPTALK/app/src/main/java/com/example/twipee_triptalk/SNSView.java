package com.example.twipee_triptalk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SNSView extends Fragment {

    private static final String TAG = "SNS View";
    public SNSView() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view  = inflater.inflate(R.layout.fragment_snsview,container, false);
        TextView mtextView= (TextView) view.findViewById(R.id.textView2);

        return view;
    }
}
