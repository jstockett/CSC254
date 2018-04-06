import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CompareListsTest {

        String[] emptyString = new String[10];
        String[] emptyStringSorted = new String[10];
        String[] nullString = null;
        String[] testOne =  {"house", "clueless", "house", "trousers", "23skidoo", "cow","katherine", ""};
        String[] testTwo =  {"P>=M-2r(Pax/wbA.", "eZ9Lc\\XS/{[m[EqV", "[#}Wy%!9qqX", "JZ2U+:patkz",
                "2rLBAr", "5/Na%+Kv", "", "#hbijel;fija"};
        String[] testOneSorted =  { "", "23skidoo", "clueless","cow", "house", "house", "katherine", "trousers"};
        String[] testTwoSorted =  {"", "#hbijel;fija","2rLBAr", "5/Na%+Kv", "JZ2U+:patkz", "P>=M-2r(Pax/wbA.",
                "[#}Wy%!9qqX", "eZ9Lc\\XS/{[m[EqV"};
        String[] testTwoSortedTwo =  {"", "#hbijel;fija","2rLBAr", "5/Na%+Kv", "JZ2U+:patkz", "P>=M-2r(Pax/wbA.",
                "[#}Wy%!9qqX", "eZ9Lc\\XS/{[m[EqV"};




    @Test
    void selectionSort() {

                CompareLists.selectionSort(testOne, testOne.length);
                assertArrayEquals(testOneSorted, testOne);
                CompareLists.selectionSort(testTwo, testTwo.length);
                for(String a : testTwo){
                    System.out.println(a);
                }
                assertArrayEquals(testTwoSorted, testTwo);
                CompareLists.selectionSort(testTwoSorted, testTwoSorted.length);
                assertArrayEquals(testTwoSorted, testTwoSortedTwo);
                CompareLists.selectionSort(emptyString, 0);
                assertArrayEquals(emptyStringSorted, emptyString);

            }

    @Test
    void readFromFile() {
        String[] list = new String[100];
        assertEquals(20, CompareLists.readFromFile("sshPasswords.txt", 100, list));
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
        assertEquals(19, CompareLists.readFromFile("sshPasswords.txt", 19, list));
        assertEquals(0, CompareLists.readFromFile("sshPasswords.txt", 0, list));
        assertEquals(25, CompareLists.readFromFile("topPasswords2016.txt", 100, list));
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
        assertEquals(24, CompareLists.readFromFile("topPasswords2016.txt", 24, list));
        assertEquals(1, CompareLists.readFromFile("topPasswords2016.txt", 1, list));
        assertEquals(0, CompareLists.readFromFile("topPasswords2016.txt", 0, nullString));
    }

    @Test
    void binarySearch() {
        assertEquals(5, CompareLists.binarySearch("house", testOneSorted, testOneSorted.length));
        assertEquals(7, CompareLists.binarySearch("trousers", testOneSorted, testOneSorted.length));
        assertEquals(0, CompareLists.binarySearch("", testOneSorted, testOneSorted.length));
        assertEquals(7, CompareLists.binarySearch("eZ9Lc\\XS/{[m[EqV", testTwoSorted, testTwoSorted.length));
        assertEquals(1, CompareLists.binarySearch("#hbijel;fija", testTwoSorted, testTwoSorted.length));
        assertEquals(-1, CompareLists.binarySearch("#hbijel;fija", nullString, 0));
        assertEquals(-1, CompareLists.binarySearch("#hbijel;fija", emptyString, emptyString.length));

    }

}
