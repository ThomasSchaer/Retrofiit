package thomas.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TagClient
{
    @GET("/api/tagsByRank")
    fun getTags(): Call<List<Tag>>

    @POST("/api/tags")
    fun postTag(@Body tag: Tag): Call<Tag>
}