package com.example.twipee_triptalk.TripTalk.Posts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.twipee_triptalk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewWriteActivity extends AppCompatActivity {


    private EditText mTitleText;
    private EditText mContentText;
    private FloatingActionButton mSubmitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_write);

        mTitleText = findViewById(R.id.fieldTitle);
        mContentText = findViewById(R.id.fieldBody);
        mSubmitButton = findViewById(R.id.fabSubmitPost);



    }
}
