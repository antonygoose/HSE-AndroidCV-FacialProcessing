package github.com.antongusev.facialprocessing.domain.model

import android.net.Uri

data class ProcessedGalleryEntry(
    val id: Long,
    val contentUri: Uri,
    val descriptors: List<FaceDescriptor>
)
