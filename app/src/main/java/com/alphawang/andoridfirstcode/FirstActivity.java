package com.alphawang.andoridfirstcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Alpha on May/21/15.
 */
public class FirstActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        buttonEvent();
        finishEvent();

        expIntentEvent();
        impIntentEvent();
    }

    // 1. Button Event
    private void buttonEvent() {
        Button button = (Button) findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "You clicked button!", Toast.LENGTH_LONG)
                     .show();
            }
        });
    }



    // 2. Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "Clicked Add Menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_item:
                Toast.makeText(this, "Clicked Delete Menu", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    // 3. finish
    private void finishEvent() {
        Button finishBtn = (Button) findViewById(R.id.button_finish);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // 4. exp intent
    private void expIntentEvent() {
        Button expBtn = (Button) findViewById(R.id.button_intent_exp);
        expBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class); // context, target
                startActivity(intent);
            }
        });
    }

    private void impIntentEvent() {
        Button impBtn = (Button) findViewById(R.id.button_intent_imp);
        impBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.SET_WALLPAPER");// com.alphawang.action.TEST
                startActivity(intent);
            }
        });
    }

}
