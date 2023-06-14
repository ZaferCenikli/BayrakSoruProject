package com.first.bayraksoruproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bitis_sayfasi2.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


      button6.setOnClickListener {
          startActivity(Intent(this@MainActivity2,SoruSayfasi::class.java))
      }

        val dogrusayac=intent.getIntExtra("dogruSayac",0)

        textView7.text="${dogrusayac}Doğru ${5-dogrusayac} Yanlış"
        textView8.text="%${dogrusayac*100/5} Başarı"
    }
}