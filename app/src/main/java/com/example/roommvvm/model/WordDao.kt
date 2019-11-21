package com.example.roommvvm.model

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roommvvm.model.Word
@Dao
interface WordDao {
    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getWords():LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

}