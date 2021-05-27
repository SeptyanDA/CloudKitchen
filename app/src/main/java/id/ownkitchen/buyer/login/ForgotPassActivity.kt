package id.ownkitchen.buyer.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import id.ownkitchen.buyer.R

class ForgotPassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)

        val ArrowBack = findViewById(R.id.arrow_back) as ImageView

        ArrowBack.setOnClickListener{
            val intent = Intent(this, LoginMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}