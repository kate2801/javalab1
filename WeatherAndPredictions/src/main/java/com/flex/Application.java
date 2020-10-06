package com.flex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

class Application {
    private LinkedList<Service> services = new LinkedList<Service>();
    private ArrayList<OperationInfo> history = new ArrayList<OperationInfo>();


    public Application() {
    }
    public void addService(Service service)
    {
        if(service != null)
        {
            services.add(service);
        }
    }
    public void useService(int index) {
        if (services.size() > index && index >= 0) {
            services.get(index).run();
            OperationInfo info = services.get(index).tabLastOperation();
            if(info != null)
                history.add(info);
        }
    }

    public Collection<OperationInfo> getHistory() {
        return history;
    }

    public Iterable<Service> getServices() {
        return services;
    }
}