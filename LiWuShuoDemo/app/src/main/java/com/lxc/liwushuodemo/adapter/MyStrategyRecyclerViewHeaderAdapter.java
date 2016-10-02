package com.lxc.liwushuodemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lxc.liwushuodemo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/10/2.
 */
public class MyStrategyRecyclerViewHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;

    public MyStrategyRecyclerViewHeaderAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder myViewHolder = null;
        if (viewType == TYPE_ONE) {
            View view = inflater.inflate(R.layout.strategy_recyclerview_item1, parent, false);
            myViewHolder = new MyViewHolderOne(view);
        } else if (viewType == TYPE_TWO) {
            View view1 = inflater.inflate(R.layout.strategy_recyclerview_header_item2, parent, false);
            myViewHolder = new MyViewHolderTwo(view1);
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolderOne) {
            ((MyViewHolderOne) holder).text.setText("栏目");
        } else if (holder instanceof MyViewHolderTwo) {
            MyViewHolderTwo holderTwo = ((MyViewHolderTwo) holder);
            holderTwo.content.setText("艾因烧钱");
            holderTwo.title.setText("数码家");

        }
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    @Override
    public int getItemViewType(int position) {

        return position == TYPE_ONE ? TYPE_ONE : TYPE_TWO;
    }

    class MyViewHolderOne extends RecyclerView.ViewHolder {
        TextView text;

        public MyViewHolderOne(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textView_item1_strategy);
        }
    }

    class MyViewHolderTwo extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, content;

        public MyViewHolderTwo(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview_strategy_header);
            title = (TextView) itemView.findViewById(R.id.title_strategy_header);
            content = (TextView) itemView.findViewById(R.id.content_strategy_header);
        }
    }
}
