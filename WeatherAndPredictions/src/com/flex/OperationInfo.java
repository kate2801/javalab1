package com.flex;

import java.util.GregorianCalendar;

public class OperationInfo {

    public GregorianCalendar time;
    public String name;
    public String description;
    public int price;

    public OperationInfo(){}
    public OperationInfo(Info info)
    {
        name = info.name;
        description = info.description;
        price = info.price;
    }
}