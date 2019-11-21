package com.example.roommvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStore
import com.example.roommvvm.model.Word
import com.example.roommvvm.viewmodel.WordViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private val viewModel by lazy { WordViewModel(this.application) }
private var count:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter=WordAdapter()

        viewModel.allWords.observe(this, Observer {
            adapter.setWords(it)
        })

        recylView.adapter=adapter

        facButton.setOnClickListener {
            viewModel.insert(Word("Word ${count++}"))
        }

        fabDelete.setOnClickListener {
            viewModel.deleteAll()
            count=0
        }
    }

}
