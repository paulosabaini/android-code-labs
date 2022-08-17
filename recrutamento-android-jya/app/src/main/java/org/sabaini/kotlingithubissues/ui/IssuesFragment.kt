package org.sabaini.kotlingithubissues.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import org.sabaini.kotlingithubissues.adapters.IssuesListAdapter
import org.sabaini.kotlingithubissues.databinding.FragmentIssuesBinding
import org.sabaini.kotlingithubissues.other.Status
import org.sabaini.kotlingithubissues.viewmodel.IssuesFragmentViewModel
import javax.inject.Inject

@AndroidEntryPoint
class IssuesFragment : Fragment() {

    private val viewModel: IssuesFragmentViewModel by viewModels()
    private lateinit var binding: FragmentIssuesBinding

    @Inject
    lateinit var adapter: IssuesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssuesBinding.inflate(inflater)
        val view = binding.root

        binding.issuesList.adapter = adapter
        binding.issuesList.layoutManager = LinearLayoutManager(requireContext())

        viewModel.issues.observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    adapter.issues = it.data ?: listOf()
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Snackbar.make(
                        view,
                        it.message ?: "An unknown error occured.",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        })

        adapter.onClickListener = IssuesListAdapter.OnClickListener {
            viewModel.displayIssueDetail(it)
        }

        viewModel.navigateToSelectedIssue.observe(viewLifecycleOwner, {
            if (null != it) {
                this.findNavController()
                    .navigate(IssuesFragmentDirections.actionIssuesFragmentToDetailFragment(it))
                viewModel.displayIssueDetailComplete()
            }
        })

        return view
    }
}