package com.techpalle.myapplicationyoutube2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText  editText1,editText2;
    Button button1,button2;
    WebView  webview1;
    String string1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview1 = (WebView) findViewById(R.id.webview1);
        editText1 = (EditText) findViewById(R.id.edittext1);
        editText2 = (EditText) findViewById(R.id.edittext2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        webview1.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                String string1 = editText1.getText().toString();
                webview1.loadUrl("http://m.youtube.com/results?q="+string1);
                webview1.getSettings().setJavaScriptEnabled(true);
                webview1.setWebViewClient(new WebViewClient());
                return true;

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String string1 = editText1.getText().toString();
                webview1.loadUrl("http://m.youtube.com/results?q= "+string1);
                webview1.getSettings().setJavaScriptEnabled(true);
                webview1.setWebViewClient(new WebViewClient());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("id",editText2.getText().toString());
                startActivity(intent);
            }
        });
    }
}
