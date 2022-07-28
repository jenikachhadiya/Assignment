package com.example.fregmentobj

import android.os.Parcel
import android.os.Parcelable

data class objPass(var name :String,var email :String,var age :Int):Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt().toInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<objPass> {
        override fun createFromParcel(parcel: Parcel): objPass {
            return objPass(parcel)
        }

        override fun newArray(size: Int): Array<objPass?> {
            return arrayOfNulls(size)
        }
    }

}