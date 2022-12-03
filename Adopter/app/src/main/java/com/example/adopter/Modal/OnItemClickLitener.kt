package com.example.adopter.Modal

import android.content.ClipData
//1.create interface
interface OnItemClickLitener {
//2.make mathod and pass paramiters
    fun OnCardClick(Item:ItemRecycle,pos :Int)

    fun OnImageClick(Item: ItemRecycle)


}