package com.seymourapp.seymour.adapter;

import com.seymourapp.seymour.view.bindable.ViewData;

import androidx.annotation.LayoutRes;

public class BindableAdapterItem extends ComposableAdapterItem {

    private final @LayoutRes
    int layoutResId;
    private final long stableId;
    private final ViewData viewData;

    public BindableAdapterItem(int layoutResId, long stableId, ViewData viewData) {
        this.layoutResId = layoutResId;
        this.stableId = stableId;
        this.viewData = viewData;
    }

    @Override
    public long stableId() {
        return stableId;
    }

    @Override
    public int viewType() {
        return layoutResId;
    }

    public ViewData viewData() {
        return viewData;
    }
}
