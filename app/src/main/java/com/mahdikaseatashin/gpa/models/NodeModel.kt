package com.mahdikaseatashin.gpa.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//@Suppress("UNREACHABLE_CODE")
@Parcelize
data class NodeModel(
    val id: Int,
    val node_id: String,
    val name: String,
    val full_name: String,
    val private: Boolean,
    val owner : OwnerModel,
    val html_url : String,
    val description : String,
    val fork : Boolean,
    val url : String,
    val forks_url : String,
    val keys_url : String,
    val collaborators_url : String,
    val teams_url : String,
    val hooks_url : String,
    val issue_events_url : String,
    val events_url : String,
    val assignees_url : String,
    val branches_url : String,
    val tags_url : String,
    val blobs_url : String,
    val git_tags_url : String,
    val git_refs_url : String,
    val trees_url : String,
    val statuses_url : String,
    val languages_url : String,
    val stargazers_url : String,
    val contributors_url : String,
    val subscribers_url : String,
    val subscription_url : String,
    val commits_url : String,
    val git_commits_url : String,
    val comments_url : String,
    val issue_comment_url : String,
    val contents_url : String,
    val compare_url : String,
    val merges_url : String,
    val archive_url : String,
    val downloads_url : String,
    val issues_url : String,
    val pulls_url : String,
    val milestones_url : String,
    val notifications_url : String,
    val labels_url : String,
    val releases_url : String,
    val deployments_url : String
):Parcelable

    /*: Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte(),
        parcel.readParcelable<OwnerModel!!>(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(node_id)
        parcel.writeString(name)
        parcel.writeString(full_name)
        parcel.writeByte(if (private) 1 else 0)
        parcel.writeString(html_url)
        parcel.writeString(description)
        parcel.writeByte(if (fork) 1 else 0)
        parcel.writeString(url)
        parcel.writeString(forks_url)
        parcel.writeString(keys_url)
        parcel.writeString(collaborators_url)
        parcel.writeString(teams_url)
        parcel.writeString(hooks_url)
        parcel.writeString(issue_events_url)
        parcel.writeString(events_url)
        parcel.writeString(assignees_url)
        parcel.writeString(branches_url)
        parcel.writeString(tags_url)
        parcel.writeString(blobs_url)
        parcel.writeString(git_tags_url)
        parcel.writeString(git_refs_url)
        parcel.writeString(trees_url)
        parcel.writeString(statuses_url)
        parcel.writeString(languages_url)
        parcel.writeString(stargazers_url)
        parcel.writeString(contributors_url)
        parcel.writeString(subscribers_url)
        parcel.writeString(subscription_url)
        parcel.writeString(commits_url)
        parcel.writeString(git_commits_url)
        parcel.writeString(comments_url)
        parcel.writeString(issue_comment_url)
        parcel.writeString(contents_url)
        parcel.writeString(compare_url)
        parcel.writeString(merges_url)
        parcel.writeString(archive_url)
        parcel.writeString(downloads_url)
        parcel.writeString(issues_url)
        parcel.writeString(pulls_url)
        parcel.writeString(milestones_url)
        parcel.writeString(notifications_url)
        parcel.writeString(labels_url)
        parcel.writeString(releases_url)
        parcel.writeString(deployments_url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NodeModel> {
        override fun createFromParcel(parcel: Parcel): NodeModel {
            return NodeModel(parcel)
        }

        override fun newArray(size: Int): Array<NodeModel?> {
            return arrayOfNulls(size)
        }
    }

}
*/
