package com.lxc.liwushuodemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lxc.liwushuodemo.R;

/**
 * Created by Administrator on 2016/10/2.
 */
public class MySrategyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;
    private LayoutInflater inflater;
    private Context context;

    public MySrategyRecyclerViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder myViewHolder = null;
        if (viewType == TYPE_ONE){
            View view = inflater.inflate(R.layout.strategy_recyclerview_item1,parent,false);
            myViewHolder = new MyViewHolderOne(view);
        }else if(viewType == TYPE_TWO){
            View view1 = inflater.inflate(R.layout.strategy_recyclerview_item2,parent,false);
            myViewHolder = new MyViewHolderTwo(view1);
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolderOne){
            ((MyViewHolderOne) holder).text.setText("对象");
        }else if (holder instanceof MyViewHolderTwo){
            MyViewHolderTwo myViewHolderTwo = (MyViewHolderTwo) holder;
            myViewHolderTwo.imageView_0.setImageResource(R.mipmap.ic_launcher);
            myViewHolderTwo.title_0.setText("礼物");
            myViewHolderTwo.content_0.setText("专制送礼困难罪");

            myViewHolderTwo.imageView_1.setImageResource(R.mipmap.ic_launcher);
            myViewHolderTwo.title_1.setText("礼物");
            myViewHolderTwo.content_1.setText("专制送礼困难罪");
        }
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 7 == TYPE_ONE ? TYPE_ONE : TYPE_TWO;
    }

    class MyViewHolderOne extends RecyclerView.ViewHolder{

        TextView text;

        public MyViewHolderOne(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textView_item1_strategy);
        }
    }

    class MyViewHolderTwo extends RecyclerView.ViewHolder{
        ImageView imageView_0, imageView_1;
        TextView title_0,content_0,title_1,content_1;
        public MyViewHolderTwo(View itemView) {
            super(itemView);
            imageView_0 = (ImageView) itemView.findViewById(R.id.imageView_strategy_item1_0);
            title_0 = (TextView) itemView.findViewById(R.id.title_strategy_item1_0);
            content_0 = (TextView) itemView.findViewById(R.id.content_strategy_item1_0);

            imageView_1 = (ImageView) itemView.findViewById(R.id.imageView_strategy_item1_1);
            title_1 = (TextView) itemView.findViewById(R.id.title_strategy_item1_1);
            content_1 = (TextView) itemView.findViewById(R.id.content_strategy_item1_1);
        }
    }
}
