package com.applsh.baseapplication.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T, V : ViewDataBinding> constructor(
    @LayoutRes layout: Int,
    parent: ViewGroup,
    lifecycleOwner: LifecycleOwner
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false)) {
    private var _binding: V? = null
    val binding: V get() = _binding!!

    private val _item: MutableLiveData<T> = MutableLiveData()
    val item: LiveData<T> = _item

    init {
        _binding = DataBindingUtil.bind(itemView)
        binding.lifecycleOwner = lifecycleOwner
        lifecycleOwner.lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    _binding = null
                    lifecycleOwner.lifecycle.removeObserver(this)
                }
            }
        })
    }

    open fun bindTo(item: T?) {
        _item.value = item
    }
}
