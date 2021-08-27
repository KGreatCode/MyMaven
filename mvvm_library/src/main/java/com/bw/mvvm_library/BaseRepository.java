package com.bw.mvvm_library;

/*
 * @ClassName BaseRepository
 * @Description TODO
 * @Version 1.0
 */
public abstract class BaseRepository<M extends IModel>{
    protected M model;

    public BaseRepository() {
        model = createModel();
    }


    protected abstract M createModel();
}
