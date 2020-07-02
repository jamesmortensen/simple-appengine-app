package com.sample;

import javax.jdo.PersistenceManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/employee")
public class EmployeeServlet  extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String responseText = "response sent with data = ";
        String name = (String) req.getParameter("name");
        if(name != null) {
            responseText = "POST ";

            PersistenceManager pm = PMF.get().getPersistenceManager();

            EmployeeJDO e = new EmployeeJDO("Navya", "Bharathi", new Date());

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
