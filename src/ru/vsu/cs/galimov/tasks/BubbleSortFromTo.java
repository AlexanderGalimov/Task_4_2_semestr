package ru.vsu.cs.galimov.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSortFromTo<T> {

    public static <T extends Comparable<T>> T[] sort(T[] data,int from,int to){
        if(from <= 0 || from > data.length + 1 || to > data.length + 1 || to <= 0){
            throw new IllegalArgumentException();
        }
        int count = 1;
        for (int i = from - 1; i < to; i++) {
            for (int j = from - 1; j < to - count; j++) {
                if(data[j].compareTo(data[j+1]) > 0 ){
                    T temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
            count++;
        }
        return data;
    }

    public static List<SortState> sort(int[] data,int from,int to){
        if(from <= 0 || from > data.length + 1 || to > data.length + 1 || to <= 0){
            throw new IllegalArgumentException();
        }
        int cnt = 0;
        List<SortState> srtst = new ArrayList<>();
        srtst.add(cnt, new SortState(Arrays.copyOf(data,data.length),0));
        int count = 1;
        for (int i = from - 1; i < to; i++) {
            for (int j = from - 1; j < to - count; j++) {
                cnt++;
                srtst.add(cnt, new SortState(Arrays.copyOf(data,data.length),j));
                cnt++;
                if(data[j] > (data[j+1]) ){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
                srtst.add(cnt, new SortState(Arrays.copyOf(data,data.length),j));
            }
            count++;
        }
        return srtst;
    }
}

