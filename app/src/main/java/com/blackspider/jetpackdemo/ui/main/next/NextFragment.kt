package com.blackspider.jetpackdemo.ui.main.next

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.blackspider.jetpackdemo.R
import com.blackspider.jetpackdemo.databinding.FragmentNextBinding

class NextFragment : Fragment() {

    private lateinit var binding: FragmentNextBinding
    private lateinit var viewModel: NextViewModel

    companion object {
        //fun newInstance() = NextFragment()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_next, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(NextViewModel::class.java)
        binding.txtNextStr = viewModel.data.value

//        viewModel.data.observe(this, Observer { data ->
//            binding.tvNextStr.text = data
//        })
    }

}
