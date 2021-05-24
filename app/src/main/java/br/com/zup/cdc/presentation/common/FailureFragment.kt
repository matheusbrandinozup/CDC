package br.com.zup.cdc.presentation.common

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.com.zup.cdc.R

class FailureFragment : Fragment(R.layout.fragment_failure) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val error = arguments?.getSerializable(FAILURE_KEY) as Throwable
        view.findViewById<TextView>(R.id.failureText).text = error.message
    }

    companion object {
        private const val FAILURE_KEY = "error_key"

        fun open(error: Throwable): FailureFragment {
            return FailureFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(FAILURE_KEY, error)
                }
            }
        }
    }
}