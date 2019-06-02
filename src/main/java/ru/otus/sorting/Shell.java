package ru.otus.sorting;

public final class Shell {

    public static void sortOne(Comparable[] a) {
        int N = a.length;
        int h = 1;

        while (h < N / 3) h = 3 * h + 1;
       // while (h < N) h = 2 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
            //h = h / 2;
        }
    }

    public static void sortTwo(Comparable[] a) {
        int N = a.length;
        int h = 1;

        while (h < N / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                Comparable temp = a[i];
                int count = 0;
                for (int j = i; j >= h && less(a[i], a[j - h]); j -= h) {
                    count++;
                }
                int shift = count * h;
                if (shift != 0)
                    System.arraycopy(a, i - shift, a, i - shift + 1, shift);
                a[i - shift] = temp;
            }
            h = h / 3;
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
