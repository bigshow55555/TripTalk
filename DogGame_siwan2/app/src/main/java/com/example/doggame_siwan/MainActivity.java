package com.example.doggame_siwan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener, DogListener {

    private TextView textView;
   private buldog buldogclass = new buldog();
   private poodle poodleclass = new poodle();
   private ssulme ssulmeclass = new ssulme();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        ssulmeclass.onDogListener(this);
        poodleclass.onDogListener(this);
        buldogclass.onDogListener(this);
    }


    @Override
    public void onClick(View view)
    {
        textView = (TextView) findViewById(R.id.textView);

        switch (view.getId())
        {

            case R.id.button :
                buldogclass.bark();
                break;

            case R.id.button2 :
                poodleclass.bark();
                break;

            case R.id.button3 :
                ssulmeclass.bark();
                break;
        }
    }

    @Override
    public void onBark(String Sound) {
        textView.setText(Sound);
    }
}

