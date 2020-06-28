package com.example.flickrbrowser

import android.os.AsyncTask
import android.util.Log
import org.json.JSONObject

private const val TAG = "GetFlickrJsonData"

class GetFlickrJsonData(private val listener: OnDataAvailale): AsyncTask<String, Void, ArrayList<Photo>>() {

    interface OnDataAvailale {
        fun onDataAvailable(data: List<Photo>)
        fun onError(exception: Exception)
    }

    override fun doInBackground(vararg params: String?): ArrayList<Photo> {
        Log.d(TAG, "doInBackground starts")

        val photos = ArrayList<Photo>()
        try {
            val jsonData = JSONObject(params[0])
            val itemsArray = jsonData.getJSONArray("items")
            for (i in 0 until itemsArray.length()) {
                val jsonPhoto = itemsArray.getJSONObject(i)
                val title = jsonPhoto.getString("title")
                val author = jsonPhoto.getString("author")
                val authorID = jsonPhoto.getString("author_id")
                val tags = jsonPhoto.getString("tags")

                val jsonMedia = jsonPhoto.getJSONObject("media")
                val photoUrl = jsonMedia.getString("m")
                val link = photoUrl.replaceFirst("_m.jpg", "_b.jpg")

                val photoObject = Photo(title, author, authorID, link, tags, photoUrl)
                photos.add(photoObject)
                Log.d(TAG, "doInBackground $photoObject")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, "doInBackground Error processing JSON data: ${e.message}")
            cancel(true)
            listener.onError(e)
        }

        Log.d(TAG, "doInBackground ends")
        return photos
    }

    override fun onPostExecute(result: ArrayList<Photo>) {
        Log.d(TAG, "onPostExecute starts")
        listener.onDataAvailable(result)
        Log.d(TAG, "onPostExecute ends")
    }
}