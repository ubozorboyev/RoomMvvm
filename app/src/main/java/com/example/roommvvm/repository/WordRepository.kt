package com.example.roommvvm.repository

import com.example.roommvvm.model.Word
import com.example.roommvvm.model.WordDao

class WordRepository (private val wordDao: WordDao){
    val allwords=wordDao.getWords()

    suspend fun insert(word: Word){
        wordDao.insert(word)
    }

    suspend fun deteleAll(){
        wordDao.deleteAll()
    }
}