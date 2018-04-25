package thomas.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://glacial-spire-56714.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val client = retrofit.create(TagClient::class.java)
        val call = client.getTags()

        call.enqueue(object : Callback<List<Tag>> {
            override fun onResponse(call: Call<List<Tag>>, response: Response<List<Tag>>) {
                val repos = response.body()
                repos?.forEach {
                    Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_SHORT).show()
                }
                //pagination_list.adapter = GitHubRepoAdapter(this@MainActivity, repos)
            }

            override fun onFailure(call: Call<List<Tag>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "error :(", Toast.LENGTH_SHORT).show()
            }
        })
    }

}