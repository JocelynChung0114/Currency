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
                    .setTitle(getString(R.string.problem))
                    .setMessage(getString(R.string.enter_ntd))
                    .setPositiveButton(getString(R.string.ok), null)
                    .show();
        } else {
            float result = Float.valueOf(n) / 30.9f;
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.result))
                    .setMessage(getString(R.string.usd_is) + result)
                    .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ntd.setText("");
                        }
                    })
                    .show();
        }
    }
}
