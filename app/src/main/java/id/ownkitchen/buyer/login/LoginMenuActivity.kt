package id.ownkitchen.buyer.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import id.ownkitchen.buyer.R
import id.ownkitchen.buyer.menu.HomeActivity
import id.ownkitchen.buyer.model.LoginModel
import id.ownkitchen.buyer.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginMenuActivity : AppCompatActivity() {
    private val TAG: String = "LoginActivity"

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_menu)

        val userName = findViewById<ImageView>(R.id.btnLogin)
        val buttonLogin = findViewById<ImageView>(R.id.btnLogin)
        val buttonIG = findViewById<ImageView>(R.id.btnIG)
        val buttonFB = findViewById<ImageView>(R.id.btnFB)
        val buttonGoogle = findViewById<ImageView>(R.id.btnGoogle)
        val buttonRemember = findViewById<CheckBox>(R.id.cbRememberMe)
        val createAccount = findViewById<TextView>(R.id.tv_create_account)
        val forgotPassword = findViewById<TextView>(R.id.tv_forgot_password)

        buttonLogin.setOnClickListener {
            val intent =Intent(this,HomeActivity::class.java)
            //
        }

        createAccount.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
        forgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPassActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        getDataFromApi()
    }

    private fun getDataFromApi() {
        ApiService.endpoint.getPhotos()
            .enqueue(object : Callback<List<LoginModel>> {
                override fun onResponse(
                    call: Call<List<LoginModel>>,
                    response: Response<List<LoginModel>>
                ) {
                    if (response.isSuccessful) {
                        val result = response.body()
                        showPhotos(result!!)
                    }
                }

                override fun onFailure(call: Call<List<LoginModel>>, t: Throwable) {
                    printLog(t.toString())
                }

            })
    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

    private fun showPhotos(photos: List<LoginModel>) {
        for (photo in photos) {
            printLog("title: ${photo.title}")
        }
    }
}