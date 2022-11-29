package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author imironov
 * @since 29.11.2022
 */
public class MirrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String[]> pageVariablesMap = req.getParameterMap();
        String value = pageVariablesMap.get("key")[0];
        resp.getWriter().append(value);
    }
}
