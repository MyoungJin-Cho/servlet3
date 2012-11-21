package com.servlet3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servlet1", urlPatterns = {"/servlet1"}, asyncSupported = true)
public class Servlet1 extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 5162427223216629224L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().println("Running on port: " + request.getLocalPort());
            response.getWriter().println("Language: " + request.getLocale());
            request.getRequestDispatcher("/servlet2").include(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
