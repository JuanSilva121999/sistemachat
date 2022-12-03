package com.emergentes.controller;

import com.emergentes.dao.AdministradorDAO;
import com.emergentes.dao.AdministradorDAOimpl;
import com.emergentes.dao.SalaDAO;
import com.emergentes.dao.SalaDAOimpl;
import com.emergentes.dao.TipoSalaDAO;
import com.emergentes.dao.TipoSalaDAOimpl;
import com.emergentes.model.Administrador;
import com.emergentes.model.Sala;
import com.emergentes.model.TipoSala;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminSalaControlador", urlPatterns = {"/AdminSalaControlador"})
public class AdminSalaControlador extends HttpServlet {

    SalaDAO saladao = new SalaDAOimpl();
    AdministradorDAO admindao = new AdministradorDAOimpl();
    TipoSalaDAO tsaladao = new TipoSalaDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id;
            int id_administrador;

            List<Sala> lista = null;
            List<TipoSala> lista_tsala = null;
            TipoSala ts = new TipoSala();
            Administrador admin = new Administrador();
            Sala sala = new Sala();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    int id_admi = Integer.parseInt(request.getParameter("id_admin"));
                    request.setAttribute("admin", admin);
                    Administrador ad = new Administrador();

                    lista_tsala = tsaladao.getAll();
                    ad = admindao.getById(id_admi);
                    request.setAttribute("tiposala", lista_tsala);
                    request.setAttribute("dat_admin", ad);
                    request.setAttribute("sala", sala);
                    request.getRequestDispatcher("frmsala.jsp").forward(request, response);
                    break;
                case "edit":

                    id = Integer.parseInt(request.getParameter("id_sala"));
                    id_administrador = Integer.parseInt(request.getParameter("id_admin"));
                    request.setAttribute("admin", admin);
                    admin = admindao.getById(id_administrador);
                    lista_tsala = tsaladao.getAll();
                    sala = saladao.getById(id);
                    request.setAttribute("tiposala", lista_tsala);
                    request.setAttribute("sala", sala);
                    request.setAttribute("dat_admin", admin);
                    request.getRequestDispatcher("frmsala.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    int id_ad = Integer.parseInt(request.getParameter("id_admin"));
                    try {
                        saladao.delete(id);
                    } catch (Exception e) {
                        System.out.println("Error al eliminar Tipo :" + e);
                    }
                    Administrador a = new Administrador();
                    try {
                        a = admindao.getById(id_ad);
                    } catch (Exception e) {
                        System.out.println("Error del administrador");
                    }
                    response.sendRedirect("AdminSalaControlador?id_admin=" + id_ad);
                    break;

                case "view":
                    List<Sala> lista_sala = saladao.getAll();
                    id_administrador = Integer.parseInt(request.getParameter("id_admin"));
                    System.out.println("nombre admin " + id_administrador);
                    Administrador adm = new Administrador();
                    adm = admindao.getById(id_administrador);

                    request.setAttribute("datosadmin", adm);

                    request.setAttribute("salas", lista_sala);
                    request.getRequestDispatcher("listarsalas.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error salaassss " + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_admin = Integer.parseInt(request.getParameter("idad"));
        String nombre = request.getParameter("nombre");
        String estado = request.getParameter("estado");
        int tipo_sala = Integer.parseInt(request.getParameter("id_tipo_sala"));
        Sala sala = new Sala();
        sala.setId(id);
        sala.setNombre(nombre);
        sala.setId_avatar(1);
        sala.setEstado(estado);
        sala.setId_sala(tipo_sala);
        if (id == 0) {
            try {
                saladao.insert(sala);
            } catch (Exception e) {
                System.out.println("Error al insertar saladesdeelcontrolador " + e);
            }
        } else {
            try {
                saladao.update(sala);
            } catch (Exception ex) {
                System.out.println("Erroralmodificardesdeelcontrolador" + ex);
            }
        }
        response.sendRedirect("AdminSalaControlador?id_admin=" + id_admin);
    }

}
