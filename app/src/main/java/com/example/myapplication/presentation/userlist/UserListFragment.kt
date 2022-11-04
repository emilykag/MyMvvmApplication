package com.example.myapplication.presentation.userlist

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
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentUserListBinding
import com.example.myapplication.domain.models.Resource
import com.example.myapplication.presentation.MyApplication
import com.example.myapplication.presentation.SharedViewModel
import com.example.myapplication.presentation.userdetails.UserDetailsFragment
import javax.inject.Inject

class UserListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: UserListViewModel by viewModels { viewModelFactory }

    val sharedViewModel: SharedViewModel by activityViewModels()

    private var binding: FragmentUserListBinding? = null
    private lateinit var adapter: UserListAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as? MyApplication?)?.appComponent?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UserListAdapter(requireContext()) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, UserDetailsFragment())
                .addToBackStack(UserDetailsFragment::class.simpleName)
                .commit()
        }
        binding?.usersListRecyclerView.apply {
            this?.adapter = adapter
        }

        viewModel.getUsers().observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.SUCCESS -> {
                    // display list
                    adapter.submitList(it.data)
                }
                Resource.ERROR -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        sharedViewModel.getUserRating().observe(viewLifecycleOwner) {
            binding?.textViewUserRating?.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}