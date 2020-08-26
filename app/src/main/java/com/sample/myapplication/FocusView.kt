package com.sample.myapplication

import android.view.KeyEvent
import android.view.View
import androidx.appcompat.widget.ContentFrameLayout

interface FocusView {

    val nextFocusUpLeftId: Int
    val nextFocusUpRightId: Int
    val nextFocusDownLeftId: Int
    val nextFocusDownRightId: Int
}

fun FocusView.handleFocusMove(keyCode: Int, event: KeyEvent?): Boolean {
    this as View
    when (keyCode) {
        KeyEvent.KEYCODE_DPAD_UP -> {
            moveFocusView(nextFocusUpId)
            return true
        }
        KeyEvent.KEYCODE_DPAD_UP_RIGHT -> {
            moveFocusView(nextFocusUpRightId)
            return true
        }
        KeyEvent.KEYCODE_DPAD_RIGHT -> {
            moveFocusView(nextFocusRightId)
            return true
        }
        KeyEvent.KEYCODE_DPAD_DOWN_RIGHT -> {
            moveFocusView(nextFocusDownRightId)
            return true
        }
        KeyEvent.KEYCODE_DPAD_DOWN -> {
            moveFocusView(nextFocusDownId)
            return true
        }
        KeyEvent.KEYCODE_DPAD_DOWN_LEFT -> {
            moveFocusView(nextFocusDownLeftId)
            return true
        }
        KeyEvent.KEYCODE_DPAD_LEFT -> {
            moveFocusView(nextFocusLeftId)
            return true
        }
        KeyEvent.KEYCODE_DPAD_UP_LEFT -> {
            moveFocusView(nextFocusUpLeftId)
            return true
        }
    }
    return false
}

private fun FocusView.moveFocusView(nextFocusId: Int) {
    findNextFocusView(nextFocusId)?.let{
        it.requestFocus()
    }
}

private fun FocusView.findNextFocusView(id: Int): View? {
    val root = findFucusRootView() ?: return null
    return root.findViewById(id)
}

private fun FocusView.findFucusRootView(): View? {
    var child = this as View
    while (child !is ContentFrameLayout) {
        if (child.id == R.id.rootView) return child
        child = child.parent as View
    }
    return null
}
