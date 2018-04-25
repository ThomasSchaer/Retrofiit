package thomas.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface TagClient
{
    @GET("/api/tagsByRank")
    fun getTags(): Call<List<Tag>>

}