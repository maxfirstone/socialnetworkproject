package com.example.aprendiendoxml2

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

object WebServices {

}


// CODE BEFORE COROUTINES IMPLEMENTATION //

// call.enqueue(
//  object : Callback {
//   override fun onFailure(call: Call, e: IOException) {
//   println(e.message)
//   return
//  }

//  override fun onResponse(call: Call, response: Response) {
//    response.use {
//      if (!response.isSuccessful) {
//       callback(false, "Authentication Error!")
//   return
//  }

// val responseData = response.body?.string()
// val jsonResponse = JSONObject(responseData)
// val token = jsonResponse.optString("token", null.toString())
// if (token != null) {
// callback(true, token)
// } else {
// callback(false, "Incorrect Credentials!")
//}
//}
//}

//})
