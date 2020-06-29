package com.example.flickrbrowser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.IOException
import java.io.ObjectStreamClass
import java.io.ObjectStreamException
import java.io.Serializable

@Parcelize
class Photo(var title: String, var author: String, var authorID: String, var link: String, var tags: String, var image: String): Parcelable {

    override fun toString(): String {
        return "Photo(title='$title', author='$author', link='$link', tags='$tags', image='$image')"
    }
}