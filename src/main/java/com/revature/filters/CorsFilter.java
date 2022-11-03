package com.revature.filters;

import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter
@Component
public class CorsFilter extends HttpFilter {
    @Override
    public void init() throws ServletException {
        System.out.println("[LOG] - CustomFilter initialized at " + LocalDateTime.now());
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
//        System.out.println("[LOG] - CorsFilter intercepted web request at " + LocalDateTime.now());
        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
//        resp.addHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(req, resp);
    }
}
