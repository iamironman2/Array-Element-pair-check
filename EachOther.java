/*A Java program to check if an integer element in an array is present next to each other or is
 separated by an element using an Un-Object-Oriented approach*/

import java.io.*;
import java.lang.*;
import java.util.Scanner;

public class EachOther {
    public static void main(String[] args) {
        int arr[];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the no. of integer elements for the array");
        int elementno = sc.nextInt();

        if (elementno == 0) {
            System.out.println("CAN'T CHECK AN ARRAY WITH NO ELEMENTS DUMBB!!!");
            System.exit(0);
        }
        else if (elementno == 1) {
            System.out.println("HOW THE HELL AM I SUPPOSED TO CHECK A NO. IN PAIR IN AN ARRAY OF 1 ELEMENT DAMNN!!!");
            System.exit(0);
        }
        else {
            arr = new int[elementno];
            int i;
            int length = arr.length;

            System.out.println("Enter the elements");
            for (i = 0; i < length; i++)
                arr[i] = sc.nextInt(); // 72,73,74,72,73,72

            if (elementno == 2) {
                if (arr[0] == arr[1]) {
                    System.out.println("Both numbers are " + arr[0] + " ,that is present in pair yeah!");
                    System.exit(0);
                }
                else {
                    System.out.println("Both no.s are not same therefore not present in pair.");
                    System.exit(0);
                }
            }
            else {
                System.out.println("Enter the number to be checked");
                int spec = sc.nextInt(); //72

                for (i = 0; i < length; i++) {
                    if (arr[i] == spec) {
                        if (i == length - 1) { //Terminate program if the specified no. is the last element
                            System.out.println("Not present.");
                            System.exit(0);
                        }
                        else if (i == length - 2) { /* Only check if the specified no. is present in consecutive pair to prevent AOOB exception
                        when the specified no. is the penultimate element*/
                            if (arr[i+1] == spec) {
                                System.out.println(spec + " is present at penultimate(" + (i + 1) + ") and last(" +
                                        (i + 2) + ") positions  consecutively ");
                                System.exit(0);
                            }
                            else {
                                System.out.println("Not present.");
                                System.exit(0);
                            }
                        }
                        else if (arr[i + 1] == spec) { //Now checking both conditions but separately to get correct indices
                            System.out.println(spec + " is present at indices " + (i + 1) + " and " + (i + 2));
                            System.exit(0);
                        }
                        else if (arr[i + 2] == spec) { //As stated above
                            System.out.println(spec + " is  present at indices " + (i + 1) + " and " + (i + 3));
                            System.out.println("The number separating them is " + arr[i + 1]);
                            System.exit(0);
                        }
                        //var i increments here and condition is rechecked , continues till satisfied or all elements are checked
                    }
                }
                System.out.println("Not present");
            }
        }
    }
}
