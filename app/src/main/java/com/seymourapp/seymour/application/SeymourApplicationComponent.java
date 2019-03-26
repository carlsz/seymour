package com.seymourapp.seymour.application;

import android.app.Application;

import com.seymourapp.seymour.activity.main.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        MainActivity.Module.class
})
public interface SeymourApplicationComponent extends AndroidInjector<SeymourApplication> {

    @Override
    void inject(SeymourApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        SeymourApplicationComponent.Builder application(Application application);

        SeymourApplicationComponent build();
    }
}
