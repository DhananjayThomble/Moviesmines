package com.dhananjay.moviesmines;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    WebView browser;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = "http://moviesmines.com/ddt";
        browser = findViewById(R.id.webView);

        browser.setWebViewClient(new MyBrowser());
        browser.loadUrl(url);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setAppCacheEnabled(true);



    }

    @Override
    public void onBackPressed() {
        if (browser.canGoBack()){
            browser.goBack();
        }
        else {
            finish();
        }
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
