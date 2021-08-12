package com.bw.mvp_library.v;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.mvp_library.p.IPresenter;

public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IActivity, IView, IFragment {
    protected P p;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(bindLayout(), container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
        showLoading();
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return inflate.findViewById(id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (p != null){
            p.Destory();
            p = null;
        }
    }
}
