package com.kotlin.goods

import android.widget.EditText
import com.kotlin.base.utils.ext.find
import ren.qinc.numberbutton.NumberButton
import ren.qinc.numberbutton.R

/*
    三方控件扩展
 */
fun NumberButton.getEditText():EditText{
    return find(R.id.text_count)
}
