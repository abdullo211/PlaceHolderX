package com.mindorks.demo;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.mindorks.demo.expandable.ChildItem;
import com.mindorks.demo.expandable.ParentItem;
import com.mindorks.placeholderview.ExpandablePlaceHolderView;


public class ExpandableActivity extends AppCompatActivity {

    ParentItem parentItem;
    private Toolbar mToolbar;
    private ExpandablePlaceHolderView mExpandableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mToolbar = findViewById(R.id.toolbar);
        mExpandableView = findViewById(R.id.expandableView);
        parentItem = new ParentItem(this.getApplicationContext());

        mExpandableView
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(parentItem)
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView));
    }

//    @OnClick(R.id.collapse)
//    void onCollapse() {
//        try {
//            mExpandableView.collapse(0);
//        }catch (Resources.NotFoundException e){
//            e.printStackTrace();
//        }
//    }
//
//    @OnClick(R.id.expand)
//    void onExpand() {
//        try {
//            mExpandableView.expand(0);
//        }catch (Resources.NotFoundException e){
//            e.printStackTrace();
//        }
//    }

}
