package com.example.antiquemall.util.abstractwrapper

import android.view.animation.Animation

/**
 * Created by Oguz Sahin on 9/8/2021.
 */
interface AbstractAnimationListener : Animation.AnimationListener {
    override fun onAnimationEnd(animation: Animation?) {}

    override fun onAnimationRepeat(animation: Animation?) {}

    override fun onAnimationStart(animation: Animation?) {}
}