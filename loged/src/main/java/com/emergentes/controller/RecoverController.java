package com.emergentes.controller;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.model.Usuario;
import com.emergentes.utils.EnvioCorreos;
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
@WebServlet(name = "RecoverController", urlPatterns = {"/RecoverController"})
public class RecoverController extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAOimpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("recover.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usuario = new Usuario();
        Usuario aux = new Usuario();
        
        String correoElectronico = request.getParameter("correoElectronico");
        System.out.println("email="+correoElectronico);
        usuario.setCorreoElectronico(correoElectronico);
        try {
            aux = dao.findUsuarioByEmail(usuario);
        } catch (Exception e) {
            System.out.println("Error en el controlador");
        }
            System.out.println("ID= "+aux.getId());
        
        if(aux.getId() != 0){
            EnvioCorreos ec = new EnvioCorreos(aux.getCorreoElectronico(), aux.getUsuario(), aux.getContrasenia());
            response.sendRedirect("recuperacion.jsp");
        }else{
            response.sendRedirect("noCorreo.jsp");
        }          
    }
}
