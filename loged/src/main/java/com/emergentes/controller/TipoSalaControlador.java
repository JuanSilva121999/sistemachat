package com.emergentes.controller;

import com.emergentes.dao.AdministradorDAO;
import com.emergentes.dao.AdministradorDAOimpl;
import com.emergentes.dao.TipoSalaDAO;
import com.emergentes.dao.TipoSalaDAOimpl;
import com.emergentes.model.Administrador;
import com.emergentes.model.TipoMensaje;
import com.emergentes.model.TipoSala;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TipoSalaControlador", urlPatterns = {"/TipoSalaControlador"})
public class TipoSalaControlador extends HttpServlet {

    AdministradorDAO admindao = new AdministradorDAOimpl();
    TipoSalaDAO tsdao = new TipoSalaDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Iniciando TipoReporte....");
        try {
            int id;
            int id_administrador;

            List<Administrador> lista_Adminsitrador = null;

            TipoSala ts = new TipoSala();
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
                    request.setAttribute("tiposala", ts);
                    request.getRequestDispatcher("frmtiposala.jsp").forward(request, response);

                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    id_administrador = Integer.parseInt(request.getParameter("id_administrador"));
                    Administrador admi = new Administrador();
                    admi = admindao.getById(id_administrador);
                    System.out.println("id=" + admi.getId());
                    request.setAttribute("datosadmin", admi);
                    ts = tsdao.getById(id);
                    System.out.println("Dato del sala tipo" + ts.getNombre());
                    admin = admindao.getById(id_administrador);
                    request.setAttribute("datos_admin", admin);
                    request.setAttribute("tiposala", ts);
                    request.getRequestDispatcher("frmtiposala.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    int id_ad = Integer.parseInt(request.getParameter("id_admin"));
                    try {
                        tsdao.delete(id);
                    } catch (Exception e) {
                        System.out.println("Error al eliminar tipoSAla :" + e);
                    }
                    Administrador a = new Administrador();
                    try {
                        a = admindao.getById(id_ad);
                    } catch (Exception e) {
                        System.out.println("Error del administrador");
                    }
                    response.sendRedirect("TipoSalaControlador?id_admin=" + id_ad);
                    break;
                case "view":
                    List<TipoSala> lista = tsdao.getAll();
                    id_administrador = Integer.parseInt(request.getParameter("id_admin"));
                    Administrador adm = new Administrador();
                    adm = admindao.getById(id_administrador);
                    request.setAttribute("datosadmin", adm);

                    request.setAttribute("tiposala", lista);
                    request.getRequestDispatcher("tiposala.jsp").forward(request, response);
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
        TipoSala ts = new TipoSala();

        ts.setId(id);
        ts.setId_administrador(idad);
        ts.setNombre(nombre);
        ts.setDescripcion(descripcion);
        if (id == 0) {
            try {
                tsdao.insert(ts);
            } catch (Exception ex) {
                System.out.println("Error al insetar datos del tipo " + ex);
            }
        } else {
            try {
                tsdao.update(ts);
            } catch (Exception ex) {
                System.out.println("Error al modificar datos del tipo");
            }

        }

        response.sendRedirect("TipoSalaControlador?id_admin=" + ts.getId_administrador());
    }
}


