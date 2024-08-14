package org.example.customermanagement;

import java.io.*;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.customermanagement.DTO.CustomerDTO;

@WebServlet(name = "helloServlet", value = "/customer")
public class CustomerContoller extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (!request.getContentType().toLowerCase().endsWith("application/json") || request.getContentType() == null) {
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
        }
        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO dto = jsonb.fromJson(request.getReader(), CustomerDTO.class);
        System.out.println(dto.toString());

    }

    public void destroy() {
    }
}