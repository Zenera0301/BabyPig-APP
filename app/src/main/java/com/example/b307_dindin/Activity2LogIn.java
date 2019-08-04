package com.example.b307_dindin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class Activity2LogIn extends Activity implements View.OnClickListener {
    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2login);
        mUsername = (EditText) findViewById(R.id.editTextUserName);
        mPassword = (EditText) findViewById(R.id.editTextLoginPassword);
        mLogin = (Button) findViewById(R.id.btnLogin);
        mLogin.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin://登录按钮被点击，进行登录
                if (mUsername.getText().length() == 0) {
                    mUsername.setError("Can not be empty");
                    mUsername.requestFocus();
                } else if (mPassword.getText().length() == 0) {
                    mPassword.setError("Can not be empty");
                    mPassword.requestFocus();
                } else {

                }
                break;
            case R.id.textViewSignUp://注册字样被点击，进行注册
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.v2ex.com/signup")));
                break;
        }
    }


}
