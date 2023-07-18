package dz_2;

import java.util.Arrays;

public class ArrayShift {
    public static void shiftArray(int[] array, int n) {
        int length = array.length;
        int[] shiftedArray = new int[length];

        for (int i = 0; i < length; i++) {
            int newIndex = (i + n) % length;
            shiftedArray[newIndex] = array[i];
        }

        System.arraycopy(shiftedArray, 0, array, 0, length);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int n = 2;

        System.out.println("Исходный массив: " + Arrays.toString(array));

        shiftArray(array, n);

        System.out.println("Массив после циклического сдвига на " + n + " позиций: " + Arrays.toString(array));
    }
}