package com.srw.provider.controller;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/11/11/17:45
 */
public class Test {
    /**
     *  计算 集合中 DeptId 和 Type 相同的数据的num总和
     */
    public static void main(String[] args) {
        List<DataBean> totalStocks = new ArrayList<>();

        DataBean stock1 = new DataBean();
        stock1.setDeptId(2);
        stock1.setType(2);
        stock1.setNum(2);
        totalStocks.add(stock1);

        DataBean stock2 = new DataBean();
        stock2.setDeptId(2);
        stock2.setType(2);
        stock2.setNum(3);
        totalStocks.add(stock2);

        DataBean stock3 = new DataBean();
        stock3.setDeptId(3);
        stock3.setType(3);
        stock3.setNum(5);
        totalStocks.add(stock3);

        DataBean stock4 = new DataBean();
        stock4.setDeptId(3);
        stock4.setType(3);
        stock4.setNum(4);
        totalStocks.add(stock4);

        DataBean stock5 = new DataBean();
        stock5.setDeptId(4);
        stock5.setType(4);
        stock5.setNum(10);
        totalStocks.add(stock5);

        List<DataBean> result = totalStocks.stream()
                //group
                .collect(Collectors.groupingBy(e -> e.getDeptId() + ":" + e.getType()))
                // 分组后的list做reduce
                .values().stream().map(list -> list.stream().reduce(Test::combine).get())
                // 收集到list
                .collect(Collectors.toList());

        System.out.println(result);


    }

    private static DataBean combine(DataBean e1, DataBean e2){
        DataBean e = new DataBean();

        e.setDeptId(e1.getDeptId());
        e.setType(e1.getType());
        e.setNum(e1.getNum() + e2.getNum());

        return e;
    }


}

@Data
class DataBean {

    private int type;

    private int deptId;

    private int num;
}
