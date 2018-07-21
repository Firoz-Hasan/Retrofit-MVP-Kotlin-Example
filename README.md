# RetrofitKotlinExample
<b>Implementation of retrofit by using kotlin for understading </b>
<br>
<ol type="1">
<li>
In order to understand retrofit, first you have to check the API response thoroughly, there are several way response may come. For example,<br>
<ul>
<li>
  {  }  which means object<br>
</li>
<li>
  [  ] which means list <br>
  </li>
  <li>
  [ { },  { } , { },  { } , { },  { } ] which means list of objects<br>
  </li>
  <li>
[ { “data”  :  [ { }, { },  { } ]  } ] which means list of objects inside “data” object<br>
<li>
{<br>
    "page": 2,<br>
    "data": [<br>
        {<br>
            "id": 4,<br>
            "first_name": "Eve",<br>
            "last_name": "Holt",<br>
            },<br>
        {<br>
            "id": 5,<br>
            "first_name": "Charles",<br>
            "last_name": "Morris",<br>
          }
    ]
    } which means object contains list of objects 
</ul>
</li>
</li>
<li>
Generally it will be either @GET or @Post HTTP request method
  <ul>
<li>
@GET : you can see both key & value in the URL
  </li>
    <li>
@Post : you cant see key or value, it will be send as body
      </li></ul>
</li>
<li>
In the @GET or @Post HTTP request method there can be different kind of parameters pass inside the method
<ul>
<li>
@Body – Sends Java objects as request body.
</li>
<li>
@PATH – https://restcountries.eu/rest/v2/capital/{cairo}
</li>
<li>
@Url – use dynamic URLs.
</li>
<li>
@Query – We can simply add a method parameter with @Query() and a query parameter name, describing the type. To URL encode a query use the form: @Query(value = "auth_token",encoded = true) String auth_token – http://jobs.bdjobs.com/apps/api/v1/joblist.asp?
</li>
<li>
@Field – send data as form-urlencoded. This requires a @FormUrlEncoded annotation attached with the method. The @Field parameter works only with a POST
</li>
</ul>
</li>
<li>
@GET(Constant.CAPITAL)
    fun getCountry(@Path("capital") capitalOfCountry: String): Call<List<Country>>
Which means when getKountry is called then it gonna return <<list of country : it should be a pojo class >> the json objects gonna serialized in the POJO/model class.
</li>
<li>
Retrofit automatically serialises the JSON response using a POJO(Plain Old Java Object) which must be defined in advanced for the JSON Structure. To serialise JSON we need a converter to convert it into Gson first. 
</li>
<li>
Gson : <ul>
<li>
Json is a FORMAT.
  </li>
<li>
We need convert our data when it comes through Api so
Object ---> Json OR Json ---> object(POJO) so thats why we need Gson.
  </li>
  </ul>
</ol>

