package com.kotlin.base.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.kotlin.base.R
import com.kotlin.base.common.GlideApp

/*
    Glide工具类
 */
object GlideUtils {
    fun loadImage(context: Context, url: String, imageView: ImageView) {
        GlideApp.with(context).load(url).centerCrop().into(imageView)
    }

    fun loadImageFitCenter(context: Context, url: String, imageView: ImageView) {
        GlideApp.with(context).load(url).fitCenter().into(imageView)
    }

    /*
        当fragment或者activity失去焦点或者destroyed的时候，Glide会自动停止加载相关资源，确保资源不会被浪费
     */
    fun loadUrlImage(context: Context, url: String, imageView: ImageView){
        val requestOptions: RequestOptions = RequestOptions()
                .placeholder(R.drawable.icon_back)
                .error(R.drawable.icon_back)
                .dontAnimate()
                .centerCrop()
        GlideApp.with(context)
                .load(url)
                .apply(requestOptions)
                .into(imageView)
    }
}
