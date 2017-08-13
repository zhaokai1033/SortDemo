package com.zk.code.sortdemo;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * ========================================
 * Created by zhaokai on 2017/8/13.
 * Email zhaokai1033@126.com
 * des:
 * ========================================
 */

public abstract class ArrayModel {

    private static Handler handler = new Handler(Looper.getMainLooper());
    private int[] sourceArray;
    private int[] resultArray;
    private Random random = new Random();
    private ISort mSort;
    private int time;
    private long mStartTime;
    private long duration;

    public abstract void onChangeRefresh(String source, String result);

    public abstract void onSortFinish(int time, long duration);

    public void createSource(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        sourceArray = new int[size];
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(arrayList.size());
            sourceArray[i] = arrayList.get(index);
            arrayList.remove(index);
        }
        resultArray = Arrays.copyOf(sourceArray, sourceArray.length);
        onChangeRefresh(getString(sourceArray), getString(resultArray));
    }

    private String getString(int[] resultArray) {
        return Arrays.toString(resultArray);
    }

    public void sort() {
        resultArray = Arrays.copyOf(sourceArray, sourceArray.length);
        onChangeRefresh(getString(sourceArray), getString(sourceArray));
        time = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                mStartTime = System.currentTimeMillis();
                mSort.startSort(ArrayModel.this);
                duration = System.currentTimeMillis() - mStartTime;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onSortFinish(time, duration);
                    }
                });
            }
        }).start();
    }

    public int[] getResultArray() {
        return resultArray;
    }

    public void setSortModel(ISort iSort) {
        this.mSort = iSort;
    }

    public void onSortChange() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                onChangeRefresh(getString(sourceArray), getString(resultArray));
            }
        });
    }

    public void addSwapTime() {
        ++time;
    }
}
