package net.play.club.daggertest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


import net.play.club.daggertest.dependence.DaggerMeiziComponent;
import net.play.club.daggertest.dependence.DaggerPageComponent;
import net.play.club.daggertest.dependence.DaggerPersonComponent;
import net.play.club.daggertest.dependence.entity.MeiZi;
import net.play.club.daggertest.modle.entity.Pot;
import net.play.club.daggertest.webview.JsIntenrfaceObject;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    //    @Inject
//    Pot mPot;
//地址
    private String url = "http://192.168.1.131:8080/index.html";
//    private String url = "http://www.baidu.com";

    @Inject
    MeiZi mMeiZi;
    private WebView mWebView;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d("DaggerTest", "------------------------------");
//        DaggerMainActivityComponent.create().inject(this);

//        DaggerMainComponent.create().inject(this);
//        Log.d("DaggerTest", mPot.show());

        DaggerPageComponent.builder()
                .meiziComponent(DaggerMeiziComponent.builder()
                        .personComponent(DaggerPersonComponent.create())
                        .build())
                .build().inject(this);
        Log.d("DaggerTest", mMeiZi.show());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mWebView = (WebView) findViewById(R.id.mWebView);
        pb = (ProgressBar) findViewById(R.id.pb);

        //加载网页
        mWebView.loadUrl(url);

        //本地显示
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //支持JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);
        //本地客户端
        mWebView.setWebChromeClient(new WebChromeClient() {
            //提示框
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                //本地对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("温馨提示:");
                //服务器端
                builder.setMessage(message);
                //按钮
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //确认操作
                        result.confirm();
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        result.cancel();
                    }
                });
                builder.show();
                return true;
            }
        });
        mWebView.setWebChromeClient(new WebViewChromeClient());
        mWebView.setDrawingCacheEnabled(false);
        mWebView.addJavascriptInterface(new JsIntenrfaceObject(), "JsObject");
    }

    class WebViewChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            pb.setProgress(newProgress);
            if (newProgress == 100) {
//                pb.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }
    }

    public void setPot(Pot pPot) {
        Log.d("DaggerTest", "+++++++++++++++++++++++++++++++");
//        this.mPot = pPot;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
