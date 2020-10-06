package com.flex;


public abstract class Service {
    protected Info info;

    public Info getInformation() {
        return info;
    }

    public abstract OperationInfo tabLastOperation();

    public abstract void run();
}
