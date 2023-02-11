package BinTree;

public class TestBinTree1 {
    public static void main(String[] args) {
        BinTree1 binTree1 = new BinTree1(20,
                new BinTree1(7, new BinTree1(4, null, new BinTree1(6)),
                        new BinTree1(9)),
                new BinTree1(35, new BinTree1(31, new BinTree1(28), null),
                        new BinTree1(40, new BinTree1(38), new BinTree1(52))));

        // System.out.println(binTree1.sum());


        BinTree1 binTree11 = new BinTree1(7, null, new BinTree1(1,

                new BinTree1(2, new BinTree1(3, new BinTree1(4), new BinTree1(5)),
                        new BinTree1(6)),

                new BinTree1(8, new BinTree1(9, new BinTree1(10), new BinTree1(11)),
                        new BinTree1(12))));
        System.out.println(binTree11.sum());

    }
}
