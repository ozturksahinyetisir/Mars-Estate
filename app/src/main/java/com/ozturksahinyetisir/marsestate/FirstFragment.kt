package com.ozturksahinyetisir.marsestate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ozturksahinyetisir.marsestate.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding:FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        /**
         * @param findNavController action firstFragment to mainFragment
         * there is PopUpToInclusive at nav_graph firstFragment cannot reachable after opening mainFragment
         */
       binding = FragmentFirstBinding.inflate(inflater)
        binding.LetsGoButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_mainFragment)
        }
            return binding.root
        }
    }

