package com.flex;


public class Info {

    public String name;
    public String description;
    public int price;
    public Info(String name, String description, int price)
    {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + '\n' + description;
    }
}
