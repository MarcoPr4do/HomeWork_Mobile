package com.silver.homework3.ui.adapter

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class RecycleTouchListener (context: Context, recyclerView: RecyclerView, private val recyclerClickListener: RecyclerClickListener?) : RecyclerView.OnItemTouchListener{
    private val gestureDetector: GestureDetector

    init {
        gestureDetector = GestureDetector(context, object: GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return true
            }

            override fun onLongPress(e: MotionEvent) {
                val child = recyclerView.findChildViewUnder(e.x, e.y)
                if (child != null && recyclerClickListener != null){
                    recyclerClickListener.onLongClick(child, recyclerView.getChildLayoutPosition(child))
                }
            }
        })
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val child = rv.findChildViewUnder(e.x, e.y)
        if (child != null && recyclerClickListener != null && gestureDetector.onTouchEvent(e)){
            recyclerClickListener.onClick(child, rv.getChildPosition(child))
        }
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }
}