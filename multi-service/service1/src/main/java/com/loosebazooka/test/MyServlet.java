package com.loosebazooka.test;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sample.*;



@WebServlet("/test")
public class MyServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/plain");
    String content = "this is the test servlet from service 1 using 3.1 annotations";
    //HelloWorld helloWorld = new HelloWorld();
    //content += "\n From JDO-service: " + helloWorld.getHelloWorld();
    resp.getWriter().println(content);
  }
}
