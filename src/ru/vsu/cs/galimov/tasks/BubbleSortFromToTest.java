package ru.vsu.cs.galimov.tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortFromToTest {

    @Test
    public void test1() {
        Integer[] data = {9,4,6,3,2,1,4,1};
        Integer[] dataCheck = {1,1,2,3,4,4,6,9};
        assertArrayEquals(BubbleSortFromTo.sort(data,1, data.length),dataCheck);
    }

    @Test
    public void test2() {
        Character[] data = {'d','a','b','a','c','m'};
        Character[] dataCheck = {'a','a','b','c','d','m'};
        assertArrayEquals(BubbleSortFromTo.sort(data,1, data.length),dataCheck);
    }

    @Test
    public void test3() {
        Character[] data = {'d','a','b','a','c','m'};
        Character[] dataCheck = {'d','a','a','b','c','m'};
        assertArrayEquals(BubbleSortFromTo.sort(data,3, 5),dataCheck);
    }

    @Test
    public void test4() {
        Double[] data = {9.8,4.3,6.3,1.3,5.8};
        Double[] dataCheck = {9.8,1.3,4.3,5.8,6.3};
        assertArrayEquals(BubbleSortFromTo.sort(data,2, data.length),dataCheck);
    }

    @Test
    public void test5() {
        String[] data = {"abcd","dhwwg","abc"};
        String[] dataCheck = {"abcd","abc","dhwwg"};
        assertArrayEquals(BubbleSortFromTo.sort(data,2, data.length),dataCheck);
    }

    @Test
    public void test6() {
        Integer[] data = {3,4,2,7,6,2,1,5,3};
        Integer[] dataCheck = {2,3,4,6,7,2,1,5,3};
        assertArrayEquals(BubbleSortFromTo.sort(data,1, 5),dataCheck);
    }

    @Test
    public void test7() {
        Integer[] data = {9,8,7,6,5,4,4,2,1};
        Integer[] dataCheck = {8,9,7,6,5,4,4,2,1};
        assertArrayEquals(BubbleSortFromTo.sort(data,1, 2),dataCheck);
    }

    @Test
    public void test8() {
        Integer[] data = {9,8,7,6,5,4,4,2,1,1};
        Integer[] dataCheck = {1,2,4,4,5,6,7,8,9,1};
        assertArrayEquals(BubbleSortFromTo.sort(data,1, data.length - 1),dataCheck);
    }

    @Test
    public void test9() {
        Integer[] data = {-1,-4,2,7,-6};
        Integer[] dataCheck = {-6,-4,-1,2,7};
        assertArrayEquals(BubbleSortFromTo.sort(data,1, data.length),dataCheck);
    }

}