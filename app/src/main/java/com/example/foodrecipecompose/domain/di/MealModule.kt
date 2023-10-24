package com.example.foodrecipecompose.domain.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodrecipecompose.data.local.MealDatabase
import com.example.foodrecipecompose.data.remote.MealsApi
import com.example.foodrecipecompose.data.repository.MealsRepositoryImpl
import com.example.foodrecipecompose.domain.usecase.AllUseCase
import com.example.foodrecipecompose.domain.usecase.GetCountryMealsUseCase
import com.example.foodrecipecompose.domain.usecase.GetMealDetailsUseCase
import com.example.foodrecipecompose.domain.usecase.GetRandomCategoryMealsUseCase
import com.example.foodrecipecompose.domain.usecase.GetSavedMealsUseCase
import com.example.foodrecipecompose.domain.usecase.GetSearchedMealUseCase
import com.example.foodrecipecompose.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MealModule {

    @Provides
    @Singleton
    fun provideOkHttpClientInstance(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideCurrencyApi(retrofit: Retrofit): MealsApi {
        return retrofit.create(MealsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLocalDatabaseInstance(
        @ApplicationContext context: Context
    ): MealDatabase {
        return Room.databaseBuilder(
            context,
            MealDatabase::class.java,
            "meal_table"
        ).build()
    }



    @Provides
    @Singleton
    fun provideMealsRepositoryInstance(mealsApi: MealsApi, database: MealDatabase): MealsRepositoryImpl {
        return MealsRepositoryImpl(mealsApi, database)
    }


    @Provides
    @Singleton
    fun provideMealsUseCases(
        getRandomCategoryMealsUseCase: GetRandomCategoryMealsUseCase,
        getSearchedMealUseCase: GetSearchedMealUseCase,
        getCountryMealsUseCase: GetCountryMealsUseCase,
        getMealDetailsUseCase: GetMealDetailsUseCase,
        getSavedMealsUseCase: GetSavedMealsUseCase
    ): AllUseCase {
        return AllUseCase(
            getRandomCategoryMealsUseCase = getRandomCategoryMealsUseCase,
            getSearchedMealUseCase = getSearchedMealUseCase,
            getCountryMealsUseCase = getCountryMealsUseCase,
            getMealDetailsUseCase = getMealDetailsUseCase,
            getSavedMealsUseCase = getSavedMealsUseCase
        )
    }


}






