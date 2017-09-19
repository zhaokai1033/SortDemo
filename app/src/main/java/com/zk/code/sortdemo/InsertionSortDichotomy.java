package com.zk.code.sortdemo;

/**
 * ========================================
 * Created by zhaokai on 2017/9/18.
 * Email zhaokai1033@126.com
 * des:
 * 二分法排序
 * ========================================
 */

public class InsertionSortDichotomy extends ISort {

    @Override
    void startSort(ArrayModel arrayModel) {
        int[] array = arrayModel.getResultArray();
        int length = array.length, left, right, mid;

        for (int i = 1; i < length; i++) {
            int temp = array[i];

            if (temp < array[i - 1]) {
                right = i - 1;
                left = 0;
                while (left <= right) {
                    mid = (right + left) / 2;
                    if (temp < array[mid]) {
                        right = mid - 1;
                    } else if (temp > array[mid]) {
                        left = mid + 1;
                    } else {
                        break;
                    }
                }

                for (int j = i; j > left; j--) {
                    array[j] = array[j - 1];
                    swap(arrayModel);
                }
                array[left] = temp;
                swap(arrayModel);
            }
        }
    }
}
