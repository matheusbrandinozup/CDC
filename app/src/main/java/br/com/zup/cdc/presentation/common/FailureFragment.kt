package br.com.zup.cdc.presentation.common

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.com.zup.cdc.R

class FailureFragment : Fragment(R.layout.fragment_failure) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val error = arguments?.getString(FAILURE_KEY)
        view.findViewById<TextView>(R.id.failureText).text = error
    }

    companion object {
        private const val FAILURE_KEY = "error_key"

        fun open(error: String): FailureFragment {
            return FailureFragment().apply {
                arguments = Bundle().apply {
                    putString(FAILURE_KEY, error)
                }
            }
        }
    }
}