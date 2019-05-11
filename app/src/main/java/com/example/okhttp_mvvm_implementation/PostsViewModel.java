package com.example.okhttp_mvvm_implementation;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

public class PostsViewModel extends AndroidViewModel {

    private MutableLiveData<List<Post>> posts;

    public PostsViewModel(Application application) {
        super (application);
        posts = Repository.getPosts();
    }

    public MutableLiveData<List<Post>> getPosts(){
        return posts;
    }

}
