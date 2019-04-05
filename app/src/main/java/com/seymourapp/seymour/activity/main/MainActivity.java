package com.seymourapp.seymour.activity.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.seymourapp.seymour.R;
import com.seymourapp.seymour.view.listitem.ListItemView;
import com.seymourapp.seymour.view.subheader.SubheaderView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements
    BottomNavigationView.OnNavigationItemSelectedListener {

  private Toolbar toolbar;

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
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_toolbar_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_add_subscription:
        return true;
      case R.id.action_mark_as_read:
        return true;
      case R.id.action_settings:
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);

    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
    bottomNav.inflateMenu(R.menu.main_bottom_nav_menu);
    bottomNav.setOnNavigationItemSelectedListener(this);
    bottomNav.setSelectedItemId(R.id.action_unread);

    SubheaderView subheaderView = findViewById(R.id.subheader_view);
    subheaderView.bindView(
        SubheaderView.ViewData.builder()
            .text("Today")
            .unreadCount(101)
            .build());

    ListItemView folderListItemView = findViewById(R.id.folder_listitem_view);
    folderListItemView.bindView(
        ListItemView.ViewData.builder()
            .icon(R.drawable.ic_folder_open_black_24px)
            .title("Hockey")
            .unreadCount(101)
            .build());

    ListItemView feedListItemView = findViewById(R.id.feed_listitem_view);
    feedListItemView.bindView(
        ListItemView.ViewData.builder()
            .title("The Hockey Writers")
            .unreadCount(53)
            .build());
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    toolbar.setTitle(item.getTitle());
    return true;
  }
}
