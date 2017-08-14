package com.zk.code.sortdemo;

/**
 * ========================================
 * Created by zhaokai on 2017/8/13.
 * Email zhaokai1033@126.com
 * des:
 * 选择排序
 * 不稳定排序 有相同元素时可能导致相对顺序错乱
 * 选取最值 进行交换
 * ========================================
 */

public class SelectionSort extends ISort {

    @Override
    void startSort(ArrayModel arrayModel) {
        int[] array = arrayModel.getResultArray();
        int length = array.length;
        int min;
        for (int i = 0; i < length; i++) {
            min = i;
            for (int j = i + 1; j < length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(array, i, min, arrayModel);
            }
        }
    }
}
