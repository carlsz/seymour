package com.seymourapp.seymour.adapter;

import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class ComposableAdapter extends RecyclerView.Adapter<ComposableViewHolder<?>> {

  private static final ComposableAdapterItem[] EMPTY_ITEMS = {};
  private final ComposableViewHolderFactory viewHolderFactory;
  private ComposableAdapterItem[] items = EMPTY_ITEMS;

  public ComposableAdapter(ComposableViewHolderFactory viewHolderFactory) {
    this.viewHolderFactory = viewHolderFactory;
    setHasStableIds(true);
  }

  public void setItems(@Nullable ComposableAdapterItem[] items) {
    this.items = items == null ? EMPTY_ITEMS : items;
    notifyDataSetChanged();
  }

  public void setItems(List<ComposableAdapterItem> items) {
    //noinspection ToArrayCallWithZeroLengthArrayArgument
    setItems(items.toArray(new ComposableAdapterItem[items.size()]));
  }

  @Override
  public int getItemViewType(int position) {
    return items[position].viewType();
  }

  @NonNull
  @Override
  public ComposableViewHolder<?> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    ComposableViewHolder<?> viewHolder = viewHolderFactory.createViewHolder(parent, viewType);
    if (viewHolder == null) {
      throw new IllegalStateException(
          "ViewHolderFactory was unable to generate a view holder for view type: " +
              viewType);
    }
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull ComposableViewHolder<?> viewHolder, int position) {
    viewHolder.bind(items[position]);
  }

  @Override
  public int getItemCount() {
    return items.length;
  }

  @Override
  public long getItemId(int position) {
    return items[position].stableId();
  }

  @Override
  public void onViewRecycled(@NonNull ComposableViewHolder<?> viewHolder) {
    viewHolder.onViewRecycled();
  }

  @Override
  public boolean onFailedToRecycleView(@NonNull ComposableViewHolder<?> viewHolder) {
    return viewHolder.onFailedToRecycleView();
  }
}
