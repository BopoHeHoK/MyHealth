package com.test.myhealth.app.di

import android.content.Context
import com.test.myhealth.data.db.MyHealthDatabase
import com.test.myhealth.data.repository.SharedPreferences
import com.test.myhealth.data.repository.UserRepositoryImpl
import com.test.myhealth.data.storage.converters.*
import com.test.myhealth.domain.data.repository.UserRepository
import com.test.myhealth.domain.data.repository.UserStorage
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideSharedPreferences(context: Context): UserStorage {
        return SharedPreferences(context = context)
    }

    @Provides
    fun provideMyHealthDatabase(context: Context): MyHealthDatabase {
        return MyHealthDatabase.getInstance(context = context)
    }

    @Provides
    fun provideConverterBM(): ConverterBM {
        return ConverterBMImpl()
    }

    @Provides
    fun provideConverterEM(): ConverterEM {
        return ConverterEMImpl()
    }

    @Provides
    fun provideConverterME(): ConverterME {
        return ConverterMEImpl()
    }

    @Provides
    fun provideUserRepository(
        userStorage: UserStorage,
        myHealthDatabase: MyHealthDatabase,
        converterEM: ConverterEM,
        converterME: ConverterME,
    ): UserRepository {
        return UserRepositoryImpl(
            userStorage = userStorage,
            myHealthDatabase = myHealthDatabase,
            converterEM = converterEM,
            converterME = converterME
        )
    }
}