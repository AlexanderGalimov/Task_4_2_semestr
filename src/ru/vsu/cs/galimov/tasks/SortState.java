package ru.vsu.cs.galimov.tasks;

public class SortState {
    private final int[] arr;
    private final int tempJ;

    public SortState(int[] arr, int tempJ) {
        this.arr = arr;
        this.tempJ = tempJ;
    }

    public int[] getArr() {
        return arr;
    }

    public int getTempJ() {
        return tempJ;
    }
}

