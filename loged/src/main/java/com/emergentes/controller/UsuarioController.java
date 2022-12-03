package com.emergentes.controller;

import com.emergentes.dao.AdministradorDAO;
import com.emergentes.dao.AdministradorDAOimpl;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.model.Administrador;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.model.Usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author CJ
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAOimpl();
    AdministradorDAO daoad= new AdministradorDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Usuario usuario = new Usuario();
        int id;
        int idadmin=Integer.parseInt(request.getParameter("id_admin"));
        String action = request.getParameter("action") != null ? request.getParameter("action") : "view";

        switch (action) {
            case "add":
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                break;
            case "edit":
                
                id = Integer.parseInt(request.getParameter("id"));
                usuario.setId(id);
                try {
                    usuario = dao.findUsuarioById(usuario);
                } catch (Exception e) {
                    System.out.println("Error al obtener el registro" + e.getMessage());
                }
                
                System.out.println(usuario.toString());
                try {
                    System.out.println("usuario :estador= "+usuario.getId());
                    dao.updateUsuario(usuario);
                    System.out.println("usuario :estador= "+usuario.getId());
                } catch (Exception e) {
                    System.out.println("Error para editar");
                }
                
                response.sendRedirect("UsuarioController?id_admin="+idadmin);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                usuario.setId(id);
                try {
                    usuario = dao.findUsuarioById(usuario);
                } catch (Exception e) {
                    System.out.println("Error al obtener el registro" + e.getMessage());
                }
                
                System.out.println(usuario.toString());
                try {
                    System.out.println("usuario :estador= "+usuario.getId());
                    dao.updatedesUsuario(usuario);
                    System.out.println("usuario :estador= "+usuario.getId());
                } catch (Exception e) {
                    System.out.println("Error para editar");
                }
                
                response.sendRedirect("UsuarioController?id_admin="+idadmin);
                break;

            case "view":
                
                Administrador admin=new Administrador();
                List<Usuario> lista = new ArrayList<Usuario>();
                try {
                    lista = dao.findAllUsuarios();
                } catch (Exception ex) {
                    System.out.println("Error al listaaaar " + ex.getMessage());
                }
                try {
                    admin= daoad.getById(idadmin);
                } catch (Exception e) {
                    System.out.println("Error en los datos del Administrador");
                }
                System.out.println("Salio bien");
                request.setAttribute("datosadmin", admin);
                request.setAttribute("usuarios", lista);
                request.getRequestDispatcher("ListarUsuarios.jsp").forward(request, response);
                break;
                default:
                break;
        }
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

        try {
            dao.insertUsuario(usuario);
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("funciona.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Error al insertar " + ex.getMessage());
        }

        response.sendRedirect("UsuarioController");

    }
}
