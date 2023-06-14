package com.first.bayraksoruproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        veritabaniKopyala()


        button.setOnClickListener {
            startActivity(Intent(this@MainActivity,SoruSayfasi::class.java))
        }
    }
    fun veritabaniKopyala(){
        val copyHelper=DatabaseCopyHelper(this@MainActivity)


        try {

            copyHelper.createDataBase()
            copyHelper.openDataBase()

        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}