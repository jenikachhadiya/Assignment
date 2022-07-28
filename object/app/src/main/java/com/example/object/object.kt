package com.example.objects

import android.os.Parcel
import android.os.Parcelable

data class objects(var name: String, var email: String):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<objects> {
        override fun createFromParcel(parcel: Parcel): objects {
            return objects(parcel)
        }

        override fun newArray(size: Int): Array<objects?> {
            return arrayOfNulls(size)
        }
    }

}
