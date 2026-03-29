package github.com.antongusev.facialprocessing.interactors.models

import android.net.Uri
import github.com.antongusev.facialprocessing.data.db.MediaFileEntity

data class MediaEntry(
    val id: Long,
    val uri: Uri
)

fun MediaFileEntity.asMediaEntry(): MediaEntry {
    return MediaEntry(
        id = this.mediaId,
        uri = Uri.parse(this.mediaUri),
    )
}
