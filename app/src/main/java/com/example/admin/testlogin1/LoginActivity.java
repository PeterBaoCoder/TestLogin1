package com.example.admin.testlogin1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by admin on 2016/07/01.
 */
public class LoginActivity extends AppCompatActivity {
    Button btnLogin, btnTrial;
    EditText edtUserNm, edtPw;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnTrial = (Button) findViewById(R.id.btn_trial);
        edtUserNm = (EditText) findViewById(R.id.edt_Id);
        edtPw = (EditText) findViewById(R.id.edt_pw);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventLogin();
            }
        });
        btnTrial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventTrial();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void eventLogin() {

        boolean flagLogin = true;
        if (!validate()) {

            onLoginFailed();
            return;
        }
//        btnLogin.setEnabled(false);

    }

    public void onLoginFailed() {

//        btnLogin.setEnabled(true);
    }

    private void eventTrial() {

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

    }

    public boolean validate() {
        boolean valid = true;
        String userName = edtUserNm.getText().toString();
        String password = edtPw.getText().toString();
        if (userName.isEmpty()) {
            edtUserNm.setError("please input username");
            valid = false;
        } else {
            edtUserNm.setError(null);
        }
        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            edtPw.setError("please input password");
            valid = false;
        } else {
            edtPw.setError(null);
        }
        return valid;
    }
}
