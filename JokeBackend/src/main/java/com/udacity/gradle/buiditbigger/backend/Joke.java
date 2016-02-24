package com.udacity.gradle.buiditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class Joke {

    private String theJoke;

    public String getTheJoke() {
        return theJoke;
    }

    public void setTheJoke(String data) {
        theJoke = data;
    }
}