package com.example.firozhasan.retrofitkotlinexample.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.model.api.JobAPI
import com.example.firozhasan.retrofitkotlinexample.model.api.JobServices
import com.example.firozhasan.retrofitkotlinexample.model.modelClass.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.firozhasan.retrofitkotlinexample.`interface`.CountryInterface
import com.example.firozhasan.retrofitkotlinexample.model.repos.countryRepos
import com.example.firozhasan.retrofitkotlinexample.presenter.CountryPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), CountryInterface.countryView {


    override fun updateViewData() {
        textView.setText(presenter?.showCountry())
    }




    private var capitalET: EditText? = null
    private var findBTN: Button? = null
    private var countryTV : TextView? = null
    private var capitalName: String? = null
    private var presenter: CountryPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initialize()
        findBTN?.setOnClickListener {
            capitalName = capitalET!!.text!!.toString()
            Log.d("countynameMain", capitalName)
            presenter?.networkcall(capitalName!!)
        }
    }


    fun initialize() {
        presenter = CountryPresenter(this)
        capitalET = findViewById(R.id.editText)
        findBTN = findViewById(R.id.button)
        countryTV = findViewById(R.id.textView)
    }


}

