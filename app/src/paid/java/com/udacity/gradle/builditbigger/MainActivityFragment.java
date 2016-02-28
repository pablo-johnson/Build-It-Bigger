package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.udacity.gradle.builditbigger.androidLibrary.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokeListener{

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button jokeButton = (Button) root.findViewById(R.id.tellAJokeButton);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask(MainActivityFragment.this).execute();
            }
        });
        return root;
    }

    @Override
    public void onJokeReceived(String joke) {
        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra("joke", joke);
        startActivity(intent);
    }
}
