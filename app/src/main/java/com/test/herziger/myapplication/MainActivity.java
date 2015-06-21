package com.test.herziger.myapplication;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.EditText;
import android.widget.TextView;

import android.content.res.Resources;
import android.util.TypedValue;

import com.test.herziger.myapplication.controller.DataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    // tag for logging:
    private final String TAG = "HerzigerMessages";
    private List<TextView> textViewList = new ArrayList<>();

    public void printData(List<HashMap<String, Object>> data) {
        int i = 3;
        for (HashMap<String, Object> node : data) {
            TextView textView = new TextView(this);
            textView.setId(i);
            String strValue = (String)node.get("firstName") + " " + (String)node.get("lastName") + " (" + (String)node.get("email") + ")";
            textView.setText(strValue);
            textViewList.add(textView);
            textView.setTextColor(Color.parseColor("#f1f1f1"));
            textView.setBackgroundColor(Color.parseColor("#1111bb"));
            i++;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.relative_layout);

        // layout:
        RelativeLayout homescreenLayout = new RelativeLayout(this);
        homescreenLayout.setBackgroundColor(Color.parseColor("#f1f1f1"));

        // button:
        Button redButton = new Button(this);
        redButton.setId(1);
        redButton.setText("Click here");
        redButton.setTextColor(Color.parseColor("#ffffff"));
        redButton.setBackgroundColor(Color.parseColor("#aa1111"));

        // username input:
        EditText userName = new EditText(this);
        userName.setId(2);

        // details:
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams userNameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams nodeDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //ruls:
        userNameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        userNameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userNameDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        userNameDetails.setMargins(50, 50, 50, 50);
        //nodeDetails.addRule(RelativeLayout.BELOW);
        //nodeDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        nodeDetails.setMargins(50, 50, 50, 50);
        // convert desired 'dp' value to 'px':
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());



        userName.setWidth(px);


        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);


        DataProvider dataProvider = new DataProvider();
        this.printData(dataProvider.getData());



        // use views in layout
        homescreenLayout.addView(userName, userNameDetails);
        homescreenLayout.addView(redButton, buttonDetails);



        LinearLayout lL = new LinearLayout(this);
        lL.setOrientation(LinearLayout.VERTICAL);

        int i = 0;
        if (textViewList != null && textViewList.size() > 0) {
            Log.i(TAG, "assigned design to first node");
            //nodeDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        }
        for (TextView textView : textViewList) {
            if (i != 0) {
                Log.i(TAG, "assigned design to non-first node");
                //nodeDetails.addRule(RelativeLayout.BELOW, textViewList.get(i - 1).getId());
            }
            lL.addView(textView, nodeDetails);
            Log.i(TAG, "added node to layout");
            i++;
        }
        setContentView(lL);

        Log.i(TAG, "onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
