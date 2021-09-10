package com.example.antiquemall.util.abstractwrapper

import android.animation.Animator

/**
 * Created by Oguz Sahin on 9/8/2021.
 */
interface AbstractAnimatorAnimationListener : Animator.AnimatorListener {
    override fun onAnimationStart(animator: Animator?) {}

    override fun onAnimationEnd(animator: Animator?) {}

    override fun onAnimationCancel(animator: Animator?) {}

    override fun onAnimationRepeat(animator: Animator?) {}
}