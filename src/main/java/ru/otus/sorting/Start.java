package ru.otus.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Start {

    private static int N = 1_000_000;

    public static void main(String[] args) {
        List<Integer> integerArrayList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < N; i++) {
            integerArrayList.add(rand.nextInt());
        }
        Collections.shuffle(integerArrayList);
        Integer[] mas = integerArrayList.toArray(new Integer[0]);

        long start = System.currentTimeMillis();
        Shell.sortOne(mas);
        System.out.println("Full shuffle " + (System.currentTimeMillis() - start) + " ms; For " + N + " length");

        int n = N / 100 * 10;
        for (int i = 0; i < n; i++) {
            shuffle(mas, rand);
        }

        start = System.currentTimeMillis();
        Shell.sortOne(mas);
        System.out.println("10% shuffle " + (System.currentTimeMillis() - start + " ms; For " + N + " length"));

        for (int i = 0; i < 5; i++) {
            shuffle(mas, rand);
        }
        start = System.currentTimeMillis();
        Shell.sortOne(mas);
        System.out.println("5 items shuffle " + (System.currentTimeMillis() - start + " ms; For " + N + " length"));
    }

    private static void shuffle(Integer[] mas, Random rand) {
        int indexOne = rand.nextInt(N);
        int indexTwo = rand.nextInt(N);

        Integer a = mas[indexOne];
        mas[indexOne] = mas[indexTwo];
        mas[indexTwo] = a;
    }
}
