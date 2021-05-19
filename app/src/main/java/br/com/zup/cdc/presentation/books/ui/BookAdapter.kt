package br.com.zup.cdc.presentation.books.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.cdc.R
import br.com.zup.cdc.domain.Book
import java.util.*

class BookAdapter(private val books: ArrayList<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(item)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = books.size


    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

}
