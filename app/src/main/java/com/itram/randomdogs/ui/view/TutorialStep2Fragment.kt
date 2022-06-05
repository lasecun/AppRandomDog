package com.itram.randomdogs.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.itram.randomdogs.R
import com.itram.randomdogs.databinding.TutorialStep2Binding

class TutorialStep2Fragment : Fragment() {

    private lateinit var binding: TutorialStep2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = TutorialStep2Binding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btGoStep3.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_tutorialStep2_to_tutorialStep3)
        }

        val parent = activity as MainActivity
        parent.bind.myToolbar.title = "Tutorial Step 2"
    }
}