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
public class MainActivityFragment extends Fragment implements JokeListener {

    private EndpointsAsyncTask task;

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
                task = new EndpointsAsyncTask(MainActivityFragment.this);
                task.execute();
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

    /**
     * Called when the fragment is no longer in use.  This is called
     * after {@link #onStop()} and before {@link #onDetach()}.
     */
    @Override
    public void onDestroy() {
        if (task != null) {
            task.cancel(true);
        }
        super.onDestroy();
    }
}
