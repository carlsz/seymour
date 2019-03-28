package com.seymourapp.seymour.view.bindable;

import androidx.annotation.Nullable;

public interface BindableView<T extends ViewData> {

    void bindView(@Nullable T viewData);

    void unbindView();
}
