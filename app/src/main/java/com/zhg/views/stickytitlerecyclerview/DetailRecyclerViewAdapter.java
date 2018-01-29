package com.zhg.views.stickytitlerecyclerview;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * Created by User on 2017/7/21.
 */

public class DetailRecyclerViewAdapter extends BaseRecyclerAdapter<DetailBean> {
    public DetailRecyclerViewAdapter(Context context ,List<DetailBean> list){
        super(context,list);
    }



    @Override
    public int getItemViewType(int position) {
        if(position >=0 && position < mList.size()){
                return  mList.get(position).isTitle() ? ITEM_VIEW_TYPE_TITLE : ITEM_VIEW_TYPE_NORMAL;
        }
            return ITEM_VIEW_TYPE_NORMAL;
    }





    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public BaseViewHolder getHolder(View itemView,int viewType, OnItemClickListener listener) {
        return new DetailViewHolder(itemView,viewType,listener);
    }

    @Override
    public int getLayoutId(int viewType) {
        return viewType == ITEM_VIEW_TYPE_TITLE  ? R.layout.detail_title : R.layout.common_rv_item;
    }

    public class DetailViewHolder extends BaseViewHolder<DetailBean>{

        public DetailViewHolder(View itemView,int viewType,OnItemClickListener listener) {
            super(itemView,viewType, listener);
        }

        @Override
        public void bindViewHolder(DetailBean detailBean) {
                mTextView.setText(detailBean.getName());
        }
    }
}
