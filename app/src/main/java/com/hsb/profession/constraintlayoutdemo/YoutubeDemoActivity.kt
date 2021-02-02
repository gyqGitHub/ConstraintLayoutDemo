package com.hsb.profession.constraintlayoutdemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hsb.profession.adapter.FrontPhotosAdapter

class YoutubeDemoActivity : AppCompatActivity() {


    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, YoutubeDemoActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_demo)
        findViewById<RecyclerView>(R.id.recyclerview_front).apply {
            adapter = FrontPhotosAdapter()
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@YoutubeDemoActivity)
        }
    }
}