package com.tacho.app;

import com.getcapacitor.BridgeActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class MainActivity extends BridgeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Configure WebView to ignore mixed content warnings
        configureWebView();
    }
    
    private void configureWebView() {
        try {
            WebView webView = bridge.getWebView();
            if (webView != null) {
                WebSettings webSettings = webView.getSettings();
                webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
                webSettings.setAllowFileAccess(true);
                webSettings.setAllowContentAccess(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setJavaScriptEnabled(true);
            }
        } catch (Exception e) {
            System.out.println("Could not configure WebView: " + e.getMessage());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

