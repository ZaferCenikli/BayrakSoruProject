package com.first.bayraksoruproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bitis_sayfasi2.*

class BitisSayfasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitis_sayfasi2)
        button5.setOnClickListener {
            startActivity(Intent(this@BitisSayfasi,SoruSayfasi::class.java))
            finish()

            val dogrusayac=intent.getIntExtra("dogruSayac",0)

            textView4.text="${dogrusayac}Doğru ${5-dogrusayac} Yanlış"
            textView5.text="%${dogrusayac*100/5} Başarı"


        }
    }
}