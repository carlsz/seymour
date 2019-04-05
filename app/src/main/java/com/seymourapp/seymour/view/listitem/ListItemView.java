package com.seymourapp.seymour.view.listitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.auto.value.AutoValue;
import com.seymourapp.seymour.R;
import com.seymourapp.seymour.view.bindable.BindableView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

public class ListItemView extends LinearLayout implements BindableView<ListItemView.ViewData> {

  @AutoValue
  public abstract static class ViewData implements com.seymourapp.seymour.view.bindable.ViewData {

    public abstract @DrawableRes
    int icon();

    public abstract CharSequence title();

    public abstract int unreadCount();

    @Nullable
    public abstract OnClickListener onClickListener();

    @AutoValue.Builder
    public abstract static class Builder {

      public abstract ViewData build();

      public abstract Builder icon(@DrawableRes int icon);

      public abstract Builder title(CharSequence title);

      public abstract Builder unreadCount(int unreadCount);

      public abstract Builder onClickListener(OnClickListener listener);
    }

    public static ViewData.Builder builder() {
      return new AutoValue_ListItemView_ViewData.Builder()
          .icon(R.drawable.ic_rss_feed_black_24px)
          .unreadCount(0);
    }
  }

  private final ImageView iconView;
  private final TextView titleView;
  private final TextView unreadCountView;

  public ListItemView(Context context) {
    this(context, null);
  }

  public ListItemView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public ListItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    setOrientation(HORIZONTAL);
    setFocusable(true);
    setBaselineAligned(false);
    LayoutInflater.from(context).inflate(R.layout.listitem, this, true);

    iconView = findViewById(R.id.listitem_icon_view);
    titleView = findViewById(R.id.listitem_title_view);
    unreadCountView = findViewById(R.id.listitem_unread_count_view);
  }

  @Override
  public void bindView(@Nullable ViewData viewData) {
    setIcon(viewData == null ? R.drawable.ic_rss_feed_black_24px : viewData.icon());
    setTitle(viewData == null ? "" : viewData.title());
    setUnreadCount(viewData == null ? 0 : viewData.unreadCount());
  }

  @Override
  public void unbindView() {
    // Do nothing for now...
  }

  public void setIcon(@DrawableRes int icon) {
    iconView.setImageResource(icon);
  }

  public void setTitle(CharSequence title) {
    titleView.setText(title);
  }

  public void setUnreadCount(int unreadCount) {
    unreadCountView.setText(String.valueOf(unreadCount));
  }
}
