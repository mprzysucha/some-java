package com.michalprzysucha.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Michal Przysucha
 * @since 2015-04-02
 */

public class BeansServlet extends HttpServlet {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        StringBuilder sb = new StringBuilder();
        for (String beanDefinitionName : beanDefinitionNames) {
            sb.append(beanDefinitionName).append("\n");
        }
        resp.getWriter().print(sb.toString());
    }

    @Override
    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

}
