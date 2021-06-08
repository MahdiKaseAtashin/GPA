package com.mahdikaseatashin.gpa.ui

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mahdikaseatashin.gpa.R
import com.mahdikaseatashin.gpa.databinding.ActivityDetailsBinding
import com.mahdikaseatashin.gpa.models.NodeModel
import com.mahdikaseatashin.gpa.utils.Constants


class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private var selectedNode: NodeModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentExtras()

        setSupportActionBar(findViewById(R.id.collapsing_toolbar_details))
        binding.toolbarLayoutDetails.title = selectedNode?.full_name

        Glide.with(this).load(selectedNode?.owner?.avatar_url)
            .into(binding.ivNodeDetails)

        val wv = findViewById<View>(R.id.wv_html_url) as WebView
        selectedNode?.owner?.let { wv.loadUrl(it.html_url) }
        wv.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                binding.pbLoadingWebView.visibility = View.GONE
            }
        }
    }

    private fun getIntentExtras() {
        selectedNode = intent?.getParcelableExtra(Constants.SELECTED_NODE_KEY)
    }
}
