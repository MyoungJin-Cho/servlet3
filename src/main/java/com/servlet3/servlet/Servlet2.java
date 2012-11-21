package com.servlet3.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet(name = "Servlet2", urlPatterns = "/servlet2")
public class Servlet2 extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 3812941682605624821L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("date") == null) {
            response.getWriter().println("Current time is: " + new Date());
        } else {
            response.getWriter().println("Servlet has been invoked at: " + request.getParameter("date"));
        }
    }

}
