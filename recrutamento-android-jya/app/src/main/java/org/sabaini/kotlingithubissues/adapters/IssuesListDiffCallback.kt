package org.sabaini.kotlingithubissues.adapters

import androidx.recyclerview.widget.DiffUtil
import org.sabaini.kotlingithubissues.api.IssueResponse

class IssuesListDiffCallback(
    private val oldList: List<IssueResponse>,
    private val newList: List<IssueResponse>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}