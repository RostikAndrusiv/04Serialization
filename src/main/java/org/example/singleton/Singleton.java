package org.example.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

    private static Singleton instance = null;

    public int i = 1;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public Object readResolve() {
        return getInstance();
    }

}

