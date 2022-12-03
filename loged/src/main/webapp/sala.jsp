<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <body class="p-3 mb-2 bg-light text-dark">
          <div class="modal-dialog">
    <div class="modal-content shadow p-3 mb-5 bg-body rounded">
      <div class="modal-header p-3 mb-2 bg-info text-dark">
        <h5 class="modal-title ">Bienvenido <%=usuario.getAlias()%> a Sistema de Mensajeria </h5>
        
      </div>
      <div class="modal-body p-3 mb-2 bg-light text-dark">
        <p>Sistema de Mensajeria LAKEA.KA </p>
        <p>Tu nombre es <%=usuario.getNombre()%></p>
      </div>
      <div class="modal-footer">
          <a class="btn btn-outline-primary" role="button" href="SalaControlador?action=view&id=<%=usuario.getId()%>"> Ver contactos</a><br>
        <a class="btn btn-outline-secondary" role="button" href="SalaControlador?action=add&id=<%=usuario.getId()%>"> Nueva Sala</a><br>
        <a class="btn btn-outline-danger" role="button" href="login.jsp">Salir</a>
      </div>
    </div>
  </div>
        
    </body>
</html>
