package com.zk.code.sortdemo;

/**
 * ========================================
 * Created by zhaokai on 2017/8/13.
 * Email zhaokai1033@126.com
 * des:
 * 思想：将无序字段插入一排序字段的合适位置
 * ========================================
 */

public class InsertionSort extends ISort {

    @Override
    void startSort(ArrayModel arrayModel) {

        int[] array = arrayModel.getResultArray();
        int length = array.length;
        for (int i = 1; i < length; i++) {

            //从最小开始比较
            for (int j = 0; j < i; j++) {
                //找到分界值
                if (array[j] > array[i]) {
                    //记录要插入的值
                    int temp = array[i];
                    //后移大于插入值的单位
                    for (int k = i; k > j; k--) {
                        //后一个等于前一个
//                        array[k] = array[k - 1];
                        //方便显示 调用统一的交换方法
                        swap(array, k, k - 1, arrayModel);
                    }
                    //插入当前值
//                    array[j] = temp;
                    break;
                }
            }
        }
    }
}
