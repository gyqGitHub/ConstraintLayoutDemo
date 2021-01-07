package com.hsb.profession.constraintlayoutdemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_flow.*

class FlowActivity : AppCompatActivity() {

    private var mFlowWrapMode:Int = Flow.WRAP_NONE

    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, FlowActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)

        initListener()
    }

    private fun initListener() {
        //整块Flow，只需注意Flow控件的属性就行了
        btn_change_mode.setOnClickListener {
            mFlowWrapMode = when(mFlowWrapMode){
                Flow.WRAP_NONE->{
                    tv_mode.text = "WRAP_CHAIN"
                    Flow.WRAP_CHAIN
                }
                Flow.WRAP_CHAIN->{
                    tv_mode.text = "WRAP_ALIGNED"
                    Flow.WRAP_ALIGNED
                }
                Flow.WRAP_ALIGNED->{
                    tv_mode.text = "WRAP_NONE"
                    Flow.WRAP_NONE
                }
                else->0
            }
            flow.setWrapMode(mFlowWrapMode)
        }


    }
}