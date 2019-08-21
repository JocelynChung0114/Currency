package com.home.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ntd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews(){
        ntd = findViewById(R.id.ntd);
    }

    public void go(View view) {
        String n = ntd.getText().toString();

        if(TextUtils.isEmpty(n)) {
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount")
                    .setPositiveButton("OK", null)
                    .show();
        } else {
            float result = Float.valueOf(n) / 30.9f;
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("USD is " + result)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ntd.setText("");
                        }
                    })
                    .show();
        }
    }
}
