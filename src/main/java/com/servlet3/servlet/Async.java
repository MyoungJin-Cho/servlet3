package com.servlet3.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet3.service.Bid;

/**
 * Servlet implementation class Async
 */
@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class Async extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -9026624326973755592L;

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //An IllegalStateException will be thrown if an application tries to start an asynchronous operation
        //and there is a servlet or servlet filter in the request processing chain that does not support asynchronous processing.
        AsyncContext asyncContext = request.startAsync(request, response);
        ServletContext servletContext = request.getServletContext();
        Map<String, List<AsyncContext>> map = (Map<String, List<AsyncContext>>) servletContext.getAttribute("watchers");
        List<AsyncContext> watchers = (List<AsyncContext>) map.get("alma");
        watchers.add(asyncContext);
    }

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        Queue<Bid> aucBids = (Queue<Bid>) servletContext.getAttribute("bids");
        Bid bid = new Bid(new BigDecimal(request.getParameter("price")));
        aucBids.add(bid);
    }

}
