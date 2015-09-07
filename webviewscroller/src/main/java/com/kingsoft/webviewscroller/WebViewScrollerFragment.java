package com.kingsoft.webviewscroller;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;

/**
 * Created by sunshaogang on 9/7/15.
 */
public class WebViewScrollerFragment extends Fragment {

    private String homepageUrl = "https://www.baidu.com";
    private View mRootView;
    private WebView mWebView;
    private ListView mListView;
    public WebViewScrollerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.webview_scroller_fragment, container, false);
        mWebView = (WebView) mRootView.findViewById(R.id.article_content);
        mListView = (ListView) mRootView.findViewById(R.id.article_comments);
        initWebView();
        return mRootView;
    }
    private void initWebView() {
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.getSettings().setJavaScriptEnabled(true);

//        //
        mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
//        // 开启 DOM storage API 功能
        mWebView.getSettings().setDomStorageEnabled(true);
//        //开启 database storage API 功能
        mWebView.getSettings().setDatabaseEnabled(true);
//        //开启 Application Caches 功能
        mWebView.getSettings().setAppCacheEnabled(true);
//        //
//        mWebView.addJavascriptInterface(new FeedbackJSCallback(), JAVA_SCRIPT_OBJECT_NAME);
        mWebView.loadUrl(homepageUrl);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!homepageUrl.equals(url)) {
//                    ((FeedbackHomeActivity) getActivity()).setFeedbackHome(false);
//                    hideButtonsLayout();
                }
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mListView.setVisibility(View.VISIBLE);
                if (!homepageUrl.equals(url)){
//                    hideButtonsLayout();
                } else {
//                    showButtonsLayout();
                }
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

//        mWebView.setOnCustomScroolChangeListener(new ViewPagerWebView.ScrollInterface() {
//            @Override
//            public void onSChanged(int l, int t, int oldl, int oldt) {
//                //WebView的总高度
//                float webViewContentHeight = mWebView.getContentHeight() * mWebView.getScale();
//                //WebView的现高度
//                float webViewCurrentHeight = (mWebView.getHeight() + mWebView.getScrollY());
//                if (mWebView.getScrollY() < 5) {
//                    ((FeedbackHomeActivity)getActivity()).setObtionUpEvent(false);
//                } else if ((webViewContentHeight - webViewCurrentHeight) == 0) {
//                    ((FeedbackHomeActivity)getActivity()).setObtionDownEvent(false);
//                } else {
//                    ((FeedbackHomeActivity)getActivity()).setObtionDownEvent(true);
//                    ((FeedbackHomeActivity)getActivity()).setObtionUpEvent(true);
//                }
//            }
//        });
    }
}
