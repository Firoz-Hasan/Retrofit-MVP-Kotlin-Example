package com.example.firozhasan.retrofitkotlinexample.`interface`

interface CountryInterface {

    interface countryModel {
        fun getCountyNameByCapital(city: String, presenter: countryPresenter)
        fun getCountry(): String
    }

    interface countryView {
        fun updateViewData()

    }

    interface countryPresenter {
        fun networkcall(city: String)
        fun showCountry() : String
        fun uiAutoUpdate()
    }
}