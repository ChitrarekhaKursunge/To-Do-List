package com.firstaap.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWebView: WebView = findViewById(R.id.myWebView)

        myWebView.webViewClient = WebViewClient()

        val etURL: EditText = findViewById(R.id.etURL)

        val btnSearch: ImageView = findViewById(R.id.btnSearch)

        val btnHome: ImageView = findViewById(R.id.btnHome)
        btnHome.setOnClickListener {
            myWebView.loadUrl("https://www.google.com")
        }

        val btnLinkedin: ImageView = findViewById(R.id.btnLinkedin)
        btnLinkedin.setOnClickListener {
            myWebView.loadUrl("https://www.linkedin.com")
        }

        val btnFacebook: ImageView = findViewById(R.id.btnFacebook)
        btnFacebook.setOnClickListener {
            myWebView.loadUrl("https://www.facebook.com")
        }


        btnSearch.setOnClickListener {
            val url: String = etURL.text.toString()

            if (URLUtil.isValidUrl(url))
            {
                myWebView.loadUrl(url)
            }
            else{
                myWebView.loadUrl("https://www.google.com/search?q="+url)
            }

            myWebView.loadUrl(etURL.text.toString())

        }


        //enabling javascript
        myWebView.settings.javaScriptEnabled = true
    }
}