package com.dicoding.eldenringwiki

import android.os.Bundle

class AboutActivity : GoBackActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }
}