import java.io.*;
import java.util.Scanner;

public class ArrayManipulation {
    public static void main(String[] args) {

        File file = new File("in2.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String tempString = reader.readLine();
            String[] strArray = tempString.split(" ");

            int length = Integer.parseInt(strArray[0]);
            int count = Integer.parseInt(strArray[1]);

            int[][] testQueries = new int[count][length];

            for (int i = 0; i < count; i++) {
                tempString = reader.readLine();
                String[] anotherArray = tempString.split(" ");
                int[] intArray = new int[anotherArray.length];

                for (int j = 0; j < intArray.length; j++) {
                    intArray[j] = Integer.parseInt(anotherArray[j]);
                }

                for (int j = 0; j < anotherArray.length; j++) {
                    testQueries[i][j] = intArray[j];
                }
            }

            System.out.println(arrayManipulation(length, testQueries));

        } catch (FileNotFoundException e) {
            System.out.println("no such file");
        } catch (IOException e) {
            System.out.println("issue reading file");
        }



        //System.out.println(arrayManipulation(4000, testQueries));
    }

    static long arrayManipulation(int n, int[][] queries) {
        long result = 0;
        long[] anArray = new long[n];

        for (int i = 0; i < queries.length; i++) {
            int startIndex = queries[i][0];
            int stopIndex = queries[i][1];
            int operation = queries[i][2];

            for (int j = startIndex; j < stopIndex; j++) {
                anArray[j] += operation;
                //System.out.println("Comparing " + anArray[j] + " with " + result);
                if (anArray[j] > result) {
                    result = anArray[j];
                }
            }
        }
        return result;
    }
}
