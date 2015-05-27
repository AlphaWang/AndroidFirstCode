package com.alphawang.andoridfirstcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Alpha on May/27/15.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        buttonEvent();

        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Toast.makeText(SecondActivity.this, "RECEIVED : " + data, Toast.LENGTH_SHORT).show();
    }

    private void buttonEvent() {
        Button button = (Button) findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "pressed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
