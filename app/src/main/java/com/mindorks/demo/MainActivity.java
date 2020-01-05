package com.mindorks.demo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.mindorks.demo.drawer.DrawerHeader;
import com.mindorks.demo.drawer.DrawerMenuItem;
import com.mindorks.demo.gallery.ImageTypeBig;
import com.mindorks.demo.gallery.ImageTypeSmallPlaceHolder;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private PlaceHolderView mDrawerView;

    private DrawerLayout mDrawer;

    private Toolbar mToolbar;

    private PlaceHolderView mGalleryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawer = findViewById(R.id.drawerLayout);
        mDrawerView = findViewById(R.id.drawerView);
        mToolbar = findViewById(R.id.toolbar);
        mGalleryView = findViewById(R.id.galleryView);
        setupDrawer();
        setupGallery();
    }

    private void setupDrawer() {
        mDrawerView
                .addView(new DrawerHeader())
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()));

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    private void setupGallery() {

//        mGalleryView.getBuilder()
//                .setHasFixedSize(false)
//                .setItemViewCacheSize(10)
//                .setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//                .setLayoutManager(new GridLayoutManager(this, 3));
//        for (Image image : imageList){
//            mGalleryView.addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, image.getUrl()));
//        }

        List<Image> imageList = Utils.loadImages(this.getApplicationContext());
        List<Image> newImageList = new ArrayList<>();
        for (int i = 0; i < (imageList.size() > 10 ? 10 : imageList.size()); i++) {
            newImageList.add(imageList.get(i));
        }
        mGalleryView.addView(new ImageTypeSmallPlaceHolder(this.getApplicationContext(), newImageList));

        for (int i = imageList.size() - 1; i >= 0; i--) {
            mGalleryView.addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, imageList.get(i).getUrl()));
        }
    }
}
