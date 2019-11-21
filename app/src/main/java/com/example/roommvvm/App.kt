package com.example.roommvvm

import android.annotation.SuppressLint
import android.app.Application
import com.example.roommvvm.model.WordRoomDatabase

@SuppressLint("Registered")
class App :Application(){

    override fun onCreate() {
        super.onCreate()
        WordRoomDatabase.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        WordRoomDatabase.getDataBase().close()
    }

}