package com.example.twipee_triptalk.TripTalk.Posts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.twipee_triptalk.R;
import com.example.twipee_triptalk.TripTalk.Posts.Posts_Model.DataModelBoard;
import com.example.twipee_triptalk.TripTalk.Posts.Posts_Model.DataModelComment;
import com.example.twipee_triptalk.TripTalk.Posts.Posts_Model.DataModelLike;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PostDetailVeiw extends AppCompatActivity {

    private DataModelBoard board;
    private DataModelComment comment;
    private DataModelLike like;
    private TextView post_title, post_user, post_content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_post_detail_veiw);
        setComp();
        getPostDetail();
        setPost();

    }

    private void setComp() {
        post_title = findViewById(R.id.posts_title);
        post_content = findViewById(R.id.posts_contents);
    }


    private void getPostDetail() {
        Intent intent = getIntent();
        if(intent != null)
        {
            Bundle bld = intent.getExtras();

            Object obj = bld.get("board");
            if(obj != null && obj instanceof DataModelBoard){
                this.board = (DataModelBoard) obj;
            }
        }
    }
    private void setPost() {


        if (this.board != null) {
            String title = this.board.getUser_id();
            if (title != null) {
                post_title.setText(title);
            }
            String content = this.board.getBoard_type();
            if (content != null)
                post_content.setText(content);
        }


    }



}
