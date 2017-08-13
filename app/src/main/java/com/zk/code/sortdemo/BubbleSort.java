package com.zk.code.sortdemo;

/**
 * ========================================
 * Created by zhaokai on 2017/8/13.
 * Email zhaokai1033@126.com
 * des:
 * 冒泡排序
 * ========================================
 */

public class BubbleSort extends ISort {

    @Override
    void startSort(ArrayModel arrayModel) {
        int[] array = arrayModel.getResultArray();
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            int num = size - 1 - i;
            for (int j = 0; j < num; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    arrayModel.addSwapTime();
                    arrayModel.onSortChange();
                }
            }
        }
    }

}
