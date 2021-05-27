package id.ownkitchen.buyer.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import id.ownkitchen.buyer.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val create_account = findViewById(R.id.sign_in) as TextView

        create_account.setOnClickListener{
            val intent = Intent(this, LoginMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}