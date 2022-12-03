package com.emergentes.controller;

import com.emergentes.dao.MensajeDAO;
import com.emergentes.dao.MensajeDAOimpl;
import com.emergentes.dao.SalaDAO;
import com.emergentes.dao.SalaDAOimpl;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.model.Mensaje;
import com.emergentes.model.Sala;
import com.emergentes.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MensajeControlador", urlPatterns = {"/MensajeControlador"})
public class MensajeControlador extends HttpServlet {

    MensajeDAO dao = new MensajeDAOimpl();
    UsuarioDAO daou = new UsuarioDAOimpl();
    SalaDAO daos = new SalaDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Mensaje mensaje = new Mensaje();
        Sala sala = new Sala();
        Usuario usuario = new Usuario();

        List<Mensaje> listamensaje = null;
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_sala = Integer.parseInt(request.getParameter("id_sala"));
        String action = request.getParameter("action") != null ? request.getParameter("action") : "view";
        System.out.println("Id usuario " + id_usuario);
        System.out.println("Id sala " + id_sala);
        switch (action) {
            case "view":
                listamensaje = new ArrayList<Mensaje>();
                try {
                    listamensaje = dao.mensajesSala(id_sala);
                } catch (Exception e) {
                    System.out.println("Error al obtener los mensajes controlador");
                }
                try {
                    sala = daos.getById(id_sala);
                } catch (Exception e) {
                    System.out.println("Error al obtener los datos de la sala controlador");
                }
                try {
                    usuario = daou.getById(id_usuario);
                } catch (Exception e) {
                    System.out.println("Error al obtener los datos del usuario");
                }
                System.out.println("Salio bien");
                request.setAttribute("info", usuario);
                request.setAttribute("sala", sala);
                request.setAttribute("mensajes", listamensaje);
                request.getRequestDispatcher("mensajes.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
        ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensaje = request.getParameter("mensaje");
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_sala = Integer.parseInt(request.getParameter("id_sala"));
        Mensaje men = new Mensaje();
        men.setAsunto(mensaje);
        men.setId_usuario(id_usuario);
        men.setId_sala(id_sala);
        men.setEstado("activo");
        men.setId_tipo_mensaje(1);

        MensajeDAO mendao = new MensajeDAOimpl();
        try {
            mendao.insert(men);
        } catch (Exception e) {
            System.out.println("Error a insertar mensaje desde controlador");
        }
        response.sendRedirect("MensajeControlador?id_usuario=" + id_usuario + "&id_sala="+id_sala);
    }

}
