package com.android.gumeoficial.websitekotl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    var mWebView : WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWebView = findViewById<View>(R.id.webView) as WebView
        mWebView!!.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        val webSettings = mWebView!!.getSettings()
        webSettings.setJavaScriptEnabled(true)
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK)
        webSettings.setAppCacheEnabled(true)
        webSettings.setDomStorageEnabled(true)
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS)
        webSettings.setUseWideViewPort(true)
        webSettings.setSavePassword(true)
        webSettings.setSaveFormData(true)
        webSettings.setEnableSmoothTransition(true)
        mWebView!!.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY)


        mWebView!!.loadUrl("https://developer.android.com")
    }

    override fun onBackPressed() {
        if (mWebView!!.canGoBack()){
            mWebView!!.goBack()
        }
        else {
            super.onBackPressed()
        }
    }
}
