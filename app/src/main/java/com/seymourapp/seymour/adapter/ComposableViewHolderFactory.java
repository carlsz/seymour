package com.seymourapp.seymour.adapter;

import android.view.ViewGroup;

import androidx.annotation.Nullable;

public interface ComposableViewHolderFactory {

    @Nullable
    ComposableViewHolder<?> createViewHolder(ViewGroup parent, int viewType);
}
