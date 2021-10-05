package ctorres.developer.movievisor.di

import ctorres.developer.movievisor.BuildConfig
import ctorres.developer.movievisor.data.remote.MoviesAPI
import ctorres.developer.movievisor.data.repository.MovieRepositoryImpl
import ctorres.developer.movievisor.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAPI(): MoviesAPI {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(Interceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("api_key", BuildConfig.API_KEY)
                    .build();
                // Request customization: add request headers
                val requestBuilder = original.newBuilder()
                    .url(url);
                val request = requestBuilder.build();
                chain.proceed(request)
            })
            .build()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(MoviesAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MoviesAPI): MovieRepository {
        return MovieRepositoryImpl(api)
    }

}

