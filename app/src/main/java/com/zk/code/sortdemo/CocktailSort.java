package com.zk.code.sortdemo;

/**
 * ========================================
 * Created by zhaokai on 2017/8/13.
 * Email zhaokai1033@126.com
 * des:
 * 鸡尾酒排序 由冒泡排序改进
 * 单向->双向
 * ========================================
 */

public class CocktailSort extends ISort {

    @Override
    void startSort(ArrayModel arrayModel) {

        int[] array = arrayModel.getResultArray();
        int length = array.length;
        int size = (length + 1) / 2;
        for (int i = 0; i < size; i++) {

            for (int j = i; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1, arrayModel);
                }
            }
            for (int j = length - i - 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1, arrayModel);
                }
            }
        }
    }
}
