package com.example.recyclerview

/*
* This is a model class in kotlin
* delete the curly braces cause class won't have a body
* change class to data class (It's kotlin way of making class that is supposed to only old data)
* We can install plugin json to kotlin and convert json directly to kotlin data class*/
data class ExampleItem(
    val imageResource: Int,
    val text1: String,
    val text2: String
)