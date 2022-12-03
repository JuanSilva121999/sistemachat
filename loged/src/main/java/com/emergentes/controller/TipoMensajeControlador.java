package com.emergentes.controller;

import com.emergentes.dao.AdministradorDAO;
import com.emergentes.dao.AdministradorDAOimpl;
import com.emergentes.dao.TipoMensajeDAO;
import com.emergentes.dao.TipoMensajeDAOimpl;
import com.emergentes.model.Administrador;
import com.emergentes.model.TipoMensaje;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TipoMensajeControlador", urlPatterns = {"/TipoMensajeControlador"})
public class TipoMensajeControlador extends HttpServlet {

    TipoMensajeDAO daomensaje = new TipoMensajeDAOimpl();
    AdministradorDAO admindao = new AdministradorDAOimpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Iniciando TipoReporte....");
        try {
            int id;
            int id_administrador;
            
            List<Administrador> lista_Adminsitrador = null;
            
            TipoMensaje tm = new TipoMensaje();
            Administrador admin = new Administrador();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    id_administrador = Integer.parseInt(request.getParameter("id_administrador"));
                    Administrador ad = new Administrador();
                    ad = admindao.getById(id_administrador);
                    System.out.println("id=" + ad.getId());
                    request.setAttribute("datosadmin", ad);
                    admin = admindao.getById(id_administrador);
                    request.setAttribute("datos_admin", admin);
                    request.setAttribute("tipomensaje", tm);
                    request.getRequestDispatcher("frmtipomensaje.jsp").forward(request, response);
                    
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    id_administrador = Integer.parseInt(request.getParameter("id_administrador"));
                    Administrador admi = new Administrador();
                    admi = admindao.getById(id_administrador);
                    System.out.println("id=" + admi.getId());
                    request.setAttribute("datosadmin", admi);
                    tm = daomensaje.getById(id);
                    admin = admindao.getById(id_administrador);
                    request.setAttribute("datos_admin", admin);
                    request.setAttribute("tipomensaje", tm);
                    request.getRequestDispatcher("frmtipomensaje.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    int id_ad = Integer.parseInt(request.getParameter("id_admin"));
                    try {
                        daomensaje.delete(id);
                    } catch (Exception e) {
                        System.out.println("Error al eliminar Tipo :" + e);
                    }
                    Administrador a = new Administrador();
                    try {
                        a = admindao.getById(id_ad);
                    } catch (Exception e) {
                        System.out.println("Error del administrador");
                    }
                    response.sendRedirect("TipoMensajeControlador?id_admin=" + id_ad);
                    break;
                case "view":
                    List<TipoMensaje> lista = daomensaje.getAll();
                    id_administrador = Integer.parseInt(request.getParameter("id_admin"));
                    Administrador adm = new Administrador();
                    adm = admindao.getById(id_administrador);
                    request.setAttribute("datosadmin", adm);
                    
                    request.setAttribute("tipom", lista);
                    request.getRequestDispatcher("tipomensaje.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int id = Integer.parseInt(request.getParameter("idm"));
        String url = request.getParameter("url");
        int idad = Integer.parseInt(request.getParameter("idad"));
        TipoMensaje tm = new TipoMensaje();
        
        tm.setId(id);
        tm.setId_administrador(idad);
        tm.setNombre(nombre);
        tm.setUrl(url);
        if (id == 0) {
            try {
                daomensaje.insert(tm);
            } catch (Exception ex) {
                System.out.println("Error al insetar datos del tipo m" + ex);
            }
        } else {
            try {
                daomensaje.update(tm);
            } catch (Exception ex) {
                System.out.println("Error al modificar datos del tipo m"+ex);
            }
            
        }
        
        response.sendRedirect("TipoMensajeControlador?id_admin=" + tm.getId_administrador());
    }


}
