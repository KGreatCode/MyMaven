package com.bw.mvvm_library;

import androidx.lifecycle.ViewModel;

/*
 * @ClassName BaseVIewModel
 * @Description TODO
 * @Version 1.0
 */
public abstract class BaseVIewModel<Repo extends BaseRepository> extends ViewModel {
    protected Repo mRepository;

    public BaseVIewModel() {
        mRepository = createRepository();
    }

    protected abstract Repo createRepository();
}
