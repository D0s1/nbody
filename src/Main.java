// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Eingabe with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        // Press Umschalt+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Umschalt+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Strg+F8.
            System.out.println("i = " + i);
        }
        test testa=new test();
        testa.zahl(2);
        System.out.println(testa.zahl(4));
        testa.setzea(20);
        System.out.println(testa.zahl(4));
        int [] a = {1,2,3,4,1};
        System.out.println(Arrays.toString(a));
        System.out.println((testa.istsortiert(a)));
        System.out.println(Arrays.toString(testa.sortierrec(a)));
        int [] c = {5,4,1,7,8,9,3,2,2};
        System.out.println(Arrays.toString(testa.testmerge(c)));



    }



}