package belajar.android.plan_apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import belajar.android.plan_apps.adapter.PlanAdapter
import belajar.android.plan_apps.model.ModelPlan
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), PlanAdapter.OnListener {
    private lateinit var rv_data: RecyclerView
    private lateinit var fab_add: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var datalist = ArrayList<ModelPlan>()
        datalist.addAll(
            listOf(
                ModelPlan(1,"Belajar Java", "Belajar Java Dasar"),
                ModelPlan(2,"Belajar Java OOP", "Belajar Java Objek Oriented Programming"),
                ModelPlan(3,"Belajar Java Generic", "Belajar Java Generic Type"),
                ModelPlan(3,"Belajar Java Collection", "Belajar Java Collection"),
                ModelPlan(1,"Belajar Java", "Belajar Java Dasar"),
                ModelPlan(2,"Belajar Java OOP", "Belajar Java Objek Oriented Programming"),
                ModelPlan(3,"Belajar Java Generic", "Belajar Java Generic Type"),
                ModelPlan(3,"Belajar Java Collection", "Belajar Java Collection"),
                ModelPlan(1,"Belajar Java", "Belajar Java Dasar"),
                ModelPlan(2,"Belajar Java OOP", "Belajar Java Objek Oriented Programming"),
                ModelPlan(3,"Belajar Java Generic", "Belajar Java Generic Type"),
                ModelPlan(3,"Belajar Java Collection", "Belajar Java Collection"),
            )
        )

        rv_data = findViewById(R.id.rv_data)
        var data_adapter = PlanAdapter(this)
        rv_data.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = data_adapter
        }

        data_adapter.setData(datalist)
        data_adapter.notifyDataSetChanged()

        fab_add = findViewById(R.id.fab_add)

        fab_add.setOnClickListener {
            startActivity(Intent(this@MainActivity, DetailActivity::class.java)
                .putExtra("status", false))
        }
    }

    override fun onClick(data: ModelPlan) {
        startActivity(Intent(this@MainActivity, DetailActivity::class.java)
            .putExtra("status", true))
    }

}