package com.example.twipee_triptalk.TripTalk.Board;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import com.example.twipee_triptalk.R;
import com.example.twipee_triptalk.SectionPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class BoardActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_activity);

        prepareSimpleDB();

        LinearLayout li = (LinearLayout)findViewById(R.id.itemlist);

        for(int i = 0; i <SimpleDB.getIndexes().size(); i++)
        {
            final Button button = new AppCompatButton(this);
            button.setText(SimpleDB.getIndexes().get(i));

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    String buttonText = (String) ((Button)v).getText();

                    intent.putExtra("key",buttonText);
                    startActivity(intent);
                }
            });




            li.addView(button);
        }


    }

    private void prepareSimpleDB(){
        for (int i = 1; i <100; i++)
        {
            SimpleDB.addArticle(i + "번글", new ArticleVO(i, i+ "번글 제목", i + "번글 내용", "내가"));
        }

    }


}
