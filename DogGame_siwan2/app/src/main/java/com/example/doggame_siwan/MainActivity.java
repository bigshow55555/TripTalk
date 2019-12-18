package com.example.doggame_siwan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    buldog buldogclass = new buldog();
    poodle poodleclass = new poodle();
    ssulme ssulmeclass = new ssulme();

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

    }
    @Override
    public void onClick(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);

        switch (view.getId())
        {

            case R.id.button :
                textView.setText(buldogclass.bark());
                break;

            case R.id.button2 :
                textView.setText(poodleclass.bark());
                break;

            case R.id.button3 :
                textView.setText(ssulmeclass.bark());
                break;
        }
    }

}

