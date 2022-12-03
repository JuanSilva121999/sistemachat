package com.emergentes.controller;

import com.emergentes.dao.ReporteDAO;
import com.emergentes.dao.ReporteDAOimpl;
import com.emergentes.dao.TipoReporteDAO;
import com.emergentes.dao.TipoReporteDAOimpl;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.dao.UsuarioSalaDAO;
import com.emergentes.dao.UsuarioSalaDAOimpl;
import com.emergentes.model.Reporte;
import com.emergentes.model.TipoReporte;
import com.emergentes.model.Usuario;
import com.emergentes.model.UsuarioSala;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReporteControlador", urlPatterns = {"/ReporteControlador"})
public class ReporteControlador extends HttpServlet {

    ReporteDAO dao = new ReporteDAOimpl();
    UsuarioDAO daou = new UsuarioDAOimpl();
    TipoReporteDAO daotr = new TipoReporteDAOimpl();
    UsuarioSalaDAO daous=new UsuarioSalaDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<TipoReporte> lista = null;
        Usuario u = new Usuario();
        Usuario usuario = new Usuario();
        int id = Integer.parseInt(request.getParameter("id_us_rep"));
        int id_usuario= Integer.parseInt(request.getParameter("id_usuario"));
        int id_sala=Integer.parseInt(request.getParameter("id_sala"));
        try {
            lista = daotr.getAll();
        } catch (Exception ex) {
            System.out.println("Error al obterner los datos de reportes controlador");;
        }
        try {
            u = daou.getById(id);
        } catch (Exception e) {
            System.out.println("Error al entrar " + e.getMessage());
        }
        UsuarioSala us=new UsuarioSala();
        try {
            us = daous.getById(id_usuario);
        } catch (Exception e) {
            System.out.println("Error al entrar " + e.getMessage());
        }
        
        try {
            lista = daotr.getAll();
        } catch (Exception ex) {
            System.out.println("Error al obterner los datos de reportes controlador");;
        }
        try {
            usuario=daou.getById(id_usuario);
        } catch (Exception e) {
        }
        request.setAttribute("ususal", us);
        request.setAttribute("info", usuario);
        request.setAttribute("datos", u);
        request.setAttribute("reportes", lista);
        request.getRequestDispatcher("frm_reporte.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_usuario_reportado = Integer.parseInt(request.getParameter("id"));
        int id_reporte = Integer.parseInt(request.getParameter("reporte"));
        
        int id_usuario=Integer.parseInt(request.getParameter("id_usuario"));
        int id_sala=Integer.parseInt(request.getParameter("id_sala"));
        Reporte r = new Reporte();
        r.setId_usuario(id_usuario_reportado);
        r.setId_reporte(id_reporte);

        ReporteDAO re=new ReporteDAOimpl();
        try {
            re.insert(r);
        } catch (Exception e) {
            System.out.println("Error desde controlador para insertar datos");
        }
        response.sendRedirect("MensajeControlador?id_usuario="+id_usuario+"&id_sala="+id_sala);
    }

}
