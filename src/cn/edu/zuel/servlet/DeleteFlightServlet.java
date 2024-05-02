package cn.edu.zuel.servlet;

import cn.edu.zuel.service.FlightService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delFlight")
public class DeleteFlightServlet extends HttpServlet {
    private FlightService flightService=new FlightService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr=req.getParameter("id");//传过来的是String类型
        if(idStr==null||idStr==""){
//            跳转到错误页面
            req.setAttribute("errorMsg","id的值为空！");
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
        try{
            Integer id=Integer.parseInt(idStr);//强转成Integer类型
            int result = flightService.updateDelete(id);
            if(result>0){//删除成功，跳转至航班展示页面（重定向）
                resp.sendRedirect("showAllFlight");
            }else{
                req.setAttribute("errorMsg","很遗憾，删除失败！");
                req.getRequestDispatcher("error.jsp").forward(req,resp);
            }
        }catch (NumberFormatException e){
            e.printStackTrace();
            req.setAttribute("errorMsg","类型转换异常");
            req.getRequestDispatcher("error.jsp").forward(req,resp);

        }catch (Exception e){
            req.setAttribute("errorMsg","系统异常");
            req.getRequestDispatcher("error.jsp").forward(req,resp);

        }

    }
}
