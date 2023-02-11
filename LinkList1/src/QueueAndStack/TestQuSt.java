package QueueAndStack;

import java.util.ArrayList;

public class TestQuSt {
    public static void main(String[] args) {
        zapQu();
        zapSt();
//
//        Stak<Integer> integerStak = new Stak<>();
//        integerStak.push(7);
//        integerStak.push(5);
//        integerStak.push(3);
//        integerStak.push(9);
//        integerStak.push(8);
//        integerStak.push(4);
//        integerStak.push(2);
//        integerStak.push(7);
//        integerStak.push(9);
//        integerStak.push(11);
//        while (!integerStak.isEmpti()) {
//            System.out.println(integerStak.pop());
//        }
    }

    private static void zapSt() {
        Stak<Integer> integerStak = new Stak<>();
        for (int i = 0; i < 10; i++) {
            integerStak.push(i);
            System.out.println(i);
        }
        System.out.println("++++++++++");
        while (!integerStak.isEmpti()) {
            System.out.println(integerStak.pop());
        }
    }


    private static void zapQu() {
        Queu<Integer> integerQueu = new Queu<>();
        for (int i = 0; i < 10; i++) {
            integerQueu.add(i);
            System.out.println(i);
        }
        System.out.println("-------------");
        while (!integerQueu.isEmpty()) {
            System.out.println(integerQueu.remove());
        }
    }

}
