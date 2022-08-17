package org.sabaini.kotlingithubissues.adapters

import androidx.recyclerview.widget.RecyclerView
import org.sabaini.kotlingithubissues.api.IssueResponse
import org.sabaini.kotlingithubissues.databinding.IssueItemBinding

class IssuesListViewHolder(
    private var binding: IssueItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(issue: IssueResponse) {
        binding.issueItemTitle.text = issue.title
        binding.issueItemState.text = issue.getEstado()
    }
}