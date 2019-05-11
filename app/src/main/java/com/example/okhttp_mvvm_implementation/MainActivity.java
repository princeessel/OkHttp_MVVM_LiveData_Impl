package com.example.okhttp_mvvm_implementation;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
        PostsFragment postsFragment =new PostsFragment();
// work here to change Activity fragments (add, remove, etc.).  Example here of adding.
        fragmentTransaction.add (R.id.fragment_container, postsFragment, "Hey");
        fragmentTransaction.commit ();

    }
}
