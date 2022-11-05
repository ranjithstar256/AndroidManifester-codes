package kp.ranjith.raguclasscodes;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class WebviewExample extends AppCompatActivity {
    WebView webView;
    EditText editText;
    String addr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_example);
        webView = findViewById(R.id.webv);
        editText = findViewById(R.id.editText4);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://www.androidmanifester.in");

        webView.setWebChromeClient(new WebChromeClient() {
            private ProgressDialog mProgress;

            @Override
            public void onProgressChanged(WebView view, int progress) {
                if (mProgress == null) {
                    mProgress = new ProgressDialog(WebviewExample.this);
                    mProgress.show();
                }
                mProgress.setMessage("Loading " + progress + "%");
                if (progress == 100) {
                    mProgress.dismiss();
                    mProgress = null;
                }
            }
        });
    }

    public void india(View view) {
        addr = editText.getText().toString();
        webView.loadUrl(addr);

    }

}
