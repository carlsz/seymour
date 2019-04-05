package com.seymourapp.seymour.view.subheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.auto.value.AutoValue;
import com.seymourapp.seymour.R;
import com.seymourapp.seymour.view.bindable.BindableView;

import androidx.annotation.Nullable;

public class SubheaderView extends LinearLayout implements BindableView<SubheaderView.ViewData> {

  @AutoValue
  public abstract static class ViewData implements com.seymourapp.seymour.view.bindable.ViewData {

    public abstract CharSequence text();

    @AutoValue.Builder
    public abstract static class Builder {

      public abstract ViewData build();

      public abstract Builder text(CharSequence title);
    }

    public static ViewData.Builder builder() {
      return new AutoValue_SubheaderView_ViewData.Builder();
    }
  }

  private final TextView subheadTextView;

  public SubheaderView(Context context) {
    this(context, null);
  }

  public SubheaderView(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public SubheaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    setOrientation(HORIZONTAL);
    LayoutInflater.from(context).inflate(R.layout.subheader, this, true);
    subheadTextView = findViewById(R.id.subheader_text_view);
  }

  @Override
  public void bindView(@Nullable ViewData viewData) {
    setSubheaderText(viewData == null ? "" : viewData.text());
  }

  @Override
  public void unbindView() {

  }

  public void setSubheaderText(CharSequence text) {
    subheadTextView.setText(text);
  }
}
