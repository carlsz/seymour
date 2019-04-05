package com.seymourapp.seymour.view.feeditem;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.auto.value.AutoValue;
import com.seymourapp.seymour.R;
import com.seymourapp.seymour.view.bindable.BindableView;

import java.util.Date;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

public class FeedItemView extends LinearLayout implements BindableView<FeedItemView.ViewData> {

  private final ImageView iconView;
  private final TextView feedTitleView;
  private final TextView titleView;
  private final TextView summaryView;
  private final TextView datePublishedView;
  public FeedItemView(Context context) {
    this(context, null);
  }

  public FeedItemView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public FeedItemView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    setOrientation(VERTICAL);
    setFocusable(true);
    LayoutInflater.from(context).inflate(R.layout.feeditem, this, true);

    feedTitleView = findViewById(R.id.feeditem_feed_title_view);
    datePublishedView = findViewById(R.id.feeditem_date_published_view);
    iconView = findViewById(R.id.feeditem_icon_view);
    titleView = findViewById(R.id.feeditem_title_view);
    summaryView = findViewById(R.id.feeditem_summary_view);
  }

  @Override
  public void bindView(@Nullable ViewData viewData) {
    setFeedTitle(viewData == null ? "" : viewData.feedTitle());
    setDatePublished(viewData == null ? new Date() : viewData.datePublished());
    setIcon(viewData == null ? R.drawable.ic_rss_feed_black_24px : viewData.icon());
    setTitle(viewData == null ? "" : viewData.title());
    setSummary(viewData == null ? "" : viewData.summary());
    setOnClickListener(viewData == null ? null : viewData.onClickListener());
  }

  @Override
  public void unbindView() {
    // Do nothing for now...
  }

  public void setFeedTitle(CharSequence feedTitle) {
    feedTitleView.setText(feedTitle);
  }

  public void setDatePublished(Date datePublished) {
    datePublishedView.setText(DateFormat.getTimeFormat(getContext()).format(datePublished));
  }

  public void setIcon(@DrawableRes int icon) {
    iconView.setImageResource(icon);
  }

  public void setTitle(CharSequence title) {
    titleView.setText(title);
  }

  public void setSummary(CharSequence summary) {
    summaryView.setText(summary);
  }

  @AutoValue
  public abstract static class ViewData implements com.seymourapp.seymour.view.bindable.ViewData {

    public static ViewData.Builder builder() {
      return new AutoValue_FeedItemView_ViewData.Builder()
          .datePublished(new Date())
          .icon(R.drawable.ic_rss_feed_black_24px);
    }

    public abstract @DrawableRes int icon();

    public abstract CharSequence feedTitle();

    public abstract CharSequence title();

    public abstract CharSequence summary();

    public abstract Date datePublished();

    @Nullable
    public abstract OnClickListener onClickListener();

    @AutoValue.Builder
    public abstract static class Builder {

      public abstract ViewData build();

      public abstract Builder icon(@DrawableRes int icon);

      public abstract Builder feedTitle(CharSequence feedTitle);

      public abstract Builder title(CharSequence title);

      public abstract Builder summary(CharSequence summary);

      public abstract Builder datePublished(Date published);

      public abstract Builder onClickListener(OnClickListener listener);
    }
  }
}
