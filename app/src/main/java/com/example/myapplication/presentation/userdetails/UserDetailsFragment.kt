package com.example.myapplication.presentation.userdetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentUserDetailsBinding
import com.example.myapplication.domain.models.Resource
import com.example.myapplication.presentation.MyApplication
import com.example.myapplication.presentation.SharedViewModel
import javax.inject.Inject

class UserDetailsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: UserDetailsViewModel by viewModels { viewModelFactory }

    val sharedViewModel: SharedViewModel by activityViewModels()

    private var binding: FragmentUserDetailsBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as? MyApplication?)?.appComponent?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.ratingBar?.setOnRatingBarChangeListener { ratingBar, rating, b ->
            sharedViewModel.setUserRating(rating.toString())
        }

        viewModel.getUserDetails("").observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.SUCCESS -> {

                    binding?.imageView?.let { imageView ->
                        Glide.with(requireContext()).load(it.data?.profileImage).into(imageView)
                    }
                    binding?.textView?.text = it.data?.firstName + " " + it.data?.lastName
                }
                Resource.ERROR -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}