package com.loosebazooka.test;

import java.io.IOException;
import javax.servlet.http.*;

//import com.sample.*;

public class MyServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        String content = "this is the test servlet from service 2 using web.xml";
        //HelloWorld helloWorld = new HelloWorld();
        //content += "\n From JDO-service: " + helloWorld.getHelloWorld();
        resp.getWriter().println(content);
    }
}
