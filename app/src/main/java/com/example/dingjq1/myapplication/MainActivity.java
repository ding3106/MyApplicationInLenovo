package com.example.dingjq1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.jdom.Document;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "dingjq1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Todo  helle
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        Log.w(TAG, "onCreate: ");

        tv.setText(stringFromJNI());
        System.out.print("Hello Console!");

        Document Doc = new Document();


    }

    public void click(View view){
        forCircle();
    }

    public void forCircle() {
        for (int i = 0; i < 9; i++) {
            Log.i(TAG, "forCircle: i = " + i);
            printNum(i);
        }
    }

    public void printNum(int j) {
        int x = j;
        if (j == 3) {
            Log.i(TAG, "printNum: j = " + j);
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {


        System.loadLibrary("native-lib");


    }


    @Override
    protected void onStop() {
        Log.d(TAG, "onStop() called");
        super.onStop();
    }


}
