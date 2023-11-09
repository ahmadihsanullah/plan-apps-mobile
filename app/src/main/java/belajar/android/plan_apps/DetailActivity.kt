package belajar.android.plan_apps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DetailActivity : AppCompatActivity() {
    private lateinit var btn_delete: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btn_delete = findViewById<Button>(R.id.btn_delete)

        var intent = intent.getBooleanExtra("status", false)

        if(intent){
            btn_delete.visibility = View.VISIBLE
        }
    }
}