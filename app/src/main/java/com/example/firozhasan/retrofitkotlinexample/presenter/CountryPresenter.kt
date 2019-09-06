package com.example.firozhasan.retrofitkotlinexample.presenter

import android.os.Handler
import com.example.firozhasan.retrofitkotlinexample.`interface`.CountryInterface
import com.example.firozhasan.retrofitkotlinexample.model.repos.countryRepos

class CountryPresenter(countryView: CountryInterface.countryView) : CountryInterface.countryPresenter {
    override fun uiAutoUpdate() {
        view.updateViewData()
    }

    private var view: CountryInterface.countryView = countryView
    private var model: CountryInterface.countryModel = countryRepos()

    init {
        countryView.initView()
    }

    override fun networkcall(city: String) {
        model?.getCountyNameByCapital(city, this)

       /* Handler().postDelayed({
            *//* Create an Intent that will start the Menu-Activity. *//*
            view.updateViewData()
        }, 2000)*/
    }

    override fun showCountry() = model.getCountry()

}