package com.example.likemypost

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var up:Int = 0
    var down:Int = 0
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)

        imageViewThumbsUp.setOnClickListener {
            up++
            textViewThumbsUp.text = up.toString()
        }

        imageViewThumbsDown.setOnClickListener {
            down++
            textViewThumbsDown.text = down.toString()
        }

        Log.d("MainActivity","onCreate")
    }

    override fun onResume() {
        Log.d("MainActivity","onResume")
        super.onResume()

        //Retrieve counters from SharedPref
        up = sharedPreferences.getInt(getString(R.string.likeNo),0)
        down = sharedPreferences.getInt(getString(R.string.dislikeNo),0)
        textViewThumbsUp.text = up.toString()
        textViewThumbsDown.text = down.toString()

    }

    override fun onPause() {
        Log.d("MainActivity","onPause")
        with(sharedPreferences.edit()){
            putInt(getString(R.string.likeNo), up)
            putInt(getString(R.string.dislikeNo), down)
            apply()
        }
        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity","onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }

    companion object{

    }
}
