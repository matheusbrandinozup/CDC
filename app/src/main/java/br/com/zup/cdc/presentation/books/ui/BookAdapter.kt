package br.com.zup.cdc.presentation.books.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.cdc.R
import br.com.zup.cdc.domain.book.Book
import com.bumptech.glide.Glide
import java.util.*

class BookAdapter(private val books: ArrayList<Book>, private val onClick: (Book) -> Unit) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(item)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) =
        holder.bind(books[position])

    override fun getItemCount(): Int = books.size

    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val image = itemView.findViewById<ImageView>(R.id.itemBookImage)
        private val title = itemView.findViewById<TextView>(R.id.itemBookTitle)
        private val subtitle = itemView.findViewById<TextView>(R.id.itemBookSubtitle)

        fun bind(book: Book) {
            itemView.setOnClickListener { onClick(book) }
            title.text = book.title
            subtitle.text = book.subtitle
            Glide.with(image).load(book.imageUrl).into(image)
        }
    }
}
