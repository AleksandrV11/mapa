package BinTree;

public class BinTree1 {
    int elem;
    BinTree1 leaf;
    BinTree1 prav;

    public BinTree1(int elem, BinTree1 leaf, BinTree1 prav) {
        this.elem = elem;
        this.leaf = leaf;
        this.prav = prav;
    }

    public BinTree1(int elem) {
        this.elem = elem;
    }

    public int sum() {
        int sum = elem;

        if (leaf != null) {
            sum = sum + leaf.sum();
        }
        if (prav != null) {
            sum = sum + prav.sum();
        }
        return sum;
    }

}
