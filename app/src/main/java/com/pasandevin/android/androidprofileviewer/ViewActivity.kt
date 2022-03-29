package com.pasandevin.android.androidprofileviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pasandevin.android.androidprofileviewer.api.UserAPIService
import com.pasandevin.android.androidprofileviewer.databinding.ActivityViewBinding
import com.pasandevin.android.androidprofileviewer.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewBinding
    private val userAPIService = UserAPIService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.extras!!.getString("id").toString()

        val user = userAPIService.getUser(id)
        user.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val body = response.body()
                body?.let {
                    binding.textlabelname.setText(it.name)
                    binding.textlabelemail.setText(it.email)
                    binding.textlabelphone.setText(it.phone)
                    binding.textlabelwebsite.setText(it.website)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}