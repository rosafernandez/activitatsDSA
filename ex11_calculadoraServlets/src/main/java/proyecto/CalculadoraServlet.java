package proyecto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rosa on 17/11/2016.
 */

@WebServlet(name = "CalculadoraServlet")
public class CalculadoraServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        float operando1= Float.parseFloat(request.getParameter("operando1"));
        float operando2= Float.parseFloat(request.getParameter("operando2"));
        String operacion=request.getParameter("operacion");
        double sol = 0;

        if("SUMA".equals(operacion)){
            sol=operando1+operando2;
        }
        if("RESTA".equals(operacion)){
            sol=operando1-operando2;
        }
        if("MULTIPLICACION".equals(operacion)){
            sol=operando1*operando2;
        }
        if("DIVISION".equals(operacion)){
            sol=operando1/operando2;
        }
        request.setAttribute("RESULT",sol);
        request.getRequestDispatcher("/CalculatorResultV1.jsp").forward(request,response);
    }
}
