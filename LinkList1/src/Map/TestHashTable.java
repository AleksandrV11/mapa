package Map;

import java.util.Arrays;

public class TestHashTable {
    public static void main(String[] args) {
//        MyMap<Integer, String> map = new MyHashTable<>();
//        map.put(8, "gggggggg");
//        map.put(7, "ggggggg");
//        map.put(6, "gggggg");
//        map.put(5, "ggggg");
//        map.put(4, "gggg");
//        map.put(3, "ggg");
//        map.put(1, "g");
//        map.put(1, "gg");
//        map.put(9, "ggggggggg");
//        map.put(10, "gggggggggg");
//        map.put(11, "ggggggggggg");
//        map.put(12, "gggggggggggg");
//        map.put(13, "ggggggggggggg");
//        System.out.println(map);

        //  System.out.println(map);

        MyHashTable myHashTable = new MyHashTable();

        myHashTable.put(1,"y");
        myHashTable.put(2,"y");
        myHashTable.put(3,"y");
        myHashTable.put(4,"y");
        myHashTable.put(5,"y");
        myHashTable.put(6,"y");
        myHashTable.put(7,"y");
        myHashTable.put(8,"y");
        myHashTable.put(9,"y");
        myHashTable.put(10,"y");
        myHashTable.put(11,"y");
        myHashTable.put(12,"y");
        myHashTable.put(13,"y");
        myHashTable.put(14,"y");




        myHashTable.zapoln();
        for (MyHashTable.Node node : myHashTable.valClon) {
            System.out.println(node);
        }


//        for (MyHashTable.Node node : myHashTable.valClon) {
//            System.out.println(node);
//        }

        //   int f=myHashTable.size();

//        map.put(79,"g");

        // String f = map.get(88);
        //System.out.println(f);


    }
}
