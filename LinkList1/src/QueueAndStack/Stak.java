package QueueAndStack;

import java.util.ArrayList;

public class Stak<T> implements Stack<T> {
    ArrayList<T> stList = new ArrayList<>();

    @Override
    public void push(T elem) {
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
}
