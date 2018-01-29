package com.zhg.views.stickytitlerecyclerview;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * Created by User on 2017/7/21.
 */

public class ClassRecyclerViewAdapter extends BaseRecyclerAdapter<String> {
    public ClassRecyclerViewAdapter(Context context , List<String> list){
        super(context,list);
    }

    @Override
    public BaseViewHolder getHolder(View itemView,int itemType, OnItemClickListener listener) {
        return new ClassViewHolder(itemView,itemType,listener);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.left_class_item_layout;
    }
    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    private class ClassViewHolder extends BaseViewHolder<String>{

        public ClassViewHolder(View itemView,int itemType, OnItemClickListener listener) {
            super(itemView,itemType,listener);
        }

        @Override
        public void bindViewHolder(String s) {
            mTextView.setText("分类"+s);
        }
    }
}
