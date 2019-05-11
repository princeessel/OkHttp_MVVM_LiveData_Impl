package com.example.okhttp_mvvm_implementation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private List<Post> postList;

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_list,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.mTextViewId.setText(postList.get(i).getUserId().toString());
        viewHolder.mTextViewTitle.setText(postList.get(i).getTitle());
        viewHolder.mTextViewBody.setText(postList.get(i).getBody());

    }

    @Override
    public int getItemCount() {
        if (postList == null) {
            return 0;
        }
        return postList.size();
    }

    public void setPost(List<Post> posts) {
        this.postList=posts;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

     protected TextView mTextViewId, mTextViewTitle, mTextViewBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewId=itemView.findViewById(R.id.user_id);
            mTextViewTitle=itemView.findViewById(R.id.post_title);
            mTextViewBody=itemView.findViewById(R.id.post_body);

        }
    }
}
