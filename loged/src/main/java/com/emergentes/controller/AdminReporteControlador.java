package com.emergentes.controller;

import com.emergentes.dao.AdministradorDAO;
import com.emergentes.dao.AdministradorDAOimpl;
import com.emergentes.dao.ReporteDAO;
import com.emergentes.dao.ReporteDAOimpl;
import com.emergentes.dao.TipoReporteDAO;
import com.emergentes.dao.TipoReporteDAOimpl;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.model.Reporte;
import com.emergentes.model.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "AdminReporteControlador", urlPatterns = {"/AdminReporteControlador"})
public class AdminReporteControlador extends HttpServlet {
    ReporteDAO dao=new ReporteDAOimpl();
    TipoReporteDAO daor= new TipoReporteDAOimpl();
    UsuarioDAO daou=new UsuarioDAOimpl();
    AdministradorDAO daoad=new AdministradorDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Reporte reporte = new Reporte();
            int  id_administrador;
            int id;
            String action =(request.getParameter("action")!= null)? request.getParameter("action"):"view";
            switch (action) {
                case "add":
                    
                    request.setAttribute("reporte", reporte);
                    request.getRequestDispatcher("frmreporte.jsp").forward(request, response);
                    break;
                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    reporte=dao.getById(id);
                    request.setAttribute("reporte", reporte);
                    request.getRequestDispatcher("frmreporte.jsp").forward(request, response);
                    break;
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("AdminReporteControlador");
                    break;
                case "view":
                    Administrador admin= new Administrador();
                    id_administrador=Integer.parseInt(request.getParameter("id_admin"));
                    admin=daoad.getById(id_administrador);
                    
                    List<Reporte> lista = dao.getAll();
                    request.setAttribute("datosadmin", admin);
                    request.setAttribute("reporte", lista);
                    request.getRequestDispatcher("listareportes.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
