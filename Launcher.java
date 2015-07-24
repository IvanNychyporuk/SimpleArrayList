package HWFrame5;

import java.util.Arrays;

/**
 * Created by Иван on 21.06.2015.
 */
public class Launcher {
    public static void main(String[] args) {
        SimpleArrayList sal = new SimpleArrayList();

        sal.add("a");
        sal.add("b");
        sal.add("c");
        sal.add("f");
        sal.add("g");
        sal.add("z");

        sal.printList();
        sal.set(3,"e");
        sal.printList();
        sal.set(3,"d");
        sal.printList();
        System.out.println("Does the list contains \"a\" : " + sal.contains("a"));
        System.out.println(sal.get(4));
        System.out.println(Arrays.toString(sal.toArray()));
        sal.remove("p");
        System.out.println(Arrays.toString(sal.toArray()));
        for (Object o : sal){
            if (o instanceof String) {
                System.out.print(o + " ");
            }
        }
        System.out.println();
        sal.set(7,"h");
        sal.set(0,"z");
        sal.printList();
    }
}
