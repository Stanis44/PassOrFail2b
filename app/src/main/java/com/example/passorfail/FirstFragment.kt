package com.example.passorfail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.passorfail.databinding.FragmentFirstBinding
import com.example.viewmodel.ClacViewModel
private lateinit var viewModel : ClacViewModel
/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
0
        _binding = FragmentFirstBinding.inflate(layoutInflater)
        viewModel = activity?.let { ViewModelProvider(it).get(ClacViewModel::class.java) }!!

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            check.setOnClickListener {

                viewModel.calcAverage(ed1.text.toString().toInt(),ed2.text.toString().toInt(),ed3.text.toString().toInt())

                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)







            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}