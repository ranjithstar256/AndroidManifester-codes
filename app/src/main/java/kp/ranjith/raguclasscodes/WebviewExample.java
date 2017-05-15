package kp.ranjith.raguclasscodes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebviewExample extends AppCompatActivity {
    WebView webView;
    EditText editText;
    String addr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_example);
        webView= (WebView) findViewById(R.id.webv);
        editText= (EditText) findViewById(R.id.editText4);
        webView.loadUrl("http://www.androidmanifester.com");
        webView.scrollTo(1000,50);

        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                webView.scrollTo(1000,50);
            }
        });

    }

    public void loadur(View view) {
        addr=editText.getText().toString();
        webView.loadUrl(addr);
    }
}
