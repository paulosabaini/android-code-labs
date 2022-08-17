package org.sabaini.kotlingithubissues.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.sabaini.kotlingithubissues.R
import org.sabaini.kotlingithubissues.api.GithubIssuesAPI
import org.sabaini.kotlingithubissues.other.Constants.BASE_URL
import org.sabaini.kotlingithubissues.other.Constants.CACHE_SIZE
import org.sabaini.kotlingithubissues.other.Network
import org.sabaini.kotlingithubissues.repository.GithubIssuesRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideGlideInstance(@ApplicationContext context: Context) =
        Glide.with(context).setDefaultRequestOptions(
            RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
        )

    @Singleton
    @Provides
    fun provideGithubIssuesAPI(@ApplicationContext context: Context): GithubIssuesAPI {

        val myCache = Cache(context.cacheDir, CACHE_SIZE)

        val okHttp =
            OkHttpClient.Builder()
                .cache(myCache)
                .addInterceptor { chain ->
                    var request = chain.request()
                    request = if (Network.hasNetwork(context)!!)
                        request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                    else
                        request.newBuilder().header(
                            "Cache-Control",
                            "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                        ).build()
                    chain.proceed(request)
                }
                .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()
            .create(GithubIssuesAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideGithubIssuesRepository(githubIssuesAPI: GithubIssuesAPI): GithubIssuesRepository {
        return GithubIssuesRepository(githubIssuesAPI)
    }
}