<%
    Usuario usuario = new Usuario();
    if (session.getAttribute("loged") != "OK") {

        response.sendRedirect("login.jsp");
    } else {
        usuario = (Usuario) session.getAttribute("usuario");
    }
%>
<%@page import="com.emergentes.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Alias: <%=usuario.getAlias()%><br>
        ID: <%=usuario.getId()%><br>
        Nombre: <%=usuario.getNombre()%><br>
        Descripcion: <%=usuario.getDescripcion()%><br>
        Correo Electronico: <%=usuario.getCorreoElectronico()%><br>
        Fecha de Nacimiento: <%=usuario.getFechaNacimiento()%><br>
        Fecha de Registro: <%=usuario.getFechaRegistro()%><br>
        Usuario: <%=usuario.getUsuario()%><br>
        Contraseña: <%=usuario.getContrasenia()%><br>
        Estado: <%=usuario.getEstado()%><br>
        Tipo de Usuario: <%=usuario.getIdTipoUsuario()%><br>
    </body>
</html>
