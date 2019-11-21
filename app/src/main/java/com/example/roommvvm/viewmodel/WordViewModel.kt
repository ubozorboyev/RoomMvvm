package com.example.roommvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roommvvm.model.Word
import com.example.roommvvm.model.WordRoomDatabase
import com.example.roommvvm.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel (application: Application):AndroidViewModel(application){
    private val repository:WordRepository
    val allWords:LiveData<List<Word>>

    init {
        val wordDao= WordRoomDatabase.getDataBase().wordDao()
        repository= WordRepository(wordDao)
        allWords=repository.allwords
    }

    fun insert(word: Word)=viewModelScope.launch {
        repository.insert(word)
    }

    fun deleteAll()=viewModelScope.launch {
        repository.deteleAll()
    }
}