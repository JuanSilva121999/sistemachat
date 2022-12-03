package com.emergentes.controller;

import com.emergentes.dao.AdministradorDAO;
import com.emergentes.dao.AdministradorDAOimpl;
import com.emergentes.model.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminControlador", urlPatterns = {"/AdminControlador"})
public class AdminControlador extends HttpServlet {

    AdministradorDAO daoAdmin = new AdministradorDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Administrador admin = new Administrador();
            
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    int id_admi=Integer.parseInt(request.getParameter("id_admin"));
                    request.setAttribute("Admin", admin);
                    Administrador ad= new Administrador();
                    ad=daoAdmin.getById(id_admi);
                    request.setAttribute("dat_admin", ad);
                    request.getRequestDispatcher("frmadmin.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    int id_adm=Integer.parseInt(request.getParameter("id_admin"));
                    Administrador a= new Administrador();
                    a=daoAdmin.getById(id_adm);
                    request.setAttribute("dat_admin", a);
                    admin = daoAdmin.getById(id);
                    request.setAttribute("Admin", admin);
                    request.getRequestDispatcher("frmadmin.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    daoAdmin.delete(id);
                    response.sendRedirect("AdminControlador");
                    break;
                case "view":
                    int id_admin= Integer.parseInt(request.getParameter("id_admin"));
                    admin=daoAdmin.getById(id_admin);
                    List<Administrador> lista = daoAdmin.getAll();
                    request.setAttribute("datos_admin", admin);
                    request.setAttribute("admin", lista);
                    request.getRequestDispatcher("administradores.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_admin= Integer.parseInt(request.getParameter("id_ad"));
        String usuario = request.getParameter("usuario");
        int id = Integer.parseInt(request.getParameter("id"));
        String pass = request.getParameter("password");
        Administrador admin = new Administrador();
        admin.setUsuario(usuario);
        admin.setContraseña(pass);
        admin.setId(id);
        if (id == 0) {
            try {
                daoAdmin.insert(admin);
            } catch (Exception ex) {
                System.out.println("Error al insetar datos del admin " + ex);
            }
        }else{
            try {
                daoAdmin.update(admin);
            } catch (Exception ex) {
                System.out.println("Error al modificar datos del admin");
            }
            
        }
        
        response.sendRedirect("AdminControlador?id_admin="+id_admin);
    }

}
