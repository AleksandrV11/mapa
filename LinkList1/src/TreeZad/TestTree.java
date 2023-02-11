package TreeZad;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TestTree {
    public static void main(String[] args) {

        Tree<Integer> tTree = new Tree<>();
        tTree.add(20);
        tTree.add(5);
        tTree.add(2);
        tTree.add(16);
        tTree.add(24);
        tTree.add(26);
        tTree.add(22);
        tTree.add(25);
        tTree.add(28);
        tTree.add(11);
        tTree.add(12);
        tTree.add(10);
        tTree.add(9);
        tTree.add(18);
        tTree.add(19);
        System.out.println("обход рекурсивный в глубину");
        tTree.printTreeDepth();
        System.out.println();
        tTree.del(5);
        System.out.println("обход рекурсивный в глубину после удаления ");
        tTree.printTreeDepth();
        System.out.println();
        System.out.println("обход в ширину");
        tTree.printTreeWidthQueue();
        System.out.println();
        System.out.println("обход итеративный в глубину");
        tTree.printTreeDepthStack();
        System.out.println();
    }
}
