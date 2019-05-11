package com.example.okhttp_mvvm_implementation;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PostsFragment extends Fragment {
    private RecyclerView recyclerView;

    private static final String UID_KEY = "uid";

    private PostsAdapter postsAdapter;

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);

        postsAdapter = new PostsAdapter();
        recyclerView.setAdapter(postsAdapter);

        final PostsViewModel viewModel= ViewModelProviders.of(this).get(PostsViewModel.class);
        observeViewModel(viewModel);
//
    }


    public void observeViewModel(PostsViewModel viewModel){
        viewModel.getPosts().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(@Nullable List<Post> posts) {
                Log.d("hey", "onChanged: " + posts.size());
                if(posts !=null){
                    postsAdapter.setPost(posts);
                    postsAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_info, container, false);
    }
}