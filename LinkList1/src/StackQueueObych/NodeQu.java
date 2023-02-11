package StackQueueObych;

import java.util.ArrayList;

public class NodeQu<T> implements QueueObych<T> {
    ArrayList<T> quList = new ArrayList<>();

    @Override
    public void add(T elem) {          //
        quList.add(0, elem);
    }

    @Override
    public T remove() {
        return quList.remove(0);

    }

    @Override
    public boolean isEmpti() {
        return quList.isEmpty();
    }
}
