package cn.edu.zuel.test;

import cn.edu.zuel.dao.FlightDao;
import cn.edu.zuel.entity.FlightEntity;


import java.util.Date;


public class Test01 {
    public static void main(String[] args) {
        FlightDao dao = new FlightDao();
        int i = dao.updateFlight(new FlightEntity(4, "MYK003", "中国东方航空公司", "武汉天河机场", "武汉天河机场", new Date(), new Date(), "735", 0));
        System.out.println(i);
    }
}
