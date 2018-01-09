package com.nacoda.moviesmvvm.data.source.remote;

import com.nacoda.moviesmvvm.base.BaseApiModel;
import com.nacoda.moviesmvvm.data.model.Casts;
import com.nacoda.moviesmvvm.data.model.Detail;
import com.nacoda.moviesmvvm.data.model.Movie;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.nacoda.moviesmvvm.util.helper.Statics.API_URL;


/**
 * Created by Mayburger on 1/9/18.
 */

interface MoviesService {

    @GET("movie/popular")
    Observable<BaseApiModel<List<Movie>>> getPopular(
            @Query("api_key")String api_key,
            @Query("language")String language,
            @Query("page")String page
    );

    @GET("movie/now_playing")
    Observable<BaseApiModel<List<Movie>>> getNowPlaying(
            @Query("api_key")String api_key,
            @Query("language")String language,
            @Query("page")String page
    );

    @GET("movie/top_rated")
    Observable<BaseApiModel<List<Movie>>> getTopRated(
            @Query("api_key")String api_key,
            @Query("language")String language,
            @Query("page")String page
    );

    @GET("search/movie")
    Observable<BaseApiModel<List<Movie>>> getSearch(
            @Query("api_key")String api_key,
            @Query("language")String language,
            @Query("query")String query
    );

    @GET("movie/{movieId}")
    Observable<Detail> getDetail(
            @Path("movieId")String movieId,
            @Query("api_key")String api_key
    );

    @GET("movie/{movieId}/credits")
    Observable<Casts> getCasts(
            @Path("movieId")String movieId,
            @Query("api_key")String api_key
    );

    final class Factory {
        @NotNull
        public static final MoviesService create() {
            HttpLoggingInterceptor mLoggingInterceptor = new HttpLoggingInterceptor();
            mLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient mClient = (new OkHttpClient.Builder())
                    .addInterceptor(mLoggingInterceptor)
                    .readTimeout(30L, TimeUnit.SECONDS)
                    .connectTimeout(30L, TimeUnit.SECONDS)
                    .build();
            Retrofit mRetrofit = (new retrofit2.Retrofit.Builder())
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(mClient)
                    .build();
            Object var10000 = mRetrofit.create(MoviesService.class);
            return (MoviesService)var10000;
        }
    }

}
