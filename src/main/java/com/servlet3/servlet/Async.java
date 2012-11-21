package com.servlet3.servlet;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet3.service.AsyncWebService;

/**
 * Servlet implementation class Async
 */
@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class Async extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -9026624326973755592L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //An IllegalStateException will be thrown if an application tries to start an asynchronous operation
        //and there is a servlet or servlet filter in the request processing chain that does not support asynchronous processing.
        AsyncContext asyncContext = request.startAsync(request, response);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        fixedThreadPool.execute(new AsyncWebService(asyncContext));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
