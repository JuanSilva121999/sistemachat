<%
    Administrador administrador = new Administrador();
    if (session.getAttribute("logedAdmin") != "OK") {

        response.sendRedirect("logadmin.jsp");
    } else {
        administrador = (Administrador) session.getAttribute("admin");
    }
%>
<%@page import="com.emergentes.model.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Pagina principal Admin</title>
    </head>
    <body style="background: #D0EBF4;">
        <div class="modal-dialog ">
            <div class="modal-content shadow p-3 mb-5 bg-body rounded">
                <div class="modal-header p-2 mb-3 bg-info text-dark">
                    <h3 class="modal-title ">Hola Admin</h3>
                </div>
                <div class="modal-body" style="align-items: center">
                    <p>Ingresaste con el usuario <%=administrador.getUsuario()%> </p>
                    <div  class="btn-group-vertical" role="group" >
                        <a class="btn btn-outline-success"href="AdminControlador?id_admin=<%=administrador.getId()%>">Listar Administradores</a>
                        <a class="btn btn-outline-success"href="AdminReporteControlador?id_admin=<%=administrador.getId()%>">Listar Reportes</a>
                        <a class="btn btn-outline-success"href="TipoReporteControlador?id_admin=<%=administrador.getId()%>">Listar los tipos de reportes</a>
                        <a class="btn btn-outline-success"href="AdminSalaControlador?id_admin=<%=administrador.getId()%>">Listar salas</a>
                        <a class="btn btn-outline-success"href="TipoMensajeControlador?id_admin=<%=administrador.getId()%>">Listar los tipos de mensajes</a>
                        <a class="btn btn-outline-success"href="TipoSalaControlador?id_admin=<%=administrador.getId()%>">Listar los tipos de salas</a>
                        <a class="btn btn-outline-success"href="TipoUsuarioControlador?id_admin=<%=administrador.getId()%>">Listar los tipos de usuarios</a>
                        <a class="btn btn-outline-success"href="UsuarioController?id_admin=<%=administrador.getId()%>">Listar los usuarios</a>
                    </div>
                </div>
                <div class="modal-footer">
                    <a class="btn btn-outline-primary"href="login.jsp">Salir</a>
                </div>
            </div>
        </div>

    </body>

</html>