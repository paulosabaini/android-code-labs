package com.picpay.desafio.android.di

import android.content.Context
import androidx.room.Room
import com.picpay.desafio.android.api.PicPayService
import com.picpay.desafio.android.model.UserDao
import com.picpay.desafio.android.model.UserDb
import com.picpay.desafio.android.other.Constants.BASE_URL
import com.picpay.desafio.android.repository.PicPayRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): UserDb {
        return Room.databaseBuilder(
            appContext,
            UserDb::class.java,
            "users"
        ).build()
    }

    @Provides
    fun provideUserDao(database: UserDb): UserDao {
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideUserApi(): PicPayService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PicPayService::class.java)
    }

    @Provides
    @Singleton
    fun providePicPayRepository(userDao: UserDao, userApi: PicPayService): PicPayRepository {
        return PicPayRepository(userDao, userApi)
    }
}