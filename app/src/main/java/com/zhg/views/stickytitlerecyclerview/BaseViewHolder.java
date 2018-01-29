package com.zhg.views.stickytitlerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by User on 2017/7/21.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected TextView mTextView;
    protected OnItemClickListener mOnItemClickListener;
    public BaseViewHolder(View itemView,int itemType , OnItemClickListener listener) {
        super(itemView);
        mOnItemClickListener = listener;

        mTextView = (TextView) itemView.findViewById(R.id.textview);
        if(itemType == BaseRecyclerAdapter.ITEM_VIEW_TYPE_TITLE){
            mTextView = (TextView) itemView.findViewById(R.id.title_textview);
        }
        itemView.setOnClickListener(this);
    }



    public abstract void bindViewHolder(T t);

    @Override
    public void onClick(View view) {
        if(mOnItemClickListener!=null)
            mOnItemClickListener.onItemClick(view,getAdapterPosition());
    }
}
