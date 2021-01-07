package com.hsb.profession.constraintlayoutdemo

import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewPropertyAnimator
import kotlinx.android.synthetic.main.activity_layer.*

/**
 * 1.设置Layer的背景
 * 2.设置Layer整块的显示隐藏以及动画
 */
class LayerActivity : AppCompatActivity() {

    private lateinit var mAnimator: ViewPropertyAnimator

    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, LayerActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layer)

        //注意：下面两种动画对layer的作用是不一样的
        //mAnimator 只对layer本身起作用
        mAnimator = layer.animate()
            .setDuration(6000)
//            .withLayer()
            .rotation(360f)
        //tempAnimator 只对layer包含的内容有作用，对layer本身不起作用
        val tempAnimator = ValueAnimator
            .ofFloat(0f,360f)
            .setDuration(3000)

        tempAnimator.addUpdateListener {
            layer.rotation = it.animatedValue as Float
        }
        img_head.setOnClickListener {
            tempAnimator.start()
        }
    }
}