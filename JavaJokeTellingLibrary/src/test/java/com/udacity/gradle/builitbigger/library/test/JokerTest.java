package com.udacity.gradle.builitbigger.library.test;

import com.udacity.gradle.builitbigger.library.Joker;

import org.junit.Test;

public class JokerTest {

    @Test
    public void test() {
        Joker joker = new Joker();
        assert joker.getAJoke().length() != 0;
    }

}
