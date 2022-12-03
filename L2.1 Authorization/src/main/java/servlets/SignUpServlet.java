package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author imironov
 * @since 03.12.2022
 */
public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    //sign up
    public void doPost(HttpServletRequest request,
        HttpServletResponse response) throws IOException
    {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        response.setContentType("text/html;charset=utf-8");

        if (login == null || pass == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UserProfile profile = new UserProfile(login);
        accountService.addNewUser(profile);
        response.getWriter().println("success");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
