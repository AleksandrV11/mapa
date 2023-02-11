package StackQueueObych;

import java.util.ArrayList;

public class NodeSt<T> implements StackObuch<T> {
    ArrayList<T> stList = new ArrayList<>();

    @Override
    public void puch(T elem) {
        stList.add(elem);
    }

    @Override
    public T pop() {
        return stList.remove(0);
    }

    @Override
    public boolean isEmpti() {
        return stList.isEmpty();
    }

    private void pushSt(){




    }



}
