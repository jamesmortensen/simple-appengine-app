package com.loosebazooka.test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guest")
public class GuestbookServlet extends HttpServlet {



    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String responseText = "response sent with data = ";
        String name = (String) req.getParameter("name");
        if(name != null) {
            responseText = "POST ";

//            Key guestbookKey = KeyFactory.createKey("Guestbook", "My Guestbook");
//            String content = (String) req.getParameter("content");
//            Date date = new Date();
//            Entity greeting = new Entity("Greeting", guestbookKey);
//            greeting.setProperty("user", "James");
//            greeting.setProperty("date", date);
//            greeting.setProperty("content", content);
//
//            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//            datastore.put(greeting);





        }

        resp.setContentType("text/plain");
        resp.getWriter().println(responseText);
    }
}
