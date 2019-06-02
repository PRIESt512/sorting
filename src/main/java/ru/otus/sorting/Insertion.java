package ru.otus.sorting;

/**
 * Сортировка вставками
 */
public final class Insertion {

    private Insertion() {
    }

    /**
     * Классический алгоритм сортировки вставками
     *
     * @param a сортируемый массив
     */
    public static void sortOne(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    /**
     * Оптимизированный алгоритм - сдвиг бОльших элементов на одну позицию, без выполнения
     * перестановок (при этом количество обращений к массиву уменьшается вдвое)
     *
     * @param a сортируемый массив
     */
    public static void sortTwo(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable temp = a[i];
            int count = 0;
            for (int j = i - 1; j >= 0 && less(a[i], a[j]); j--) {
                count++;
            }
            System.arraycopy(a, i - count, a, i - count + 1, count);
            a[i - count] = temp;
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
