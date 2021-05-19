package br.com.zup.cdc.presentation.books.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.zup.cdc.R
import br.com.zup.cdc.presentation.books.BookState
import br.com.zup.cdc.presentation.books.BookViewModel
import br.com.zup.cdc.presentation.common.FailureFragment
import br.com.zup.cdc.presentation.common.LoadingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookActivity : AppCompatActivity(R.layout.activity_book) {

    private val viewModel: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.fetchBooks()

        viewModel.getBooksState().observe(this) {
            when (it) {
                is BookState.Loading -> show(LoadingFragment())
                is BookState.Success -> show(BookListFragment.open(it.data))
                is BookState.Failure -> show(FailureFragment.open(it.data))
            }
        }
    }

    private fun show(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFrame, fragment)
            .commit()
    }
}