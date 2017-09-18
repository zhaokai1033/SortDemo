package com.zk.code.sortdemo;

import android.os.SystemClock;

/**
 * ========================================
 * Created by zhaokai on 2017/8/13.
 * Email zhaokai1033@126.com
 * des:
 * ========================================
 */

public abstract class ISort {

    abstract void startSort(ArrayModel arrayModel);

    public void swap(int A[], int i, int j, ArrayModel arrayModel) {
        if (i != j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        SystemClock.sleep(1000);
        arrayModel.addSwapTime();
        arrayModel.onSortChange();
    }
}
