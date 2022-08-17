package org.sabaini.kotlingithubissues.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint
import org.sabaini.kotlingithubissues.databinding.FragmentDetailBinding
import org.sabaini.kotlingithubissues.viewmodel.DetailFragmentViewModel
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val viewModel: DetailFragmentViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding

    @Inject
    lateinit var glide: RequestManager

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)
        val view = binding.root

        viewModel.setSelectedIssue(
            DetailFragmentArgs.fromBundle(requireArguments()).selectedIssue
        )

        viewModel.selectedIssue.observe(viewLifecycleOwner, { issue ->
            binding.issueTitle.text = issue.title
            binding.issueDescription.text = issue.body
            val stringDate: String = issue.getFormattedDate()
            binding.issueCreationDate.text = stringDate
            glide.load(issue.user.avatar_url).into(binding.userAvatar)

            binding.issueLink.setOnClickListener {
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(issue.html_url)
                )
                startActivity(i)
            }
        })

        return view
    }
}