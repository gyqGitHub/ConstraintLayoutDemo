package com.hsb.profession.constraintlayoutdemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.hsb.profession.fragment.MainFragment
import com.hsb.profession.fragment.SecondFragment
import kotlinx.android.synthetic.main.activity_motion_fragment.*

class MotionFragmentActivity : AppCompatActivity(),MotionLayout.TransitionListener {

    private var lastProgress = 0f
    private var fragment : Fragment? = null

    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, MotionFragmentActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_fragment)
        motionLayout?.setTransitionListener(this)
        if (savedInstanceState == null) {
            fragment = MainFragment.newInstance().also {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, it)
                    .commitNow()
            }
        }
    }

    override fun onTransitionTrigger(p0: MotionLayout?, triggerId: Int, positive: Boolean, progress: Float) {
        Log.e("gyq","onTransitionTrigger triggerId = $triggerId positive = $positive progress = $progress")
    }

    override fun onTransitionStarted(p0: MotionLayout?, startId: Int, endId: Int) {
        Log.e("gyq","onTransitionStarted startId = $startId endId = $endId")
    }

    override fun onTransitionChange(p0: MotionLayout?, startId: Int, endId: Int, progress: Float) {
        Log.e("gyq","onTransitionChange startId = $startId p2 = $endId progress = $progress")
        if (progress - lastProgress > 0) {
            // from start to end
            val atEnd = Math.abs(progress - 1f) < 0.1f
            if (atEnd && fragment is MainFragment) {
                val transaction = supportFragmentManager.beginTransaction()
                //todo 没搞清动画的使用，动画也会略带卡顿
                fragment = SecondFragment.newInstance().also {
                    transaction
                        .setCustomAnimations(R.animator.show, 0)
                        .replace(R.id.container, it)
                        .commitNow()
                }
            }
        } else {
            // from end to start
            val atStart = progress < 0.9f
            if (atStart && fragment is SecondFragment) {
                val transaction = supportFragmentManager.beginTransaction()
                fragment = MainFragment.newInstance().also {
                    transaction
                        .setCustomAnimations(0, R.animator.hide)
                        .replace(R.id.container, it)
                        .commitNow()
                }
            }
        }
        lastProgress = progress
    }

    override fun onTransitionCompleted(p0: MotionLayout?, currentId: Int) {
        Log.e("gyq","onTransitionCompleted currentId = $currentId")
    }
}