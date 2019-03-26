package com.seymourapp.seymour.activity.main;

import android.os.Bundle;

import com.seymourapp.seymour.R;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @dagger.Module
    public interface Module {
        @ContributesAndroidInjector
        MainActivity contributeMainActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
