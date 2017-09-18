package com.zk.code.sortdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static HashMap<String, ISort> iSorts = new HashMap<>();

    static {
        iSorts.clear();
        iSorts.put("冒泡排序", new BubbleSort());
        iSorts.put("鸡尾酒排序", new CocktailSort());
        iSorts.put("选择排序", new SelectionSort());
        iSorts.put("插入排序", new InsertionSort());
        iSorts.put("希尔排序", new ShellSort());
    }

    private TextView content;
    private TextView result;
    private ArrayModel array;
    private TextView detail;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = ((TextView) findViewById(R.id.content));
        result = ((TextView) findViewById(R.id.result));
        detail = ((TextView) findViewById(R.id.result_detail));
        group = ((RadioGroup) findViewById(R.id.group));
        for (String key : iSorts.keySet()) {
            RadioButton bt = new RadioButton(this);
            bt.setText(key);
            bt.setTextSize(20);
            group.addView(bt);
        }
        ((RadioButton) group.getChildAt(0)).setChecked(true);
        initClick();
        array = new ArrayModel() {

            @Override
            public void onChangeRefresh(String s, String r) {
                content.setText(s);
                result.setText(r);
            }

            @Override
            public void onSortFinish(int time, long duration) {
                detail.setText("次数：" + time + " 耗时：" + (duration) + "mill");
            }
        };
    }

    private void initClick() {
        findViewById(R.id.bt_random).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                array.createSource(10);
            }
        });

        findViewById(R.id.bt_sort).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                array.setSortModel(getISort());
                array.sort();
            }
        });
    }

    /**
     * 根据排序方法选择 排序算法
     */
    private ISort getISort() {
        String index;
        int id = group.getCheckedRadioButtonId();
        index = ((RadioButton) findViewById(id)).getText().toString();
        return iSorts.get(index);
    }
}
