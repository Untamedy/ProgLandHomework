package homework_6;

/**
 *
 * @author YBolshakova
 */
public class ShellSort {
    
public void sort (int[] arr) {
        int increment = arr.length / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(arr, startIndex, increment);
            }
            increment = increment / 2;
        }
    }

    private void insertionSort (int[] arr, int startIndex, int increment) {
        for (int i = startIndex; i < arr.length - 1; i = i + increment) {
            for (int j = Math.min(i + increment, arr.length - 1); j - increment >= 0; j = j - increment) {
                if (arr[j - increment] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - increment];
                    arr[j - increment] = tmp;
                } else {
                    break;
                }
            }
        }
    }
   

}
