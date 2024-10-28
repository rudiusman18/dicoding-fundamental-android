package id.rudi_usman.dicodingtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.rudi_usman.dicodingtest.databinding.ActivityMainBinding
import id.rudi_usman.dicodingtest.recyclerview.ItemAdapter
import id.rudi_usman.dicodingtest.viewmodels.listProgrammingLanguages

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.personIcon.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        val adapter = ItemAdapter(listProgrammingLanguages.listItems, this)
        mainBinding.contentRecyclerview.layoutManager = LinearLayoutManager(this)
        mainBinding.contentRecyclerview.adapter = adapter
    }

    fun onItemClicked(position:Int){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("index", position)
        startActivity(intent)
    }
}