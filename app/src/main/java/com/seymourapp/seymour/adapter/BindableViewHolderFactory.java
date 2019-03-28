package com.seymourapp.seymour.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seymourapp.seymour.view.bindable.BindableView;
import com.seymourapp.seymour.view.bindable.ViewData;

import androidx.annotation.Nullable;

public class BindableViewHolderFactory implements ComposableViewHolderFactory {

    private static class BindableViewHolder extends ComposableViewHolder<BindableAdapterItem> {

        public BindableViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public Class<BindableAdapterItem> itemClass() {
            return BindableAdapterItem.class;
        }

        @Override
        public void onViewRecycled() {
            bindableView().unbindView();
        }

        @Override
        public boolean onFailedToRecycleView() {
            bindableView().unbindView();
            // Assume that the view will clean up any transient animations or resources
            return true;
        }

        @Override
        protected void onBind(BindableAdapterItem item) {
            bindableView().bindView(item.viewData());
        }

        @SuppressWarnings("unchecked")
        private BindableView<ViewData> bindableView() {
            return (BindableView<ViewData>) itemView;
        }
    }

    @Nullable
    @Override
    public ComposableViewHolder<?> createViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        if (!(view instanceof BindableView)) {
            throw new IllegalStateException("Inflated view is not a BindableView: " + view.getClass());
        }
        return new BindableViewHolderFactory.BindableViewHolder(view);
    }
}
