package cn.edu.zuel.dao;

import cn.edu.zuel.entity.FlightEntity;
import cn.edu.zuel.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;
public class FlightDao {
    public ArrayList<FlightEntity> allFlight(){//查询所有航班信息
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet resultSet=null;
        try{
            conn=JdbcUtil.getConnection();

            String selectSql="select *from flight where is_delete=0";
            stat=conn.prepareStatement(selectSql);//使用预编译参数防止sql注入
            resultSet=stat.executeQuery();
            ArrayList<FlightEntity> arrayList=new ArrayList<>();
            while(resultSet.next()){
               Integer id=resultSet.getInt("id");
               String flightId=resultSet.getString("flight_id");
               String company=resultSet.getString("company");
               String departureAirport=resultSet.getString("departure_airport");
               String arriveAirport=resultSet.getString("arrive_Airport");
               Date departureTime=resultSet.getDate("departure_time");
               Date arriveTime=resultSet.getDate("arrive_time");
               String model=resultSet.getString("model");
               Integer isDelete=resultSet.getInt("is_delete");
               arrayList.add(new FlightEntity(id,flightId,company,departureAirport,arriveAirport,departureTime,arriveTime,model,isDelete));
            }
            return arrayList;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }finally{

            JdbcUtil.closeConnection(resultSet,stat,conn);
        }
    }
    public int delFlight(Integer id){//删除航班信息
        Connection conn=null;
        PreparedStatement stat=null;
        try{
            conn=JdbcUtil.getConnection();
            JdbcUtil.beginTransaction(conn);
            String delSql="delete from flight where id=?";
            stat=conn.prepareStatement(delSql);
            stat.setInt(1,id);
            int i = stat.executeUpdate();
            JdbcUtil.commit(conn);
            return i;
        }catch (Exception e){
            e.printStackTrace();
            JdbcUtil.rollbackTransaction(conn);
            return 0;
        }finally {
            JdbcUtil.closeConnection(stat,conn);
        }
    }
    public FlightEntity queryById(Integer id){//根据id查询航班信息
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet resultSet=null;
        try{
            conn=JdbcUtil.getConnection();
            String querySql="select *from flight where id=?";
            stat=conn.prepareStatement(querySql);
            stat.setInt(1,id);
            resultSet=stat.executeQuery();
            if(resultSet.next()){
                String flightId=resultSet.getString("flight_id");
                String company=resultSet.getString("company");
                String departureAirport=resultSet.getString("departure_airport");
                String arriveAirport=resultSet.getString("arrive_Airport");
                Date departureTime=resultSet.getDate("departure_time");
                Date arriveTime=resultSet.getDate("arrive_time");
                String model=resultSet.getString("model");
                Integer isDelete=resultSet.getInt("is_delete");
                FlightEntity flightEntity = new FlightEntity(id,flightId,company,departureAirport,arriveAirport,departureTime,arriveTime,model,isDelete);
                return flightEntity;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            JdbcUtil.closeConnection(resultSet,stat,conn);
        }
    }
    public int updateFlight(FlightEntity flightEntity){//更新航班信息
        Connection conn=null;
        PreparedStatement stat=null;
        try{
            conn=JdbcUtil.getConnection();
            JdbcUtil.beginTransaction(conn);//涉及到修改数据，需要使用事务
            String updateSql="update flight set flight_id=?,company=?,departure_airport=?,arrive_Airport=?,departure_time=?," +
                    "arrive_time=?,model=?,is_delete=0 where id=?";
            stat=conn.prepareStatement(updateSql);
            stat.setString(1, flightEntity.getFlightId());
            stat.setString(2, flightEntity.getCompany());
            stat.setString(3, flightEntity.getDepartureAirport());
            stat.setString(4, flightEntity.getArriveAirport());
            /*
            * 将java.util.Date转换为java.sql.Date*/
            stat.setDate(5,new Date(flightEntity.getDepartureTime().getTime()+ 8 * 60 * 60 * 1000));//加8小时才是北京时间
            stat.setDate(6,new Date(flightEntity.getArriveTime().getTime()+ 8 * 60 * 60 * 1000));
            stat.setString(7, flightEntity.getModel());
            stat.setInt(8,flightEntity.getId());
            int result=stat.executeUpdate();
            JdbcUtil.commit(conn);
            if(result!=0){
                return result;
            }else{
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
            JdbcUtil.rollbackTransaction(conn);
            return 0;
        }finally {
            JdbcUtil.closeConnection(stat,conn);
        }
    }
    public int insertFlight(FlightEntity flightEntity){//插入航班信息
        Connection conn=null;
        PreparedStatement stat=null;
        try{
            conn=JdbcUtil.getConnection();
            JdbcUtil.beginTransaction(conn);
            String insertSql="insert into flight values(null,?,?,?,?,?,?,?,0)";
            stat=conn.prepareStatement(insertSql);
            stat.setString(1,flightEntity.getFlightId());
            stat.setString(2,flightEntity.getCompany());
            stat.setString(3,flightEntity.getDepartureAirport());
            stat.setString(4, flightEntity.getArriveAirport());
            stat.setDate(5,new Date(flightEntity.getDepartureTime().getTime()+ 8 * 60 * 60 * 1000));
            stat.setDate(6,new Date(flightEntity.getArriveTime().getTime()+ 8 * 60 * 60 * 1000));
            stat.setString(7,flightEntity.getModel());
//            stat.setInt(8,flightEntity.getIsDelete());
            int result = stat.executeUpdate();
            JdbcUtil.commit(conn);
            if(result>0){
                return result;
            }
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            JdbcUtil.rollbackTransaction(conn);
            return 0;
        }finally {
            JdbcUtil.closeConnection(stat,conn);
        }
    }
    public int updateDelete(Integer id){//逻辑删除
        Connection conn=null;
        PreparedStatement stat=null;
        try{
            conn=JdbcUtil.getConnection();
            JdbcUtil.beginTransaction(conn);//涉及到修改数据，需要使用事务
            String updateSql="update flight set is_delete=? where id=?";
            stat=conn.prepareStatement(updateSql);
            stat.setInt(1, 1);
            stat.setInt(2, id);

            int result=stat.executeUpdate();
            JdbcUtil.commit(conn);
            if(result!=0){
                return result;
            }else{
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
            JdbcUtil.rollbackTransaction(conn);
            return 0;
        }finally {
            JdbcUtil.closeConnection(stat,conn);
        }
    }
}
