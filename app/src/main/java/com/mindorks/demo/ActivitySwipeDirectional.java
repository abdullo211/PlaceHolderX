package com.mindorks.demo;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mindorks.demo.swipe.TinderDirectionalCard;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipeDirectionalView;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;

/**
 * Created by janisharali on 09/08/17.
 */

public class ActivitySwipeDirectional extends AppCompatActivity {

    private static final String TAG = "ActivityTinder";

    private SwipeDirectionalView mSwipeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinder_directional_swipe);
        mSwipeView = findViewById(R.id.swipeView);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipeView.addItemRemoveListener(new ItemRemovedListener() {

            @Override
            public void onItemRemoved(int count) {
                Log.d(TAG, "onItemRemoved: " + count);
                if (count == 0) {
                    mSwipeView.addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard())
                            .addView(new TinderDirectionalCard());
                }
            }
        });
        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setIsUndoEnabled(true)
                .setSwipeVerticalThreshold(Utils.dpToPx(50))
                .setSwipeHorizontalThreshold(Utils.dpToPx(50))
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        mSwipeView.addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard())
                .addView(new TinderDirectionalCard());
    }

    private void onRejectClick() {
        mSwipeView.doSwipe(false);
    }

    private void onAcceptClick() {
        mSwipeView.doSwipe(true);
    }

    private void onUndoClick() {
        mSwipeView.undoLastSwipe();
    }
}
