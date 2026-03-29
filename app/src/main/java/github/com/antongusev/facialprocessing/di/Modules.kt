package github.com.antongusev.facialprocessing.di

import androidx.room.Room
import github.com.antongusev.facialprocessing.data.FacesRepository
import github.com.antongusev.facialprocessing.data.db.FaceScannerDatabase
import github.com.antongusev.facialprocessing.data.db.FaceWithMediaFileEntity
import github.com.antongusev.facialprocessing.domain.FaceDistanceMetric
import github.com.antongusev.facialprocessing.domain.GalleryScanner
import github.com.antongusev.facialprocessing.domain.clustering.Clusterer
import github.com.antongusev.facialprocessing.domain.clustering.Distance
import github.com.antongusev.facialprocessing.interactors.ClustersInteractor
import github.com.antongusev.facialprocessing.interactors.DetailsInteractor
import github.com.antongusev.facialprocessing.interactors.FeedInteractor
import github.com.antongusev.facialprocessing.interactors.SearchInteractor
import github.com.antongusev.facialprocessing.presentation.screens.clusters.ClustersViewModel
import github.com.antongusev.facialprocessing.presentation.screens.details.DetailsViewModel
import github.com.antongusev.facialprocessing.presentation.screens.feed.FeedViewModel
import github.com.antongusev.facialprocessing.presentation.screens.search.SearchViewModel
import github.com.antongusev.facialprocessing.utils.LocalUriLoader
import github.com.antongusev.facialprocessing.utils.MediaRetriever
import github.com.antongusev.facialprocessing.utils.tflite.InterpreterFactory
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val dataModule = module {

    single {
        Room.databaseBuilder(androidContext(), FaceScannerDatabase::class.java, "face_scanner")
            .build()
    }

    single { FacesRepository(get()) }

}

private val domainModule = module {

    single<Distance<FaceWithMediaFileEntity>> { FaceDistanceMetric.L2FaceDistanceMetric }

    single<Clusterer<FaceWithMediaFileEntity>> { Clusterer.create(get(), Clusterer.Algorithm.HDBSCAN) }

    single { GalleryScanner(get(), get(), get(), get(), get()) }

}

private val interactorsModule = module {

    single { FeedInteractor(get(), get(), get()) }

    single { DetailsInteractor(get(), get()) }

    single { SearchInteractor(get(), get()) }

    single { ClustersInteractor(get(), get()) }

}

private val viewModelsModule = module {

    viewModel { FeedViewModel(get()) }

    viewModel { DetailsViewModel(get()) }

    viewModel { SearchViewModel(get()) }

    viewModel { ClustersViewModel(get()) }

}

private val utilsModule = module {

    single { androidContext().contentResolver }

    factory { LocalUriLoader(get()) }

    factory { MediaRetriever(get()) }

    factory { InterpreterFactory(androidContext()) }

}

val appModules = dataModule + domainModule + interactorsModule + viewModelsModule + utilsModule
