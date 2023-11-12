package com.example.testdlc;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NeuralNetworkBuilder builder = new NeuralNetworkBuilder();
        boolean result = builder.initializingModel(this, "Model Name");
    }

}