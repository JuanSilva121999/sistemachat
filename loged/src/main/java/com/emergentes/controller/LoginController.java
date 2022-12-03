package com.emergentes.controller;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.model.Usuario;
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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuarioObj = new Usuario();

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        usuarioObj.setUsuario(usuario);
        usuarioObj.setContrasenia(password);

        Usuario usu = new Usuario();

        usu = dao.findRegistro(usuarioObj);

        if (usu.getId() == 0 || usu.getEstado().equals("Baneado")) {
            if (usu.getId() == 0) {
                response.sendRedirect("login.jsp");
            }
            if (usu.getEstado().equals("Baneado")) {
                response.sendRedirect("baneado.jsp");
            }

        } else {
            HttpSession session = request.getSession();
            session.setAttribute("loged", "OK");
            session.setAttribute("usuario", usu);
            request.getRequestDispatcher("sala.jsp").forward(request, response);
        }
    }
}
