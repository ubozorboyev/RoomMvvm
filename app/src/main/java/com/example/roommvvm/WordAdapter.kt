package com.example.roommvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roommvvm.model.Word

class WordAdapter :RecyclerView.Adapter<WordAdapter.WordViewHolder>(){
private var words= emptyList<Word>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view=LayoutInflater.from(parent.context).inflate( R.layout.word_item, parent,false)
        return WordViewHolder(view)
    }
    override fun getItemCount()=words.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.textView.text=words[position].word
    }

    inner class WordViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textView=view.findViewById<TextView>(R.id.textView)
    }

    internal fun setWords(words:List<Word>){
        this.words=words
        notifyDataSetChanged()
    }
}