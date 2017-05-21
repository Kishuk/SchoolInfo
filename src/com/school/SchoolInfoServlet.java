package com.school;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SchoolInfoServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    resp.setContentType("text/plain");
    RequestDispatcher view = req.getRequestDispatcher("/proto.html");
    // don't add your web-app name to the path

    view.forward(req, resp);
  }
}
