package cn.edu.zuel.entity;

import java.util.Date;

public class FlightEntity {
    /*id
    * */
    private Integer id;
    /*
    * 航班号*/
    private String flightId;
    /*
    * 航空公司*/
    private String company;
    /*
    * 出发机场*/
    private String departureAirport;
    /*
    * 到达机场*/
    private String arriveAirport;
    /*
    * 出发时间*/
    private Date departureTime;
    /*
    * 到达时间*/
    private Date arriveTime;
    /*
    * 机型*/
    private String model;
    /*
    * 是否隐藏  0：显示  1：隐藏*/
    private Integer isDelete;

    public FlightEntity(Integer id, String flightId, String company, String departureAirport, String arriveAirport, Date departureTime, Date arriveTime, String model, Integer isDelete) {
        this.id = id;
        this.flightId = flightId;
        this.company = company;
        this.departureAirport = departureAirport;
        this.arriveAirport = arriveAirport;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.model = model;
        this.isDelete = isDelete;
    }

    public FlightEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArriveAirport() {
        return arriveAirport;
    }

    public void setArriveAirport(String arriveAirport) {
        this.arriveAirport = arriveAirport;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
