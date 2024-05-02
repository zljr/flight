package cn.edu.zuel.servlet;

import cn.edu.zuel.entity.FlightEntity;
import cn.edu.zuel.service.FlightService;
import cn.edu.zuel.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/updateFlight")
public class UpdateFlightServlet extends HttpServlet {
    private FlightService flightService=new FlightService();
    /*
    * doGet回显：用户点击删除这条数据需要先查询到这条数据*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String idStr = req.getParameter("id");
        if(idStr==null||idStr==""){
            req.setAttribute("errorMsg","id的值为空！");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
        try{
            Integer id=Integer.parseInt(idStr);
            FlightEntity flightEntity = flightService.queryById(id);
            if(flightEntity==null){
                req.setAttribute("errorMsg","找不到该条航班信息");
                req.getRequestDispatcher("error.jsp").forward(req,resp);
                return;
            }
            req.setAttribute("oneFlight",flightEntity);
            req.getRequestDispatcher("update.jsp").forward(req,resp);

        }catch (NumberFormatException e){
            e.printStackTrace();
            req.setAttribute("errorMsg","数据格式转换失败！");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("errorMsg","系统错误！");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//这里很重要，一定要设置，不然会乱码，导致数据库里的表的数据也乱码
        resp.setContentType("text/html;charset=utf-8");
        String idStr = req.getParameter("id");
        if(StringUtils.isEmpty(idStr)){
            req.setAttribute("errorMsg","id为空");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
        Integer id=Integer.parseInt(idStr);//转为Integer类型
        String flightId = req.getParameter("flightId");
        if(StringUtils.isEmpty(flightId)){
            req.setAttribute("errorMsg","flightId为空");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
        String company = req.getParameter("company");
        if(StringUtils.isEmpty(company)){
            req.setAttribute("errorMsg","company为空");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
        String departureAirport = req.getParameter("departureAirport");
        if(StringUtils.isEmpty(departureAirport)){
            req.setAttribute("errorMsg","departureAirport为空");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
        String arriveAirport = req.getParameter("arriveAirport");
        if(StringUtils.isEmpty(arriveAirport)){
            req.setAttribute("errorMsg","arriveAirport为空");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
//        这里就要转化格式
        String departureTimeStr = req.getParameter("departureTime");
        if(StringUtils.isEmpty(departureTimeStr)){
            req.setAttribute("errorMsg","departureTime为空");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
        Date departureTime = DateUtils.parseDate(departureTimeStr);
        String arriveTimeStr = req.getParameter("arriveTime");
        if(StringUtils.isEmpty(arriveTimeStr)){
            req.setAttribute("errorMsg","arriveTime为空");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
        Date arriveTime = DateUtils.parseDate(arriveTimeStr);
        String model = req.getParameter("model");
        if(StringUtils.isEmpty(model)){
            req.setAttribute("errorMsg","model为空");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setId(id);
        flightEntity.setFlightId(flightId);
        flightEntity.setCompany(company);
        flightEntity.setDepartureAirport(departureAirport);
        flightEntity.setArriveAirport(arriveAirport);
        flightEntity.setDepartureTime(departureTime);
        flightEntity.setArriveTime(arriveTime);
        flightEntity.setModel(model);
        int result = flightService.updateFlight(flightEntity);
        if(result<=0){
            req.setAttribute("errorMsg","系统异常");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
        resp.sendRedirect("showAllFlight");

    }
}
