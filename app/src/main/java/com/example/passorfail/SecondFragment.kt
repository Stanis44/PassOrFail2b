package com.example.passorfail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.passorfail.databinding.FragmentSecondBinding
import com.example.viewmodel.ClacViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var viewModel : ClacViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        viewModel = activity?.let { ViewModelProvider(it).get(ClacViewModel::class.java) }!!
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         viewModel.average.observe(viewLifecycleOwner, Observer {
            setAverageView(it)
         })

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    private fun setAverageView(value: Int?) {
        binding.average.text = value.toString()

        if (value != null) {
            if (value > 44) {
                binding.emoji.setImageResource(R.drawable.ic__531010992wink_emoji_woman_png)

            }else{
                binding.emoji.setImageResource(R.drawable.ic_care_emoji_with_icecream_2419213_2012662)

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}