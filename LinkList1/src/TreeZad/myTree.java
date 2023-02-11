package TreeZad;

public interface myTree<T extends Comparable<T>> {

    public void add(T elem);


    public void printTreeDepth();           //обход в глубину РЕКУРСИВНЫЙ

    public void printTreeWidthQueue();           // очередь обход в ширину

    public void printTreeDepthStack();           // итеративн обход в глубину


}
