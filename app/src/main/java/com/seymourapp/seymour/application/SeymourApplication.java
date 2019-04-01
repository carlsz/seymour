package com.seymourapp.seymour.application;

import com.seymourapp.seymour.BuildConfig;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import timber.log.Timber;

public class SeymourApplication extends DaggerApplication {

  @Override
  public void onCreate() {
    super.onCreate();

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  @Override
  protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerSeymourApplicationComponent.builder()
        .application(this)
        .build();
  }
}
