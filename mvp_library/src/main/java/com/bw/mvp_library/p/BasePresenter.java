package com.bw.mvp_library.p;

import com.bw.mvp_library.m.IModel;
import com.bw.mvp_library.v.IView;


public class BasePresenter<M extends IModel,V extends IView> implements IPresenter {
    protected M model;
    protected V view;

    public BasePresenter(M model, V view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void Destory() {
        if (model != null){
            model.Destory();
            model = null;
        }
        if (view != null){
            view = null;
        }
    }
}
