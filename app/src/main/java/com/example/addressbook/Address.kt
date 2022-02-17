package com.example.addressbook

import android.os.Parcel
import android.os.Parcelable

class Address(
    var seq:Int,
    var name:String?,
    var address:String?,
    var tel:String?,
    var email:String?
) : Parcelable

{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(seq)
        parcel.writeString(name)
        parcel.writeString(address)
        parcel.writeString(tel)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Address> {
        override fun createFromParcel(parcel: Parcel): Address {
            return Address(parcel)
        }

        override fun newArray(size: Int): Array<Address?> {
            return arrayOfNulls(size)
        }
    }
}