package com.emergentes.controller;

import com.emergentes.dao.SalaDAO;
import com.emergentes.dao.SalaDAOimpl;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.dao.UsuarioSalaDAO;
import com.emergentes.dao.UsuarioSalaDAOimpl;
import com.emergentes.model.Sala;
import com.emergentes.model.Usuario;
import com.emergentes.model.UsuarioSala;
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

@WebServlet(name = "SalaControlador", urlPatterns = {"/SalaControlador"})
public class SalaControlador extends HttpServlet {

    UsuarioSalaDAO dao = new UsuarioSalaDAOimpl();
    UsuarioDAO daou = new UsuarioDAOimpl();
    SalaDAO daosala = new SalaDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioSala us = new UsuarioSala();
        Usuario usuario = new Usuario();
        Sala sala = new Sala();

        List<Sala> listaSala = null;
        int id_usuario = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action") != null ? request.getParameter("action") : "view";
        System.out.println("id " + id_usuario);
        System.out.println("action " + action);

        switch (action) {
            case "view":

                List<UsuarioSala> lista = new ArrayList<UsuarioSala>();
                try {
                    lista = dao.getSalaPrivada(id_usuario);

                } catch (Exception ex) {
                    System.out.println("Error al listaaaar " + ex.getMessage());
                }

                try {
                    us = dao.getById(id_usuario);

                } catch (Exception e) {
                    System.out.println("Error al buscarrr " + e.getMessage());
                }

                try {
                    usuario = daou.getById(id_usuario);
                } catch (Exception e) {
                    System.out.println("Error en los datos del usuario");
                }
                System.out.println("id= " + usuario.getId());
                System.out.println("nombre = " + usuario.getUsuario());
                System.out.println("Salio bien");
                request.setAttribute("info", usuario);
                request.setAttribute("datos", us);
                request.setAttribute("salas", lista);
                request.getRequestDispatcher("salas.jsp").forward(request, response);
                break;
            case "add":
            
                try {
                listaSala = daosala.getAll();
            } catch (Exception ex) {
                System.out.println("Error al obterner los datos de salas controlador");;
            }
            try {
                us = dao.getById(id_usuario);
            } catch (Exception e) {
                System.out.println("Error al entrar " + e.getMessage());
            }
            try {
                usuario=daou.getById(id_usuario);
            } catch (Exception e) {
                System.out.println("Error en los datos del usuaruio");
            }
            request.setAttribute("info", usuario);
            request.setAttribute("datos", us);
            request.setAttribute("salas", listaSala);
            request.getRequestDispatcher("frm_salaU.jsp").forward(request, response);

            break;

            case "delete":
                int id;
                id = Integer.parseInt(request.getParameter("id_Us_Sa"));
                int id_us = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar desde controlador");
                }

                response.sendRedirect("SalaControlador?id=" + id_us);
                break;

            default:
                throw new AssertionError();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_usuario = Integer.parseInt(request.getParameter("id"));
        int id_sala = Integer.parseInt(request.getParameter("sala"));
        UsuarioSala us = new UsuarioSala();
        us.setId_usuario(id_usuario);
        us.setId_sala(id_sala);

        UsuarioSalaDAO daous = new UsuarioSalaDAOimpl();
        try {
            daous.insert(us);
        } catch (Exception e) {
            System.out.println("Error desde controlador para insertar datos");
        }
        response.sendRedirect("SalaControlador?id=" + id_usuario);
    }

}
