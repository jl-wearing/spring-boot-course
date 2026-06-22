package org.example.models;

import org.springframework.stereotype.Component;

public class Parrot {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[name=" + name + "]";
    }
}
