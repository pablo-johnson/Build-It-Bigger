package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Pablo on 26/02/16.
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    private CountDownLatch countDownLatch;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        countDownLatch = new CountDownLatch(1);
    }

    public void testEndpointsAsyncTask() {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(new JokeListener() {
            @Override
            public void onJokeReceived(String joke) {
                assertNotNull(joke);
                Log.i("pablo", joke);
                countDownLatch.countDown();
            }
        });
        assertNotNull(endpointsAsyncTask);
        endpointsAsyncTask.execute();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
