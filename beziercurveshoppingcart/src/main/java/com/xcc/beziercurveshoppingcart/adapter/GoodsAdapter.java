package com.xcc.beziercurveshoppingcart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.xcc.beziercurveshoppingcart.R;
import com.xcc.beziercurveshoppingcart.model.GoodsModel;

import java.util.ArrayList;

/**
 * Created by 徐陈承 on 2016/11/4.
 */

public class GoodsAdapter extends BaseAdapter {
    //数据源
    private ArrayList<GoodsModel> mData;
    //布局
    private LayoutInflater mLayoutInflater;
    // 回调监听
    private CallBackListener mCallBackListener;

    public GoodsAdapter(Context context, ArrayList<GoodsModel> mData) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mData != null ? mData.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.adapter_shopping_cart_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            //复用viewholder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //更新UI
        if (position < mData.size()) {
            viewHolder.updateUI(mData.get(position));
        }


        return convertView;
    }

    class ViewHolder {
        private ImageView mShoppingCartItemIv;

        public ViewHolder(View view) {
            mShoppingCartItemIv = (ImageView) view.findViewById(R.id.iv_shopping_cart_item);
            view.findViewById(R.id.tv_shopping_cart_item).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mShoppingCartItemIv != null && mCallBackListener != null) {
                        mCallBackListener.callBackImg(mShoppingCartItemIv);
                    }
                }
            });
        }


        //更新UI
        public void updateUI(GoodsModel goods) {
            if (goods != null && goods.getmGoodsBitmap() != null && mShoppingCartItemIv != null) {
                mShoppingCartItemIv.setImageBitmap(goods.getmGoodsBitmap());
            }
        }



    }

    //设置回调监听
    public void setCallBackListener(CallBackListener mCallBackListener) {
        this.mCallBackListener = mCallBackListener;
    }

    //回调监听
    public interface CallBackListener {
        void callBackImg(ImageView goodsImg);
    }
}
