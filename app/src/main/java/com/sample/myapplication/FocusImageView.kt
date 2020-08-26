package com.sample.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import android.widget.ImageView

class FocusImageView(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int
): ImageView(context, attrs, defStyleAttr), FocusView {

    override val nextFocusUpLeftId = View.NO_ID
    override val nextFocusUpRightId = View.NO_ID
    override val nextFocusDownLeftId = View.NO_ID
    override val nextFocusDownRightId = View.NO_ID

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (handleFocusMove(keyCode, event)) {
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}
