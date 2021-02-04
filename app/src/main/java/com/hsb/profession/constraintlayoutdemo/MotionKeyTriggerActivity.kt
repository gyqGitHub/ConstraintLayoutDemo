package com.hsb.profession.constraintlayoutdemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_motion_key_trigger.*
import kotlin.math.abs

class MotionKeyTriggerActivity : AppCompatActivity() {

    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, MotionKeyTriggerActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_key_trigger)

        fab.postDelayed({fab.hide()},1000)
//        fab.postDelayed({fab.hide()},10)
        fab.postDelayed({fab.show()},2000)
        fab.postDelayed({fab.hide()},4000)
        fab.postDelayed({fab.show()},6000)

        motionLayout.addTransitionListener(object :MotionLayout.TransitionListener{
            override fun onTransitionTrigger(p0: MotionLayout?, triggerId: Int, positive: Boolean, progress: Float) {
                Log.e("gyq","onTransitionTrigger triggerId = $triggerId positive = $positive progress = $progress")
                val positiveDis = abs(progress-0.8f)
                val negativeDis = abs(progress-0.2f)
                Log.e("gyq","positiveDis = $positiveDis  negativeDis = $negativeDis")
                if(positive){
                    if(negativeDis>positiveDis){
//                        fab.visibility = View.GONE
                        Log.e("gyq","hide")
                        fab.hide()
                    }
                }else{
                    if(negativeDis<=positiveDis){
                        Log.e("gyq","show")
//                        fab.visibility = View.VISIBLE
                        fab.show()
                    }
                }
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
//                Log.e("gyq", "progress = $p3")
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
            }

        })
    }
}