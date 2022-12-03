package com.emergentes.controller;

import com.emergentes.dao.AdministradorDAO;
import com.emergentes.dao.AdministradorDAOimpl;
import com.emergentes.dao.TipoReporteDAO;
import com.emergentes.dao.TipoReporteDAOimpl;
import com.emergentes.model.Administrador;
import com.emergentes.model.TipoReporte;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TipoReporteControlador", urlPatterns = {"/TipoReporteControlador"})
public class TipoReporteControlador extends HttpServlet {

    TipoReporteDAO trdao = new TipoReporteDAOimpl();
    AdministradorDAO admindao = new AdministradorDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Iniciando TipoReporte....");
        try {
            int id;
            int id_administrador;

            List<Administrador> lista_Adminsitrador = null;

            TipoReporte tr = new TipoReporte();
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
                    request.setAttribute("tipoReporte", tr);
                    request.getRequestDispatcher("frmtiporeporte.jsp").forward(request, response);

                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    id_administrador = Integer.parseInt(request.getParameter("id_administrador"));
                    Administrador admi = new Administrador();
                    admi = admindao.getById(id_administrador);
                    System.out.println("id=" + admi.getId());
                    request.setAttribute("datosadmin", admi);
                    tr = trdao.getById(id);
                    admin = admindao.getById(id_administrador);
                    request.setAttribute("datos_admin", admin);
                    request.setAttribute("tipoReporte", tr);
                    request.getRequestDispatcher("frmtiporeporte.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    int id_ad=Integer.parseInt(request.getParameter("id_admin"));
                    try {
                        trdao.delete(id);
                    } catch (Exception e) {
                        System.out.println("Error al eliminar Tipo :" + e);
                    }
                    Administrador a= new Administrador();
                    try {
                        a=admindao.getById(id_ad);
                    } catch (Exception e) {
                        System.out.println("Error del administrador");
                    }
                    response.sendRedirect("TipoReporteControlador?id_admin="+tr.getId_administrador());
                    break;
                case "view":
                    List<TipoReporte> lista = trdao.getAll();
                    id_administrador = Integer.parseInt(request.getParameter("id_admin"));
                    Administrador adm = new Administrador();
                    adm = admindao.getById(id_administrador);
                    request.setAttribute("datosadmin", adm);

                    request.setAttribute("tipor", lista);
                    request.getRequestDispatcher("tiporeporte.jsp").forward(request, response);
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
        int id = Integer.parseInt(request.getParameter("idr"));
        String descripcion = request.getParameter("descripcion");
        int idad = Integer.parseInt(request.getParameter("idad"));
        TipoReporte tr=new TipoReporte();
        
        tr.setId(id);
        tr.setId_administrador(idad);
        tr.setNombre(nombre);
        tr.setDescripcion(descripcion);
        if (id == 0) {
            try {
                trdao.insert(tr);
            } catch (Exception ex) {
                System.out.println("Error al insetar datos del tipo " + ex);
            }
        } else {
            try {
                trdao.update(tr);
            } catch (Exception ex) {
                System.out.println("Error al modificar datos del tipo");
            }

        }

        response.sendRedirect("TipoReporteControlador?id_admin="+tr.getId_administrador());
    }
}


