package com.example.myfirstapp.presentation.list
import com.example.myfirstapp.presentation.api.CovidResponse
sealed class CovidModel
data class CovidSucess(val covidList : List<CovidResponse>) : CovidModel()
object CovidLoader: CovidModel()
object CovidError: CovidModel()