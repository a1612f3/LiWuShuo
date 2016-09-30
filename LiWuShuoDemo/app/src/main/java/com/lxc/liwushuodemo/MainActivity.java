package com.lxc.liwushuodemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lxc.liwushuodemo.fragment.CategoryFragment;
import com.lxc.liwushuodemo.fragment.GiftFragment;
import com.lxc.liwushuodemo.fragment.HomeFragment;
import com.lxc.liwushuodemo.fragment.ProfileFragment;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;
    private HomeFragment homeFragment = null;
    private GiftFragment giftFragment = null;
    private CategoryFragment categoryFragment = null;
    private ProfileFragment profileFragment = null;

    private Fragment showFragment = null;
    private RadioGroup radioGroup = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        fragmentManager = getSupportFragmentManager();
        radioGroup = (RadioGroup) findViewById(R.id.rg_main_buttonmenus);
        radioGroup.setOnCheckedChangeListener(this);
        showCurrentFragment(HomeFragment.class);
        RadioButton radioButton = (RadioButton) findViewById(R.id.rb_home);
        radioButton.setChecked(true);
    }

    private void showCurrentFragment(Class<? extends Fragment> classname){
        fragmentTransaction = fragmentManager.beginTransaction();
        if (showFragment != null) {
            fragmentTransaction.hide(showFragment);
        }
        showFragment = fragmentManager.findFragmentByTag(classname.getName());
        if (showFragment != null) {
            fragmentTransaction.show(showFragment);
        }else {
            try {
                showFragment = classname.getConstructor().newInstance();
                fragmentTransaction.add(R.id.container_main,showFragment,classname.getName());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_home:
                showCurrentFragment(HomeFragment.class);
                break;
            case R.id.rb_gift:
                showCurrentFragment(GiftFragment.class);
                break;
            case R.id.rb_category:
                showCurrentFragment(CategoryFragment.class);
                break;
            case R.id.rb_profile:
                showCurrentFragment(ProfileFragment.class);
                break;
        }
    }
}
