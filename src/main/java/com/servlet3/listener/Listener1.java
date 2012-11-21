package com.servlet3.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.servlet3.service.Bid;

/**
 * Application Lifecycle Listener implementation class Listener1
 *
 */
@WebListener
public class Listener1 implements ServletContextListener {

    private static final int THREAD_TRESHOLD = 10;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("message", "Please upload a pdf");

        final Map<String, List<AsyncContext>> watchers = new ConcurrentHashMap<String, List<AsyncContext>>();
        watchers.put("alma", new ArrayList<AsyncContext>());
        servletContextEvent.getServletContext().setAttribute("watchers", watchers);

        final Queue<Bid> bids = new ConcurrentLinkedQueue<Bid>();
        servletContextEvent.getServletContext().setAttribute("bids", bids);

        final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(THREAD_TRESHOLD);
        (new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (!bids.isEmpty()) {
                        final Bid bid = bids.poll();
                        fixedThreadPool.execute(new Runnable() {

                            @Override
                            public void run() {
                                List<AsyncContext> list = watchers.get(bid.getId());
                                for (Iterator<AsyncContext> iterator = list.iterator(); iterator.hasNext();) {
                                    AsyncContext asyncContext = iterator.next();
                                    try {
                                        asyncContext.getResponse().getWriter().println(bid.getPrice());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    } catch (IllegalStateException is) {
                                        iterator.remove();
                                    }
                                }
                            }
                        });
                    }
                }
            }
        })).start();

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

}
