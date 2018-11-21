package com.example.edu.mywebview1121;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_search;
    EditText siteURL;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_search =(Button) findViewById(R.id.btn_search);
        btn_search.setOnClickListener(this);
        siteURL = (EditText) findViewById(R.id.editText);
        webView = (WebView) findViewById(R.id.webView);
    }

    @Override
    public void onClick(View v) {
        InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
        
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
                                     @Override
                                     public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                         return super.shouldOverrideUrlLoading(view, url);
                                     }
                                 }

        );
        webView.loadUrl(siteURL.getText().toString());
        webView.requestFocus();

    }
}
