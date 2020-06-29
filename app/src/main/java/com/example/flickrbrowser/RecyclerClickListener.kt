package com.example.flickrbrowser

import android.content.Context
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "RecyclerClickListener"

class RecyclerClickListener(context: Context, recyclerView: RecyclerView, private val listener: OnRecyclerClickListener): RecyclerView.SimpleOnItemTouchListener() {

    interface OnRecyclerClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

    private val gestureDetector = GestureDetector(context, object: GestureDetector.SimpleOnGestureListener() {

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            val childView = recyclerView.findChildViewUnder(e.x, e.y)
            listener.onItemClick(childView!!, recyclerView.getChildAdapterPosition(childView))
            return true
        }

        override fun onLongPress(e: MotionEvent) {
            val childView = recyclerView.findChildViewUnder(e.x, e.y)
            listener.onItemLongClick(childView!!, recyclerView.getChildAdapterPosition(childView))
        }
    })

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        Log.d(TAG, "onInterceptTouchEvent called $e")
        val result = gestureDetector.onTouchEvent(e)
        return result
    }


}