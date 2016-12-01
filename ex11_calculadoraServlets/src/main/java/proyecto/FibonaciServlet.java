package proyecto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rosa on 17/11/2016.
 */

@WebServlet(name = "FibonaciServlet")
public class FibonaciServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        int fibo1 = 1;
        int fibo2 = 1;
        int j = 0;

        int num = Integer.parseInt(request.getParameter("num"));

        List<Integer> fibo= new ArrayList<Integer>();
        fibo.add(fibo1);
        for (int i = 2; i <= num; i++) {
            fibo.add(fibo2);
            fibo2 = fibo1 + fibo2;
            fibo1 = fibo2 - fibo1;
        }
        request.setAttribute("fibo", fibo);
        request.getRequestDispatcher("/FibonaciResultV1.jsp").forward(request, response);

        response.setContentType("text/html;charset=UTF-8");
        String s = request.getParameter("num");
        response.getWriter().write(s);


    }
}
