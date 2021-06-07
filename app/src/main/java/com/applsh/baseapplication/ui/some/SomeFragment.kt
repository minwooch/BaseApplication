package com.applsh.baseapplication.ui.some

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.applsh.baseapplication.R
import com.applsh.baseapplication.databinding.SomeFragmentBinding
import com.applsh.baseapplication.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SomeFragment : BaseFragment<SomeFragmentBinding>() {

    override val layout: Int
        get() = R.layout.some_fragment

    private val someViewModel: SomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}