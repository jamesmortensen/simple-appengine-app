package com.loosebazooka.test;

import com.google.appengine.api.datastore.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Date;
import java.util.List;

//@WebServlet("/guest")
public class GuestReaderServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String responseText = "response sent with data = ";


        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Key guestbookKey = KeyFactory.createKey("Guestbook", "My Guestbook");
        // Run an ancestor query to ensure we see the most up-to-date
        // view of the Greetings belonging to the selected Guestbook.
        Query query = new Query("Greeting", guestbookKey).addSort("date", Query.SortDirection.DESCENDING);
        List<Entity> greetings = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(5));
        if (greetings.isEmpty()) {

        } else {
            for (Entity greeting : greetings) {
                String name = (String) greeting.getProperty("name");
                String content = (String) greeting.getProperty("content");
                responseText += name + " : " + content;
            }
        }
        resp.setContentType("text/plain");
        resp.getWriter().println(responseText);
    }
}

