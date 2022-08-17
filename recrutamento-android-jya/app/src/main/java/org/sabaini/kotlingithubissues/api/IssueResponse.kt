package org.sabaini.kotlingithubissues.api

import android.annotation.SuppressLint
import android.os.Build
import android.os.Parcelable
import androidx.annotation.RequiresApi
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor
import java.util.*

@Parcelize
data class IssueResponse(
    val id: Long,
    val html_url: String,
    val title: String,
    val state: String,
    val created_at: String,
    val body: String,
    val user: User
) : Parcelable {
    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    fun getFormattedDate(): String {
        val ta: TemporalAccessor = DateTimeFormatter.ISO_INSTANT.parse(created_at)
        val i: Instant = Instant.from(ta)
        val d: Date = Date.from(i)
        val dateFor = SimpleDateFormat("dd/MM/yyyy")
        return dateFor.format(d)
    }

    fun getEstado(): String {
        return when (state) {
            "open" -> "ABERTO"
            "close" -> "FECHADO"
            else -> ""
        }
    }
}

@Parcelize
data class User(
    val id: Long,
    val login: String,
    val avatar_url: String
) : Parcelable