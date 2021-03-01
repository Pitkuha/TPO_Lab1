package Algo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BTreeT t = new BTreeT(2); // A B-Tree with minium degree 2
//        t.insert(1);
//        t.insert(3);
//        t.insert(7);
//        t.insert(10);
//        t.insert(11);
//        t.insert(4);
//        t.insert(5);
//        t.insert(2);
//        t.insert(12);
//        t.insert(6);

//        System.out.println("=====================");
//        System.in.read();
//        t.remove(4);
//        t.test();
//        System.out.println("=====================");

//        System.out.println("Traversal of tree constructed is");
//        t.traverse();
//        System.out.println();
//        System.out.println("Хуй: " + t.arrayList.toString());
//        System.out.println();

//        t.search(7);
//        t.search(12);
//        System.out.println(t.arrayList.toString());

//        t.test();

        t.insert(1);
        t.insert(1);
        t.insert(1);
        t.insert(1);
        t.insert(1);
        t.remove(1);
        t.search(1);
        System.out.println(t.arrayList.toString());
    }
}
