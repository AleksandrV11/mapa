package QueueAndStack;

import java.util.ArrayList;

public class Queu<T> implements Queue<T> {

    ArrayList<T> qList = new ArrayList<>();

    @Override
    public void add(T elem) {
        qList.add(0, elem);
    }

    @Override
    public T remove() {
        return qList.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return qList.isEmpty();
    }


}
