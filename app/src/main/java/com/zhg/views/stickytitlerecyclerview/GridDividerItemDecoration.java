package com.zhg.views.stickytitlerecyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by User on 2017/7/25.
 */

public class GridDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Context mContext;
    private List<DetailBean> mList;

    public GridDividerItemDecoration(Context context, List<DetailBean> list) {
        super();
        mContext = context;
        mList = list;

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() instanceof GridLayoutManager) {
            int position = parent.getChildAdapterPosition(view);
            DetailBean bean = mList.get(position);
            if (bean != null && bean.isTitle()) {
                outRect.set(0, 0, 0, 0);
            } else if ("0".equals(bean.getName()) || "1".equals(bean.getName())) {
                outRect.set(0, 5, 5, 0);
            } else if ("2".equals(bean.getName()) || "5".equals(bean.getName()) || "8".equals(bean.getName())) {
                outRect.set(0, 5, 0, 0);
            } else if ("9".equals(bean.getName())) {
                outRect.set(0, 5, 5, 5);
            } else {
                outRect.set(0, 5, 5, 0);
            }
        } else if (parent.getLayoutManager() instanceof LinearLayoutManager) {
            outRect.set(0, 0, 0, 5);
        } else {
            super.getItemOffsets(outRect, view, parent, state);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}
