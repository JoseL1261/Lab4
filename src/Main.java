import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unsorted Array ---------------------------------------------------");
        ArrayList<Integer> integerList = Lab4.getList();
        Lab4.outputList(integerList);

        System.out.println("\n\nBubble sort results ----------------------------------------------");
        long bubbleSortStartTime = System.currentTimeMillis();
        ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
        long bubbleSortEndTime = System.currentTimeMillis();
        Lab4.outputList(bubbleSortedList);
        System.out.println(
                "\nBubble sort execution time: " + (bubbleSortEndTime - bubbleSortStartTime) + " milliseconds");

        System.out.println("\n\nInsertion sort results -------------------------------------------");
        long insertionSortStartTime = System.currentTimeMillis();
        ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList);
        long insertionSortEndTime = System.currentTimeMillis();
        Lab4.outputList(insertionSortedList);
        System.out.println(
                "\nInsertion sort execution time: " + (insertionSortEndTime - insertionSortStartTime)
                        + " milliseconds");
    }
}

class Lab4 {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
        for (int i = 1; i < integerList.size(); i++) {
            int temp = integerList.get(i);
            int j;

            for (j = i - 1; j >= 0 && integerList.get(j) > temp; j--) {
                integerList.set(j + 1, integerList.get(j));
            }

            integerList.set(j + 1, temp);
        }

        return integerList;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
        for (int i = 1; i < integerList.size(); i++) {
            boolean nextPass = false;

            for (int k = 0; k < integerList.size() - i; k++) {
                if (integerList.get(k) > integerList.get(k + 1)) {
                    int temp = integerList.get(k);
                    integerList.set(k, integerList.get(k + 1));
                    integerList.set(k + 1, temp);
                    nextPass = true;
                }
            }
            if (!nextPass) {
                break;
            }
        }

        return integerList;
    }

    public static ArrayList<Integer> getList() {
        ArrayList<Integer> integerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src\\integers.txt"))) {
            while ((line = br.readLine()) != null) {
                integerList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }

    public static void outputList(ArrayList<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i) + " ");
        }
    }
}
/*
 * 1) If were to implement a sorting algorithm I would implement the quicksort
 * algorithm because out of the bunch that was taught in this lession and the
 * watching the vidoes it
 * was the fastest to execute large amount of numbers.
 * 2) yes, after executing serveral time the bubble sort took a bit longer then
 * the insertion sort as the insertion sort took no time but the bubble sort
 * took some time to run through
 * the list. This overall make sense due to bubble sort having Big- O complexity
 * of O(n^2) making it one of the worst but still have it uses.
 * 3) At first glance and understanding merge sort was the simplest for me to
 * understand, but for implementing and understanding the insertion sort was the
 * simplest since the code was
 * short and the example made it look simple to understand.
 */