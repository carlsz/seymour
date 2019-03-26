package com.seymourapp.seymour.application;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class SeymourApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerSeymourApplicationComponent.builder()
                .application(this)
                .build();
    }
}
