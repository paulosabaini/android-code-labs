package org.sabaini.koinexample

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.sabaini.koinexample.data.local.CatDatabase
import org.sabaini.koinexample.data.remote.CatApi
import org.sabaini.koinexample.repositories.CatRepository
import org.sabaini.koinexample.ui.viewmodels.HomeViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    viewModel { HomeViewModel(get()) }

    single {
        CatRepository(get(), get())
    }

    single {
        Room.databaseBuilder(
            androidContext(),
            CatDatabase::class.java,
            "cat_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    factory {
        get<CatDatabase>().catDao()
    }

    single<CatApi> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://thatcopy.pw/")
            .build()
            .create(CatApi::class.java)
    }
}