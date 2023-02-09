package co.develhope.interceptorsmiddleware2.interceptors;

import co.develhope.interceptorsmiddleware2.entities.Month;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    public static List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1,"January  ","Gennaio","Janus"),
            new Month(2,"February","Febbraio","Februar"),
            new Month(3,"March","Marzo","März"),
            new Month(4,"April","Aprile","April"),
            new Month(5,"May","Maggio","Mai"),
            new Month(6,"June","Giugno","Juni")
    ));

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumber = request.getHeader("monthNumber");
        if (monthNumber == null || monthNumber.isEmpty()){
            response.setStatus(400);
            System.out.println("Bad Request");
            return false;
        }

        Month month = months.stream().filter(month1 -> month1.getMonthNumber() == Integer.parseInt(monthNumber))
                .findFirst().orElse(new Month(0,"nope","nope","nope"));

        request.setAttribute("month", month);
        return true;
    }
}
