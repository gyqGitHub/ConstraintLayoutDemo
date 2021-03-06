package com.hsb.profession.constraintlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_flow.setOnClickListener { FlowActivity.start(this) }

        btn_layer.setOnClickListener { LayerActivity.start(this) }

        btn_custom_helper.setOnClickListener { ConstraintHelperActivity.start(this) }

        btn_image_filter.setOnClickListener { ImageFilterActivity.start(this) }

        btn_motion.setOnClickListener { MotionLayoutActivity.start(this) }
    }
}