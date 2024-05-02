package cn.edu.zuel.servlet;

import cn.edu.zuel.entity.FlightEntity;
import cn.edu.zuel.service.FlightService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showAllFlight")
public class FlightServlet extends HttpServlet {
    private FlightService flightService=new FlightService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ArrayList<FlightEntity> arrayList =flightService.allFlight();
            req.setAttribute("allFlight",arrayList);
            req.getRequestDispatcher("flight.jsp").forward(req,resp);
    }
}
