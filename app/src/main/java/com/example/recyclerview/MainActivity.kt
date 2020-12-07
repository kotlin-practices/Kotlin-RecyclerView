package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val exampleList = generateDummyList(500) // It is a list of data which is 500 in size
    private val adapter = ExampleAdapter(exampleList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true) // This is just an optimization
    }

    fun insertItem(view: View) {
        val index = Random.nextInt(8)
        val exampleItem = ExampleItem(
            R.drawable.ic_launcher_background,
            "This is the new text",
            "Text Added"
        )
        exampleList.add(index, exampleItem)
        adapter.notifyDataSetChanged()
    }

    fun removeItem(view: View) {
        val index = Random.nextInt(8)
        exampleList.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

    /*
    * size: Int is what we pass as parameter
    * List<ExampleItem> is the return type for method*/
    private fun generateDummyList(size: Int): ArrayList<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_baseline_settings_24
                1 -> R.drawable.ic_baseline_notifications_24
                else -> R.drawable.ic_baseline_settings_24
            }
            val item = ExampleItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }
}