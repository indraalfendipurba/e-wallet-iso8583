package com.example.e_wallet12021996ver1.ewallet

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.e_wallet12021996ver1.R
import kotlinx.android.synthetic.main.activity_layar_fundusage.*

class LayarFundusage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layar_fundusage)

        fundanakt2.setOnClickListener {

            startActivity(Intent(this, FundAnak1::class.java))

        }

        fundorangtuat.setOnClickListener {

            startActivity(Intent(this, FundOrangtua::class.java))

        }
    }
}
