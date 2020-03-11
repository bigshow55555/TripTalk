package com.example.twipee_triptalk.TripTalk.Posts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.twipee_triptalk.R;
import com.example.twipee_triptalk.TripTalk.Posts.Posts_Model.DataModelBoard;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class PostViewActivity extends AppCompatActivity{


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton Writfab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_view);

        Writfab = findViewById(R.id.fabPost);
        mRecyclerView = findViewById(R.id.recycler1);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Writfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PostViewActivity.this,NewWriteActivity.class));
            }
        });

        getBoard();
    }

    public void getBoard(){

        List<DataModelBoard> mBoard = new ArrayList<>();

            DataModelBoard datamodel = new DataModelBoard();
            datamodel.setBoard_type("asdasd");
            datamodel.setData_created("123123");
            datamodel.setBoard_type("qwd");
            datamodel.setLocation("구미");
            datamodel.setUser_id("qwdq");
            mBoard.add(datamodel);

        //final PostsAdapter adapter = new PostsAdapter(DataModelBoard, new View.OnClickListener() {
        mAdapter = new PostsAdapter(mBoard, PostViewActivity.this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object obj = v.getTag();
                if (obj != null) {
                    int position = (int) obj;
                    ((PostsAdapter) mAdapter).getBoard(position).getBoard_type();
                    Intent intent = new Intent(PostViewActivity.this, PostDetailVeiw.class);
                    intent.putExtra("board",((PostsAdapter)mAdapter).getBoard(position));
                    startActivity(intent);
                };

            }
        });

        mRecyclerView.setAdapter(mAdapter);

    }


}



