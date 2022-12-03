package com.example.multipal_recycleview.ClickEvent

import com.example.multipal_recycleview.Modal.Recycle

interface OnItemClick {

    fun onCardClick(recycle:Recycle,pos:Int)

}