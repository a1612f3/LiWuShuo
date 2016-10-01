package com.lxc.liwushuodemo.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxc.liwushuodemo.R;
import com.lxc.liwushuodemo.adapter.MyFragmentPagerAdapter;
import com.lxc.liwushuodemo.fragment.category.BoutiqueFragment;
import com.lxc.liwushuodemo.fragment.category.StrategyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<String> titleList;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private List<Fragment> fragmentList;
    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        viewPager = (ViewPager) view.findViewById(R.id.vp_categoryfragment);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout_categoryfragment);
        //初始化TabLayout
        initTabLayout();
    }

    private void initTabLayout() {
        titleList = new ArrayList<>();
        titleList.add("攻略");
        titleList.add("精品");
        for (int i = 0; i < titleList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(titleList.get(i)));
        }
        //初始化viewPager然后实现联动
        initViewPager();
        //tabLayout与viewPager实现联动
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initViewPager() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new StrategyFragment());
        fragmentList.add(new BoutiqueFragment());
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(myFragmentPagerAdapter);
    }

}
