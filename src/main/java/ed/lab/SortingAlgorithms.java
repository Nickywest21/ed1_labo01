package ed.lab;

import java.util.Random;

public class SortingAlgorithms {
    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSortHigh(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortHigh(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionHigh(array, low, high);
            quickSortHigh(array, low, pivotIndex - 1);
            quickSortHigh(array, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partitionHigh(T[] array, int low, int high) {
        T pivot = array[high]; // Último elemento como pivote
        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                // Asignación manual en lugar de swap
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Mover el pivote a su posición correcta
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSortLow(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortLow(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionLow(array, low, high);
            quickSortLow(array, low, pivotIndex - 1);
            quickSortLow(array, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partitionLow(T[] array, int low, int high) {
        T pivot = array[low]; // Primer elemento como pivote
        int i = low+1;

        for (int j = low + 1; j <= high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                // Intercambio manual sin usar swap
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }

        // Colocar el pivote en su posición correcta
        T temp = array[low];
        array[low] = array[i - 1];
        array[i - 1] = temp;

        return i - 1;
    }

    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSortRandom(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortRandom(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionRandom(array, low, high);

            if (pivotIndex - 1 > low) { // Asegura que haya al menos 2 elementos en la parte izquierda
                quickSortRandom(array, low, pivotIndex - 1);
            }
            if (pivotIndex + 1 < high) { // Asegura que haya al menos 2 elementos en la parte derecha
                quickSortRandom(array, pivotIndex + 1, high);
            }
        }
    }

    private static <T extends Comparable<T>> int partitionRandom(T[] array, int low, int high) {
        if (low >= high)
            return low; // Evita loops innecesarios

        Random rand = new Random();
        int pivotIndex = low + rand.nextInt(high - low + 1); // Asegura que el pivote esté en el rango válido

        // Intercambiar el pivote aleatorio con el último elemento
        T temp = array[pivotIndex];
        array[pivotIndex] = array[high];
        array[high] = temp;

        T pivot = array[high]; // Nuevo pivote en la última posición
        int i = low - 1;

        for (int j = low; j < high; j++) { // No incluir `high`, porque ahí está el pivote
            if (array[j].compareTo(pivot) < 0) {
                i++;
                // Intercambiar valores
                T tempSwap = array[i];
                array[i] = array[j];
                array[j] = tempSwap;
            }
        }

        // Colocar el pivote en su posición correcta
        array[high] = array[i + 1];
        array[i + 1] = pivot;

        return i + 1;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}