package com.example.googlebooks

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.*
import com.example.googlebooks.datasources.ExampleJson2KtKotlin


class DisplayBooks(val context: Context, val books: ExampleJson2KtKotlin):Adapter<DisplayBooks.DisplayVH>(){
    class DisplayVH(v: View):ViewHolder(v){
        val imageView: ImageView = v.findViewById(R.id.imageView)
        val textView:TextView = v.findViewById(R.id.textView)
        val textView2:TextView = v.findViewById(R.id.textView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayVH {
        return DisplayVH(LayoutInflater.from(parent.context).inflate(R.layout.one_item_design,parent,false))
    }

    override fun getItemCount(): Int {
       return books.items.size
    }

    override fun onBindViewHolder(holder: DisplayVH, position: Int) {
        holder.textView.text = books.items[position].volumeInfo?.title
        val auths = books.items[position].volumeInfo?.authors
        holder.textView2.text=""
        for(i in 0..auths?.size!!.minus(1)){
            holder.textView2.append(auths[i])
        }
        with(context)
            .load(books.items[position].volumeInfo?.imageLinks?.thumbnail)
            .into(holder.imageView)

            holder.imageView.setOnClickListener{
                val i = Intent(context,ExtraInfo::class.java)
                i.putExtra("TITLE",books.items[position].volumeInfo?.title)
                i.putExtra("DESC",books.items[position].volumeInfo?.description)
                i.putExtra("AUTHOR",books.items[position].volumeInfo?.authors)
                i.putExtra("SALE INFO",books.items[position].saleInfo?.saleability)
                i.putExtra("ISBOOK",books.items[position].saleInfo?.isEbook)
                i.putExtra("COUNTRY",books.items[position].saleInfo?.country)
                context.startActivity(i)
            }

    }


}