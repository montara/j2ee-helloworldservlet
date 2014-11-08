package helloworldservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/RequestDump/*")
public class RequestDumpServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        // set the content type before accessing the PrintWriter object
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\"/>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Request, as seen by the servlet</h2>");

        out.println("<dl>");
        out.println("<dt>Method</dt><dd>" + req.getMethod() + "</dd>");
        out.println("<dt>Path info</dt><dd>" + req.getPathInfo() + "</dd>");
        out.println("<dt>Translated path</dt><dd>" + req.getPathTranslated() + "</dd>");
        out.println("<dt>Context path</dt><dd>" + req.getContextPath() + "</dd>");
        out.println("<dt>Query string</dt><dd>" + req.getQueryString() + "</dd>");
        out.println("<dt>Request URI</dt><dd>" + req.getRequestURI() + "</dd>");
        out.println("<dt>Request URL</dt><dd>" + req.getRequestURL() + "</dd>");
        out.println("<dt>Servlet path</dt><dd>" + req.getServletPath() + "</dd>");
        out.println("</dl>");

        Cookie[] cookies = req.getCookies();
        out.println("<h3>" + cookies.length + " cookie(s)</h3>");
        if (cookies.length > 0) {
            out.println("<dl>");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                out.println("<dt>" + cookie.getName() + "</dt>");
                out.println("<dd>");
                out.println(cookie.getValue());
                out.println(" (domain=" + cookie.getDomain() + ", path=" + cookie.getPath() +
                        ", max age=" + cookie.getMaxAge() + ", secure=" + cookie.getSecure() +
                        ", http only=" + cookie.isHttpOnly() + ")");
                out.println("</dd>");
            }
            out.println("</dl>");
        }
        out.println("<h3>Headers</h3>");
        out.println("<dl>");
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            out.println("<dt>" + headerName + "</dt>");
            out.println("<dd>" + headerValue + "</dd>");
        }
        out.println("</dl>");
        out.println("</body>");
        out.println("</html>");
    }
}
