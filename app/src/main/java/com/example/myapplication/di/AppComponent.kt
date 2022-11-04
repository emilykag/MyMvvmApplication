package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.presentation.MyApplication
import com.example.myapplication.presentation.userdetails.UserDetailsFragment
import com.example.myapplication.presentation.userlist.UserListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MyApplication)

    fun inject(userListFragment: UserListFragment)
    fun inject(userDetailsFragment: UserDetailsFragment)
}