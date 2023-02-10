package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;




public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (request.getParameter("logout") != null) {
            session.invalidate();
            request.setAttribute("message", "You have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);

            
        } else if(session.getAttribute("homeusername")!=null){
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").
                forward(request, response);
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").
                forward(request, response);
        }


        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        
     
        
        if(username != null && password != null){
            AccountService as = new AccountService();
            User user = as.login(username,password);
            if (user != null){
                session.setAttribute("homeusername", username);
                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").
                    forward(request, response);
            } else {
                request.setAttribute("message", "Invalid login.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").
                    forward(request, response);
            }
        } else {
            request.setAttribute("message", "Invalid login.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").
                forward(request, response);
        }

    }
}
