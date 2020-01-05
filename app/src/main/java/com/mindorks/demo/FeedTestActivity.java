package com.mindorks.demo;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.mindorks.demo.feed.HeadingView;
import com.mindorks.demo.feed.InfoView;
import com.mindorks.demo.feed.data.Feed;
import com.mindorks.demo.feed.data.Info;
import com.mindorks.placeholderview.ExpandablePlaceHolderView;


public class FeedTestActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private ExpandablePlaceHolderView mExpandableView;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_test);
        mExpandableView = findViewById(R.id.expandableView);
        mContext = this.getApplicationContext();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        for(Feed feed : Utils.loadFeeds(this.getApplicationContext())){
            mExpandableView.addView(new HeadingView(mContext, feed.getHeading()));
            for(Info info : feed.getInfoList()){
                mExpandableView.addView(new InfoView(mContext, info));
            }
        }
    }
}
