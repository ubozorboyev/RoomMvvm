package com.example.roommvvm.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = arrayOf(Word::class),version = 1,exportSchema = false)
abstract class WordRoomDatabase :RoomDatabase(){
  abstract fun wordDao(): WordDao

    companion object{

    private lateinit var database: WordRoomDatabase

        fun init(context: Context){

          synchronized(this){
                database =Room.databaseBuilder(context.applicationContext,
                WordRoomDatabase::class.java,"word_database").build()
           }
        }

        fun getDataBase()= database
    }
}