package com.hsb.profession.constraintlayoutdemo

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.ViewAnimationUtils
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.constraintlayout.widget.ConstraintLayout

/**
 *
 * @author gyq
 * @date 2021/1/7
 */
class CustomerConstraintHelper :ConstraintHelper{
    constructor(context: Context):this(context,null)
    constructor(context: Context, attributeSet: AttributeSet?):this(context,attributeSet,0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int):super(context,attributeSet,defStyleAttr)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun updatePostLayout(container: ConstraintLayout?) {
        super.updatePostLayout(container)
        getViews(container).forEach { view ->
            ViewAnimationUtils.createCircularReveal(view,view.width/2,view.height/2,20f,view.width.toFloat()).run {
                duration = 5000
                start()
            }
        }
    }
}