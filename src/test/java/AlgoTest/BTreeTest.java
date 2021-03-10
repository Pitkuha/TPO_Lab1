package AlgoTest;

import Algo.BTreeT;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BTreeTest extends Assert {
    private BTreeT t = new BTreeT(2); // A B-Tree with minium degree 2
    private BTreeT o = new BTreeT(2);

    //Инициализация BTree
    @Before
    public void init() {
        t.insert(1);
        t.insert(3);
        t.insert(7);
        t.insert(10);
        t.insert(11);
        t.insert(4);
        t.insert(5);
        t.insert(2);
        t.insert(12);
        t.insert(6);

        o.insert(1);
        o.insert(1);
        o.insert(1);
        o.insert(1);
        o.insert(1);
        System.out.println("Элементы инициализированы");
    }

    @Test
    public void Traversal() {
        System.out.println("Первое BTree");
        System.out.println("Вывод элементов");
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 10, 11, 12]", t.traverse().toString());
        t.remove(3);
        assertEquals("[1, 2, 4, 5, 6, 7, 10, 11, 12]", t.traverse().toString());
        t.remove(4);
        assertEquals("[1, 2, 5, 6, 7, 10, 11, 12]", t.traverse().toString());
        t.remove(4);
        assertEquals("[1, 2, 5, 6, 7, 10, 11, 12]", t.traverse().toString());
        t.insert(3);
        assertEquals("[1, 2, 3, 5, 6, 7, 10, 11, 12]", t.traverse().toString());
        System.out.println("Поиск элемента");
        t.search(7);
        assertArrayEquals(new Integer[]{2, 6, 7}, t.arrayList.toArray(new Integer[0]));
        System.out.println(t.arrayList.toString());
        t.search(11);
        assertArrayEquals(new int[]{2, 6, 10, 11}, t.arrayList.stream().mapToInt(i -> i).toArray());
        System.out.println(t.arrayList.toString());
        t.search(10);
        assertArrayEquals(new int[]{2, 6, 10}, t.arrayList.stream().mapToInt(i -> i).toArray());
        System.out.println(t.arrayList.toString());
        System.out.println();
        System.out.println("Второе BTree");
        System.out.println("Вывод элементов");
        assertEquals("[1, 1, 1, 1, 1]", o.traverse().toString());
        o.remove(1);
        assertEquals("[1, 1, 1, 1]", o.traverse().toString());
        System.out.println("Поиск элемента");
        o.search(1);
        assertArrayEquals(new int[]{1}, o.arrayList.stream().mapToInt(i -> i).toArray());
        System.out.println(o.arrayList.toString());
    }


}
