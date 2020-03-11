package com.example.twipee_triptalk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import com.example.twipee_triptalk.TripTalk.Chat.ChatActivity;
import com.example.twipee_triptalk.TripTalk.TripTalkBoard;
import com.example.twipee_triptalk.TripTalk.TripTalkDistribution;

public class TripTalkView extends Fragment {
    private CustomAdapter adapter;
    private ListView listView;
    private Context mContext;
    SharedPreferences pref;
    ToggleButton btn_choice;
    public double latitude;
    public double longitude;
    public double altitude;


    public TripTalkView()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_triptalkview, container, false);

        final TextView n_address = (TextView) view.findViewById(R.id.n_address);

        adapter = new CustomAdapter();
        listView = (ListView) view.findViewById(R.id.listview_trip);
        setData();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView , View v , int position , long Id) {
                switch (position)
                {
                    case 0:
                        Intent intent = new Intent(getActivity(), ChatActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), TripTalkDistribution.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), TripTalkBoard.class);
                        startActivity(intent2);
                        break;
                    default:
                        break;
                }

            }
        });

        return view;
    }

    private void setData() {

        TypedArray arrResId = getResources().obtainTypedArray(R.array.resId);
        String[] titles = getResources().getStringArray(R.array.title);
        String[] contents = getResources().getStringArray(R.array.content);
        for (int i = 0; i < ((TypedArray) arrResId).length(); i++) {
            CustomDTO dto = new CustomDTO();
            dto.setResId(arrResId.getResourceId(i , 0));
            dto.setTitle(titles[i]);
            dto.setContent(contents[i]);
            adapter.addItem(dto);
        }
    }

}
