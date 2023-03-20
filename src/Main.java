import edu.greenriver.sdev333.BSTSet;
import edu.greenriver.sdev333.MathSet;
import edu.greenriver.sdev333.SequentialSearchST1;
import edu.greenriver.sdev333.SymbolTable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //write code to verify code works
        //create 2 sets, add items to each set (with some diff values)
        //test set intersection, set union, set difference
        MathSet<String> set1 = new BSTSet<>();
        set1.add("Ken");
        set1.add("Tina");
        set1.add("Timmy");

        MathSet <String> set2 = new BSTSet<>();
        set1.add("Ken");
        set1.add("Tina");
        set1.add("Ben");
        set1.add("Jeff");

        MathSet<String> result1 = set1.union(set2);
        for (String key: result1.keys()) {
            System.out.println(key);
        }

        String inputString = "S E A R C H E X A M P L E";
        String secondString = "O T H E R S E T";

        Scanner input = new Scanner(inputString);

        // You can replace the implementation with any class that implements
        // SymbolTable interface
        SymbolTable<String, Integer> st = new SequentialSearchST1<>();

        int i = 0;
        while (input.hasNext()) {
            String key = input.next();
            st.put(key, i);
            i++;
        }

        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
        System.out.println(st.size());
    }
}
