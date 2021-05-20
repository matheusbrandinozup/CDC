package br.com.zup.cdc.presentation.books.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.zup.cdc.R
import br.com.zup.cdc.domain.Book
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BookDetailsBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_detais_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val book = arguments?.get(BOOK_KEY) as Book

        val imageView = view.findViewById<ImageView>(R.id.bottomSheetImage)
        Glide.with(imageView).load(book.imageUrl).into(imageView)
        view.findViewById<TextView>(R.id.bottomSheetTitle).text = book.title
        view.findViewById<TextView>(R.id.bottomSheetDescription).text = book.description
    }

    companion object {
        private const val BOOK_KEY = "book_key"

        fun create(book: Book): BookDetailsBottomSheet {
            return BookDetailsBottomSheet().apply {
                arguments = Bundle().apply {
                    putParcelable(BOOK_KEY, book)
                }
            }
        }
    }
}