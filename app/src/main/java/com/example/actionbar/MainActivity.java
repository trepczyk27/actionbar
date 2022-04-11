package com.example.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.web);
        webView.loadUrl("https://google.com/");
        webView.setWebViewClient(new WebViewClient());
        ActionBar actionBar = getSupportActionBar();




        // methods to display the icon in the ActionBar
        ((ActionBar) actionBar).setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);


    }
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected( @NonNull MenuItem item ) {

        switch (item.getItemId()){
            case R.id.back:

                webView.goBack();

                break;
            case R.id.refresh:
                webView.reload();
                break;
            case R.id.zoomIn:
                webView.zoomIn();
                break;
            case R.id.zoomOut:
                webView.zoomOut();
                break;
            case R.id.next:
                webView.goForward();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();

        }else{
            super.onBackPressed();
        }


    }
}