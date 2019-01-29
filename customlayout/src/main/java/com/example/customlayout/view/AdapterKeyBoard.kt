package com.example.customlayout.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.customlayout.EnumButton
import com.example.customlayout.R

class AdapterKeyBoard : RecyclerView.Adapter<AdapterKeyBoard.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterKeyBoard.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_button, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = EnumButton.values().size

    override fun getItemId(position: Int): Long = position.toLong()

    override fun onBindViewHolder(holder: AdapterKeyBoard.ViewHolder, position: Int) {
        holder.bindView()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(v: View?) {
            onClickIemButtonKeyboard?.onClickButton(adapterPosition)
        }

        private val tvItem = itemView.findViewById<TextView>(R.id.mTextView_Item_Button_Keyboard)
        fun bindView() {
            when (adapterPosition) {
                EnumButton.BUTTON_0.getButton() -> {
                    tvItem.text = EnumButton.BUTTON_0.name
                }
                EnumButton.BUTTON_1.getButton() -> {
                    tvItem.text = EnumButton.BUTTON_1.name
                }
                EnumButton.BUTTON_2.getButton() -> {
                    tvItem.text = EnumButton.BUTTON_2.name
                }
                EnumButton.BUTTON_3.getButton() -> {
                    tvItem.text = EnumButton.BUTTON_3.name
                }
                EnumButton.BUTTON_4.getButton() -> {
                    tvItem.text = EnumButton.BUTTON_4.name
                }
                EnumButton.BUTTON_5.getButton() -> {
                    tvItem.text = EnumButton.BUTTON_5.name
                }
                EnumButton.BUTTON_6.getButton() -> {
                    tvItem.text = EnumButton.BUTTON_6.name
                }
                EnumButton.BUTTON_7.getButton() -> {
                    tvItem.text = EnumButton.BUTTON_7.name
                }
                EnumButton.BUTTON_8.getButton() -> {
                    tvItem.text = EnumButton.BUTTON_8.name
                }
                EnumButton.BUTTON_9.getButton() -> {
                    tvItem.text = EnumButton.BUTTON_9.name
                }
                EnumButton.BUTTON_BACK.getButton() -> {
                    tvItem.text = EnumButton.BUTTON_BACK.name
                }
                EnumButton.BUTTON_CLEAR.getButton() -> {
                    tvItem.text = EnumButton.BUTTON_CLEAR.name
                }
            }
            itemView.setOnClickListener(this)
        }
    }

    private var onClickIemButtonKeyboard: OnClickIemButtonKeyboard? = null
    fun setOnClickItemButtonKeyboard(obClickIemButtonKeyboard: OnClickIemButtonKeyboard) {
        this.onClickIemButtonKeyboard = onClickIemButtonKeyboard
    }

    interface OnClickIemButtonKeyboard {
        fun onClickButton(position: Int)
    }
}