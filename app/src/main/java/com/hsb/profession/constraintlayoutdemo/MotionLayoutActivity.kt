package com.hsb.profession.constraintlayoutdemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_motion_layout.*

class MotionLayoutActivity : AppCompatActivity() {

    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, MotionLayoutActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_layout)

        btn_basic_1.setOnClickListener { MotionBasic1Activity.start(this) }

        btn_basic_2.setOnClickListener { MotionBasic2Activity.start(this) }

        btn_custom_attribute.setOnClickListener { MotionCustomAttributeActivity.start(this) }

        btn_keyframe_position.setOnClickListener { MotionKeyFrame1Activity.start(this) }

        btn_keyframe_attribute.setOnClickListener { MotionKeyAttributeActivity.start(this) }

        btn_keyframe_cycle.setOnClickListener { MotionKeyCycleActivity.start(this) }

        btn_coordinator_1.setOnClickListener { MotionCoordinator1Activity.start(this) }

        btn_coordinator_2.setOnClickListener { MotionCoordinator2Activity.start(this) }

        btn_drawerLayout.setOnClickListener { MotionDrawerLayoutActivity.start(this) }

        btn_drawerLayout2.setOnClickListener { MotionDrawerLayout2Activity.start(this) }

        btn_sidePanel.setOnClickListener { MotionSidePanelActivity.start(this) }

        btn_viewPager.setOnClickListener { MotionViewPagerActivity.start(this) }

        btn_imitate_coordinator.setOnClickListener { MotionComplexImitateCoordinatorActivity.start(this) }

        btn_imitate_coordinator2.setOnClickListener { MotionComplexImitateCoordinator2Activity.start(this) }

        btn_helper.setOnClickListener { MotionConstraintHelperActivity.start(this) }

        btn_fragment.setOnClickListener { MotionFragmentActivity.start(this) }

        btn_youtube.setOnClickListener { YoutubeDemoActivity.start(this) }

        btn_keyTrigger.setOnClickListener { MotionKeyTriggerActivity.start(this) }
    }
}