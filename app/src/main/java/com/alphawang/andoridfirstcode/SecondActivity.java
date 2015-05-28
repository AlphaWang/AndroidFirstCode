package com.alphawang.andoridfirstcode;

import android.app.Activity;
import android.content.Context;
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

        // 1. receive data
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Toast.makeText(SecondActivity.this, "RECEIVED : " + data, Toast.LENGTH_SHORT).show();
    }

    private void buttonEvent() {
        Button button = (Button) findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "finish", Toast.LENGTH_SHORT).show();

                // 2. return data
                Intent intent = new Intent();
                intent.putExtra("data_return", "Data From 2nd Activity.");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    // 2. return data if pressed back menu
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Back From 2nd Activity.");
        setResult(RESULT_OK, intent);
        finish();
    }

    // 3. start method
    public static void actionStart(Context context, String extraData, String extraDesc) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("extra_data", extraData);
        intent.putExtra("extra_desc", extraDesc);
        context.startActivity(intent);
    }
}
