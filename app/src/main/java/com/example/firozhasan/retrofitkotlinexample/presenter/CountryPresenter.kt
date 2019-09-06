package com.example.firozhasan.retrofitkotlinexample.presenter

import com.example.firozhasan.retrofitkotlinexample.`interface`.CountryInterface
import com.example.firozhasan.retrofitkotlinexample.model.repos.countryRepos

class CountryPresenter(countryView: CountryInterface.countryView) : CountryInterface.countryPresenter {


    private var view: CountryInterface.countryView = countryView
    private var model: CountryInterface.countryModel = countryRepos()

    init {
      //  countryView.initView()
    }

    override fun networkcall(city: String) {
        model?.getCountyNameByCapital(city)
        view.updateViewData()
    }

    override fun showCountry() = model.getCountry()

}