package com.blackspider.jetpackdemo.ui.main.first

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.blackspider.jetpackdemo.R
import com.blackspider.jetpackdemo.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: FirstViewModel

    companion object {
        //fun newInstance() = FirstFragment()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_first, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(FirstViewModel::class.java)
        binding.txtStr = viewModel.data.value
//        viewModel.data.observe(this, Observer { data ->
//            binding.tvStr.text = data
//        })

        binding.navigateBtn.setOnClickListener { _ ->
            view?.let { Navigation.findNavController(it).navigate(R.id.end_action) }
        }
    }

}
