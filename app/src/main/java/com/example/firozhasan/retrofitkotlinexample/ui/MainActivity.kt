package com.example.firozhasan.retrofitkotlinexample.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firozhasan.retrofitkotlinexample.R
import com.example.firozhasan.retrofitkotlinexample.api.JobAPI
import com.example.firozhasan.retrofitkotlinexample.api.JobServices
import com.example.firozhasan.retrofitkotlinexample.models.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var apiclient: JobServices? = null
    private var capitalET: EditText? = null
    private var findBTN: Button? = null
    private var countryTV : TextView? = null
    private var capitalName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
        findBTN?.setOnClickListener {
            capitalName = capitalET!!.text!!.toString()
            Log.d("countyname", capitalName)
            getCountyDetailsByCapital(capitalName!!)
        }
    }


    fun initialize() {
        apiclient = JobAPI.client.create(JobServices::class.java)
        capitalET = findViewById(R.id.editText)
        findBTN = findViewById(R.id.button)
        countryTV = findViewById(R.id.textView)
    }

    fun getCountyDetailsByCapital(capital: String) {
        val call = apiclient?.getKountry(capital)

        call?.enqueue(object : Callback<List<Country>> {
            override fun onFailure(call: Call<List<Country>>?, t: Throwable?) {
                Log.d("countyname", t.toString())
            }

            override fun onResponse(call: Call<List<Country>>?, response: Response<List<Country>>?) {
                if (response?.isSuccessful!!) {
                    var results = response?.body()?.get(0)?.name
                    Log.d("countyname", results)
                    countryTV?.setText(results)
                }


            }


        })
    }
}

