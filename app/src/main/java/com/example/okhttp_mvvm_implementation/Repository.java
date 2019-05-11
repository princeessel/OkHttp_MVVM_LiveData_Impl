package com.example.okhttp_mvvm_implementation;

import android.arch.lifecycle.MutableLiveData;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.support.constraint.Constraints.TAG;

public class Repository {

    public Repository() {
    }

    private static final String URI_POSTS = "https://jsonplaceholder.typicode.com/posts";

    public static MutableLiveData<List<Post>> getPosts(){
        final MutableLiveData<List<Post>> posts = new MutableLiveData<>();

        // initiliaze http client
        OkHttpClient okHttpclient = new OkHttpClient();

        // initiliaze request
        Request request = new Request.Builder()
                                     .url(URI_POSTS)
                                      .get()
                                      .build();
            okHttpclient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.i(TAG, e.getMessage());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                if(response.isSuccessful()){

                    Handler mainHandler = new Handler(Looper.getMainLooper());
                    Runnable myRunnable = new Runnable() {
                        @Override
                        public void run() {

                            String postsStr = null;
                            try {
                                postsStr = response.body().string();

                                Gson gson = new Gson();
                                Type postType = new TypeToken<List<Post>>(){}.getType();

                                posts.setValue((List<Post>) gson.fromJson(postsStr, postType));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    mainHandler.post(myRunnable);
                }

            }
        });

        return posts;
        }

}
