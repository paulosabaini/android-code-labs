package org.sabaini.kotlingithubissues.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.sabaini.kotlingithubissues.api.IssueResponse
import org.sabaini.kotlingithubissues.databinding.IssueItemBinding
import javax.inject.Inject

class IssuesListAdapter @Inject constructor() :
    RecyclerView.Adapter<IssuesListViewHolder>() {

    var issues = emptyList<IssueResponse>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                IssuesListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssuesListViewHolder {
        return IssuesListViewHolder(
            IssueItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class OnClickListener(val clickListener: (issue: IssueResponse) -> Unit) {
        fun onClick(issue: IssueResponse) = clickListener(issue)
    }

    lateinit var onClickListener: OnClickListener

    override fun onBindViewHolder(holder: IssuesListViewHolder, position: Int) {
        val issue = issues[position]
        holder.itemView.setOnClickListener {
            onClickListener.onClick(issue)
        }
        holder.bind(issue)
    }

    override fun getItemCount(): Int = issues.size

}