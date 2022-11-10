package com.example.android.marsrealestate.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


// Add  base URL for the web service.
private const val BASE_URL = "https://mars.udacity.com/"

// TODO (02) Use Retrofit Builder with ScalarsConverterFactory and BASE_URL
// Add a Retrofit builder to build and create a Retrofit object.
private val retrofit = Retrofit.Builder()
// converter factory to build a web services API
// The converter tells Retrofit what to do with the data it gets back from the web service
// Retrofit to fetch a JSON response from the web service, and return it as a String
// Retrofit has a ScalarsConverter that supports strings and other primitive types,
    .addConverterFactory(ScalarsConverterFactory.create())

// Add the base URI for the web service using baseUrl() method
    .baseUrl(BASE_URL)

//call build() to create the Retrofit object.
    .build()


// TODO (03) Implement the MarsApiService interface with @GET getProperties returning a String
// interface talks to the web server using HTTP requests.
interface MarsApiService {
    //get string from the web service.
    @GET("realestate")
    fun getProperties(): Call<String>
}

// TODO (04) Create the MarsApi object using Retrofit to implement the MarsApiService
// In kotlin, object declarations are used to declare singleton objects.
// Singleton pattern ensures that one, and only one, instance of an object is created,
// has one global point of access to that object
// Object declaration's initialization is thread-safe and done at first access.
// Object declaration

// This is the public singleton object that can be accessed from the rest of the app.
object MarsApi {
    // You make this lazy initialization, to make sure it is initialized at its first usage.
        val retrofitService : MarsApiService by lazy {
            retrofit.create(MarsApiService::class.java)
        }
    }

