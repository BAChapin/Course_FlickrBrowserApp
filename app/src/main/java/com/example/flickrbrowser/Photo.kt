package com.example.flickrbrowser

class Photo(val title: String, val author: String, authorID: String, val link: String, val tags: String, val image: String) {

    override fun toString(): String {
        return "Photo(title='$title', author='$author', link='$link', tags='$tags', image='$image')"
    }
}