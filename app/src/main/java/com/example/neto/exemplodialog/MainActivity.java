package com.example.neto.exemplodialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void open(View view) {
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(),"dialog");
    }

    public void openSimple(View view) {
        SimpleDialogFragment simpleDialog = new SimpleDialogFragment();
        simpleDialog.show(getSupportFragmentManager(),"simpleDialog");
    }

    public void openRatio(View view){
        RadioDialogFragment radioDialog = new RadioDialogFragment();
        radioDialog.show(getSupportFragmentManager(),"radioDialog");
    }

    public void openMultiple(View view) {
        MultipleDialogFragment multiple = new MultipleDialogFragment();
        multiple.show(getSupportFragmentManager(),"dialogMultiple");
    }

    public void openEditDialog(View view) {
        MyEditDialog.show(getSupportFragmentManager(), new MyEditDialog.OnTextListener() {
            @Override
            public void onSetText(String text) {
                Toast.makeText(MainActivity.this,"Texto: " + text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
