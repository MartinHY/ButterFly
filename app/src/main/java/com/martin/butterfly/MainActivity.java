package com.martin.butterfly;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDialog();
    }

    private void showDialog() {
        ButterFlyDialog butterFlyDialog = new ButterFlyDialog(this);
        butterFlyDialog.show();
    }
}
