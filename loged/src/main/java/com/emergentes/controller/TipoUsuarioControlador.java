package com.emergentes.controller;

import com.emergentes.dao.AdministradorDAO;
import com.emergentes.dao.AdministradorDAOimpl;
import com.emergentes.dao.TipoUsuarioDAO;
import com.emergentes.dao.TipoUsuarioDAOimpl;
import com.emergentes.model.Administrador;
import com.emergentes.model.TipoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TipoUsuarioControlador", urlPatterns = {"/TipoUsuarioControlador"})
public class TipoUsuarioControlador extends HttpServlet {

    TipoUsuarioDAO tusdao = new TipoUsuarioDAOimpl();
    AdministradorDAO admindao = new AdministradorDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Iniciando TipoReporte....");
        try {
            int id;
            int id_administrador;

            List<Administrador> lista_Adminsitrador = null;

            TipoUsuario tus = new TipoUsuario();
            Administrador admin = new Administrador();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    id_administrador = Integer.parseInt(request.getParameter("id_administrador"));
                    TipoUsuario tu = new TipoUsuario();
                    tu.TipoUsuarioVacio();
                    Administrador ad = new Administrador();
                    ad = admindao.getById(id_administrador);
                    System.out.println("id=" + ad.getId());
                    request.setAttribute("datosadmin", ad);
                    admin = admindao.getById(id_administrador);
                    request.setAttribute("datos_admin", admin);
                    System.out.println("nombre: " + tu.getNombre());
                    request.setAttribute("tipousuario", tu);
                    request.getRequestDispatcher("frmtipousuario.jsp").forward(request, response);

                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    id_administrador = Integer.parseInt(request.getParameter("id_administrador"));
                    Administrador admi = new Administrador();
                    admi = admindao.getById(id_administrador);
                    System.out.println("id=" + admi.getId());
                    request.setAttribute("datosadmin", admi);
                    tus = tusdao.getById(id);
                    admin = admindao.getById(id_administrador);
                    request.setAttribute("datos_admin", admin);
                    request.setAttribute("tipousuario", tus);
                    request.getRequestDispatcher("frmtipousuario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    int id_ad = Integer.parseInt(request.getParameter("id_admin"));
                    try {
                        tusdao.delete(id);
                    } catch (Exception e) {
                        System.out.println("Error al eliminar Tipo :" + e);
                    }
                    Administrador a = new Administrador();
                    try {
                        a = admindao.getById(id_ad);
                    } catch (Exception e) {
                        System.out.println("Error del administrador");
                    }
                    response.sendRedirect("TipoUsuarioControlador?id_admin=" + id_ad);
                    break;
                case "view":
                    List<TipoUsuario> lista = tusdao.getAll();
                    id_administrador = Integer.parseInt(request.getParameter("id_admin"));
                    Administrador adm = new Administrador();
                    adm = admindao.getById(id_administrador);
                    request.setAttribute("datosadmin", adm);

                    request.setAttribute("tipous", lista);
                    request.getRequestDispatcher("tipousuario.jsp").forward(request, response);
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
        int id = Integer.parseInt(request.getParameter("idus"));
        String descripcion = request.getParameter("descripcion");
        int idad = Integer.parseInt(request.getParameter("idad"));
        TipoUsuario tus = new TipoUsuario();

        tus.setId(id);
        tus.setNombre(nombre);
        tus.setDescripcion(descripcion);
        if (id == 0) {
            try {
                tusdao.insert(tus);
            } catch (Exception ex) {
                System.out.println("Error al insetar datos del tipo " + ex);
            }
        } else {
            try {
                tusdao.update(tus);
            } catch (Exception ex) {
                System.out.println("Error al modificar datos del tipo");
            }

        }

        response.sendRedirect("TipoUsuarioControlador?id_admin=" + idad);
    }
}
