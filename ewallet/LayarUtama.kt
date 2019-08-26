package com.example.e_wallet12021996ver1.ewallet

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.e_wallet12021996ver1.R
import kotlinx.android.synthetic.main.activity_layar_utama.*

class LayarUtama : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layar_utama)

        orangtuat.setOnClickListener{

            startActivity(Intent(this, LayarLogin1::class.java))

        }

        anakt.setOnClickListener {

            startActivity(Intent(this, LayarLogin2::class.java))

        }
    }
}
