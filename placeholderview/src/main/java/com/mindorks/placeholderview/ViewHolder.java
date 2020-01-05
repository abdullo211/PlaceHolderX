package com.mindorks.placeholderview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by janisharali on 18/08/16.
 */
public class ViewHolder<T, B extends ViewBinder<T, View>> extends RecyclerView.ViewHolder {

    private B mBinder;

    public ViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(@NonNull B binder, int position) {
        mBinder = binder;
        mBinder.bindView(itemView, position);
    }

    public void recycle() {
        if (mBinder != null) {
            mBinder.recycleView();
            mBinder = null;
        }
    }
}
