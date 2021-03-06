package com.example.android.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.android.hilt.data.AppDatabase
import com.example.android.hilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


/*
@Module : tells hilt that this is a module
@InstallIn tells hilt in which containers (ApplicationComponent
here in this class) the bindings are available by specifying
a hilt component.

)
 */
@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    //AppDatabase is hilt component
    //It's as a transitive dependency we also need to provide
    //instances of that type
    //Since AppDatabase is another class that our project
    //doesn't own because it's generated by Room, we can
    //also provide it using an @Provides function

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context)
    : AppDatabase{
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "logging.db"
        ) .build()
    }

    @Provides
    fun provideLogDao(database: AppDatabase): LogDao{
        return database.logDao()
    }


}