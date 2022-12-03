package com.emergentes.controller;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.model.TipoUsuario;
import com.emergentes.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("signup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        int id = 0;
        String alias = request.getParameter("alias");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String correoElectronico = request.getParameter("correoElectronico");

        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String usuarioo = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");

        usuario.setId(id);
        usuario.setAlias(alias);
        usuario.setNombre(nombre);
        usuario.setDescripcion(descripcion);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setFechaRegistro(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        usuario.setFechaNacimiento(LocalDate.parse(fechaNacimiento));
        usuario.setUsuario(usuarioo);
        usuario.setContrasenia(contrasenia);
        usuario.setEstado("Activo");
        usuario.setIdTipoUsuario(new TipoUsuario());

        try {
            dao.insertUsuario(usuario);
            
            Usuario aux = new Usuario();
            aux = dao.verificarRegistro(usuario);

            if(aux.getId() != 0){
                HttpSession session = request.getSession();
                session.setAttribute("usuario", aux);
                session.setAttribute("loged", "OK");
                request.getRequestDispatcher("sala.jsp").forward(request, response);
            }else{
                response.sendRedirect("signup.jsp");
            }

        } catch (Exception ex) {
            System.out.println("Error al insertar wachin" + ex.getMessage());
        }
    }
}
