package LList;

public interface List <T>{

    void add(T elem);

    void add(T elem, int ind);

    int size();

    T get(int ind);

    void remove(int ind);

    void remove();

    T set(int ind, T elem);

    void print();

}
