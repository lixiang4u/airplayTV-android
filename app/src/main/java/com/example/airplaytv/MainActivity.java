package com.example.airplaytv;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.format.Time;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.airplaytv.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // 安卓4.4因let's encrypt的https证书问题无法运行
        openWebView();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void openWebView() {
        try {
            WebView webView1 = findViewById(R.id.webview1);
            webView1.getSettings().setJavaScriptEnabled(true);
            webView1.getSettings().setUseWideViewPort(true);
            webView1.getSettings().setLoadsImagesAutomatically(true);
            webView1.getSettings().setAllowFileAccess(true);

            webView1.getSettings().setDomStorageEnabled(true);
            webView1.getSettings().setAllowFileAccess(true);
            webView1.getSettings().setAppCacheEnabled(true);
            webView1.getSettings().setDatabaseEnabled(true);
            webView1.getSettings().setAppCachePath(getApplication().getCacheDir().getAbsolutePath());
            webView1.loadUrl("https://air.artools.cc/qr?from_android_tv_app");

        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Time.SECOND * 3).show();
        }
    }

}