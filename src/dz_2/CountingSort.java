package dz_2;

public class CountingSort {
    public static void countingSort(int[] arr) {
        int n = arr.length;

        // Находим максимальное и минимальное значения в массиве
        int max = arr[0], min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];

        // Считаем количество каждого элемента в массиве
        for (int i = 0; i < n; i++)
            count[arr[i] - min]++;

        // Вычисляем префиксные суммы
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];

        // Располагаем элементы в правильном порядке в выходном массиве
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Копируем отсортированный массив обратно в исходный массив
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);

        System.out.println("Отсортированный массив:");
        for (int num : arr)
            System.out.print(num + " ");
    }
}
