package com.bw.mvvm_library;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import java.util.HashMap;
import java.util.Map;

/*
 * @ClassName BaseMvvmActivity
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/8/18 9:29
 * @Version 1.0
 */
public abstract class BaseMvvmActivity<VM extends BaseVIewModel,Binding extends ViewDataBinding> extends AppCompatActivity {
    protected VM mViewModel;
    protected Binding mBinding;
    HashMap<Integer, Object> map = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = createViewModel();
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mBinding.setLifecycleOwner(this);
        prepareSetVars(map);
        setVars(map);
        initView();
        loadData();
    }

    protected abstract VM createViewModel();

    protected abstract void initView();

    protected abstract void loadData();


    private void setVars(HashMap<Integer, Object> map){
        if (map.size() == 0){
            throw new RuntimeException("Please set variable...");
        }

        for (Map.Entry<Integer,Object> entry : map.entrySet()){
            mBinding.setVariable(entry.getKey(),entry.getValue());
        }
    }

    protected abstract void prepareSetVars(HashMap<Integer, Object> map);

    protected abstract int getLayoutId();
}
