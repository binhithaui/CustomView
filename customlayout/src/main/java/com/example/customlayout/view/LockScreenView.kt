package com.example.customlayout.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.customlayout.R

class LockScreenView : LinearLayout, AdapterKeyBoard.OnClickIemButtonKeyboard {

    private var mRecyclerKeyboard: RecyclerView? = null
    private var mTvClock: TextClock? = null
    private var mTvTitle: TextView? = null
    private var mTvContent: TextView? = null

    private var mAdapterKeyBoard: AdapterKeyBoard? = null

    constructor(context: Context?) : super(context) {
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView()
    }

    private fun initView() {
        mAdapterKeyBoard = AdapterKeyBoard()
        mAdapterKeyBoard!!.setOnClickItemButtonKeyboard(this)
        inflate(context!!, R.layout.lock_screen_layout, null)
        this.mRecyclerKeyboard = findViewById<RecyclerView>(R.id.mRecycle_Button).apply {
            setHasFixedSize(true)
            clipToPadding = false
            layoutManager = GridLayoutManager(context!!, 3)
            adapter = mAdapterKeyBoard
        }
    }

    override fun onClickButton(position: Int) {
        Toast.makeText(context!!, "Clicked", Toast.LENGTH_SHORT).show()
    }
}