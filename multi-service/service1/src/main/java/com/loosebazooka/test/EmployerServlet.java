package com.loosebazooka.test;

import com.sample.EmployeeJDO;
import com.sample.EmployeeServlet;
import com.sample.PMF;

import javax.jdo.PersistenceManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/employer")
public class EmployerServlet extends EmployeeServlet {


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String responseText = "response sent with data = ";
        String name = (String) req.getParameter("name");
        if(name != null) {
            responseText = "POST ";

            PersistenceManager pm = PMF.get().getPersistenceManager();

            EmployeeJDO e = new EmployeeJDO("James", "Mortensen", new Date());

            try {
                pm.makePersistent(e);
            } finally {
                pm.close();
            }



        }

        resp.setContentType("text/plain");
        resp.getWriter().println(responseText);
    }
}
