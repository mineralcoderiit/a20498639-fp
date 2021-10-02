package edu.iit.sat.itmd4515.a20498639.lab4;


import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;
import java.util.logging.Logger;

@WebServlet(name = "CountryServlet", value = "/coun")
public class CountryServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(CountryServlet.class.getName());

    @Resource
    Validator validator;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("doGet request received");

        Country country = new Country();
        request.setAttribute("country", country);

        //response.sendRedirect("/a20498639-fp/coun.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/coun.jsp");
        dispatcher.forward(request, response);

    }

    private String checkStringParam(String param) {
        if (param != null && !param.isEmpty()) {
            return param;
        }

        return null;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
        LOG.info("doPost request received");
        LOG.info("Received " +
                " " + request.getParameter("countryId") +
                " " + request.getParameter("countryName"));
        String countryIdParam = request.getParameter("countryId");
        String countryNameParam = request.getParameter("countryName");
        String lastUpdateParam = request.getParameter("lastUpdate");
        Country country = new Country();
        if (checkStringParam(countryIdParam) != null) {
            country.setCountryId(Integer.valueOf(countryIdParam));
        }

        country.setCountryName(checkStringParam(countryNameParam));
        country.setLastUpdate(LocalDate.now());

        LOG.info("country.toString: " + country.toString());
        // at this point we have built our POJO/entity and we need to validate it
        Set<ConstraintViolation<Country>> violations;
        violations = validator.validate(country);

        if (violations.size() > 0) {
            // this would mean some validation failures
            for (ConstraintViolation<Country> violation : violations) {
                LOG.info(violation.toString());
            }

            request.setAttribute("country", country);
            request.setAttribute("violations", violations);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/coun.jsp");
            dispatcher.forward(request, response);


        } else {
            // there are no validation failures, therefore set the validated pojo as a request attribute
            request.setAttribute("country", country);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/conf.jsp");
            dispatcher.forward(request, response);

        }


    }
}

