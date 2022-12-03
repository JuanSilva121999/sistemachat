package com.emergentes.controller;

import com.emergentes.dao.*;
import com.emergentes.model.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CJ
 */
@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {

    AdministradorDAO dao = new AdministradorDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("logadmin.jsp");
                Administrador administrador = new Administrador();

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        administrador.setUsuario(usuario);
        administrador.setContraseña(password);

        Administrador admin = new Administrador();

        admin = dao.findRegistro(administrador);

        if (admin.getId() == 0) {
            response.sendRedirect("logadmin.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("logedAdmin", "OK");
            session.setAttribute("admin", admin);
            request.getRequestDispatcher("exitoadmin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Administrador administrador = new Administrador();

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        administrador.setUsuario(usuario);
        administrador.setContraseña(password);

        Administrador admin = new Administrador();

        admin = dao.findRegistro(administrador);

        if (admin.getId() == 0) {
            response.sendRedirect("logadmin.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("logedAdmin", "OK");
            session.setAttribute("admin", admin);
            request.getRequestDispatcher("exitoadmin.jsp").forward(request, response);
        }
    }

}
