package LList;

public class ArrList<T> implements List<T> {
    Object[] arr = new Object[2];
    int size = 0;


    private void proverka() {
        if (arr.length == size) {
            Object[] newarray = new Object[size * 2];
            for (int i = 0; i < size; i++) {
                newarray[i] = arr[i];
            }
            arr = newarray;
        }
    }

    @Override
    public void add(T elem) {
        proverka();
        arr[size] = elem;
        size++;
    }

    @Override
    public void add( T elem,int ind) {
        proverka();
        Object b = null;
        //  elem = (T) b;
        Object[] newarray = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i < ind) {
                newarray[i] = arr[i];
            }
            if (i > ind) {
                newarray[i] = arr[i - 1];
            }
            if (i == ind) {
                newarray[i] = elem;
            }
        }
        for (int i = 0; i < newarray.length; i++) {
            arr[i] = newarray[i];
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int ind) {

        if (ind >= size || ind < 0) {
            throw new IndexOutOfBoundsException("Чувак это далеко");
        }
        Object[] newarray = new Object[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {

            if (i == ind) {
                newarray[i] = arr[i + 1];
            }
            if (i < ind) {
                newarray[i] = arr[i];
            }
            if (i > ind) {
                newarray[i] = arr[i + 1];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newarray[i];
        }
        size--;
    }

    @Override
    public void remove() {
        if (size==0){
            System.out.println("Арей пустой ");
        }
        Object[] newarray = new Object[arr.length-1];
        for (int i=0;i<newarray.length;i++){
            newarray[i]=arr[i];
        }
        size--;
    }

    @Override
    public T set(int ind, T elem) {

        if (ind >= size || ind < 0) {
            throw new IndexOutOfBoundsException("Чувак это далеко");
        }
        arr[ind] = elem;

        return null;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    @Override
    public T get(int ind) {

        return (T) arr[ind];
    }


}
