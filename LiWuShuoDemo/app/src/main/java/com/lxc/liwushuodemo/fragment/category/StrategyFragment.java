package com.lxc.liwushuodemo.fragment.category;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxc.liwushuodemo.R;
import com.lxc.liwushuodemo.adapter.MySrategyRecyclerViewAdapter;
import com.lxc.liwushuodemo.adapter.MyStrategyRecyclerViewHeaderAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class StrategyFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView recyclerViewHeader;
    private MyStrategyRecyclerViewHeaderAdapter myStrategyRecyclerViewHeaderAdapter;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private MySrategyRecyclerViewAdapter mySrategyRecyclerViewAdapter;

    public StrategyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_strategy, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_strategyfragment);
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.strategy_recyclerview_header,null);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);


//        initHeader(header);


        mySrategyRecyclerViewAdapter = new MySrategyRecyclerViewAdapter(getActivity());
        recyclerView.setAdapter(mySrategyRecyclerViewAdapter);



    }

    private void initHeader(View view) {
        recyclerViewHeader = (RecyclerView) view.findViewById(R.id.recyclerview_header);
        gridLayoutManager = new GridLayoutManager(getActivity(),4,GridLayoutManager.HORIZONTAL,false);
        recyclerViewHeader.setLayoutManager(gridLayoutManager);
        myStrategyRecyclerViewHeaderAdapter = new MyStrategyRecyclerViewHeaderAdapter(getActivity());
        recyclerViewHeader.setAdapter(myStrategyRecyclerViewHeaderAdapter);


    }

}
