package com.kotlin.base.injection.module

import androidx.fragment.app.FragmentActivity
import com.kotlin.base.injection.ActivityScope
import dagger.Module
import dagger.Provides

/*
    Activity级别Module
 */
@Module
class ActivityModule(private val activity: FragmentActivity) {

    @ActivityScope
    @Provides
    fun provideActivity(): FragmentActivity {
        return this.activity
    }
}
