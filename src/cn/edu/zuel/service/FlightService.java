package cn.edu.zuel.service;

import cn.edu.zuel.dao.FlightDao;
import cn.edu.zuel.entity.FlightEntity;


import java.util.ArrayList;

public class FlightService {
    private FlightDao flightDao=new FlightDao();
    public ArrayList<FlightEntity> allFlight(){
        return flightDao.allFlight();
    }
    public int delFlight(Integer id){return flightDao.delFlight(id);}
    public FlightEntity queryById(Integer id){return flightDao.queryById(id);}
    public int updateFlight(FlightEntity flightEntity){return flightDao.updateFlight(flightEntity);}
    public int insertFlight(FlightEntity flightEntity){return flightDao.insertFlight(flightEntity);}
    public int updateDelete(Integer id){return flightDao.updateDelete(id);}
}
