package com.example.scouthelicopter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"SetTextI18n", "SetJavaScriptEnabled", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView heli_cam_WebView = findViewById(R.id.heli_cam);
        Button reload_button = findViewById(R.id.reload_button);
        String heli_cam = "http://192.168.4.1";

        // Initialize WebView
        WebSettings webSettings = heli_cam_WebView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript

        heli_cam_WebView.getSettings().setBuiltInZoomControls(true); // Enable built-in zoom controls
        webSettings.setDisplayZoomControls(false);

        heli_cam_WebView.getSettings().setSupportZoom(true); // Enable gesture zoom
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        heli_cam_WebView.setWebViewClient(new WebViewClient());
        heli_cam_WebView.loadUrl(heli_cam);

        // Refresh button action
        reload_button.setOnClickListener(v -> heli_cam_WebView.reload());
    }
}