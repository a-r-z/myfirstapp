package com.example.myfirstapp.presentation.detail

data class CovidDetailResponse (

        val Country: String,
        val Province: String,
        val Confirmed: Int,
        val Recovered: Int,
        val Deaths: Int,
        val Active: Int,
        val Date: String,
        val TotalConfirmed: Int
)