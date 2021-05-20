package br.com.zup.cdc.presentation.books.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.cdc.R
import br.com.zup.cdc.domain.Book

class BookListFragment : Fragment(R.layout.fragment_book_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val books: ArrayList<Book> = arguments?.get(BOOK_KEY) as ArrayList<Book>
        view.findViewById<RecyclerView>(R.id.bookList).adapter =
            BookAdapter(books) { book ->
                BookDetailsBottomSheet.create(book).show(parentFragmentManager, null)
            }
    }

    companion object {
        private const val BOOK_KEY = "book_key"
        fun open(books: ArrayList<Book>): BookListFragment {
            return BookListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(BOOK_KEY, books)
                }
            }
        }
    }
}