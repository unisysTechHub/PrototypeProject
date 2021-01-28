package com.unisytech.prototypeproject.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.LayoutAnimationController
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.unisytech.prototypeproject.R
import kotlin.reflect.jvm.internal.impl.util.Check


/**
 * Created by ramesh on 21/01/21.
 */


 fun linerLayout(context: Context) : LinearLayout {
     var view = LinearLayout(context)
     view.orientation = LinearLayout.HORIZONTAL
     var layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
     view.layoutParams = layoutParams

     return  view
 }
fun constraintLayout(context: Context) : ConstraintLayout {
    val view = ConstraintLayout(context)
    var layoutparams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.WRAP_CONTENT)
    view.layoutParams = layoutparams
    return  view
}
fun customTextView(context: Context ) : TextView {
    val textView = TextView(context)
    val layoutParams = ConstraintLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)


    layoutParams.setMargins(8,4,8,4)
    textView.layoutParams = layoutParams
    val typeface: Typeface? = ResourcesCompat.getFont(context,R.font.robotobold);
    textView.setTypeface(typeface, Typeface.BOLD)
    textView.setTextColor(context.resources.getColor(R.color.black))
    return textView
}

@RequiresApi(Build.VERSION_CODES.O)
fun checkBox(context: Context) : CheckBox {
    val checkBox  = CheckBox(context)
    val layoutParams = ConstraintLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

    layoutParams.setMargins(0,0,0,8)
    checkBox.focusable = CheckBox.NOT_FOCUSABLE
    checkBox.layoutParams = layoutParams
    return  checkBox
}

@RequiresApi(Build.VERSION_CODES.O)
fun imageView(context: Context) : ImageView {
    var imageView = ImageView(context)
    var layoutParams = ConstraintLayout.LayoutParams(100, 100)
    imageView.layoutParams = layoutParams

return imageView
}
