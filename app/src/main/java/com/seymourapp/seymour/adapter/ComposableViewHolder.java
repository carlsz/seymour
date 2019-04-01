package com.seymourapp.seymour.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ComposableViewHolder<CAI extends ComposableAdapterItem>
    extends RecyclerView.ViewHolder {

  protected ComposableViewHolder(@NonNull View itemView) {
    super(itemView);
  }

  public abstract Class<CAI> itemClass();

  public final void bind(ComposableAdapterItem item) {
    onBind(itemClass().cast(item));
  }

  protected abstract void onBind(CAI item);

  public void onViewAttachedToWindow() {
  }

  public void onViewDetachedFromWindow() {
  }

  public void onViewRecycled() {
  }

  public boolean onFailedToRecycleView() {
    return false;
  }
}
