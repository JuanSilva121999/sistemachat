<%@page import="java.util.List"%>
<%@page import="com.emergentes.model.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Usuario> usuarios = (List<Usuario>)request.getAttribute("usuarios"); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Listado de Usuarios</title>
    </head>
    <body>
        <div class="p-3  bg-primary text-white">
            <h1>Usuarios</h1>
            <form action="AdminController" method="POST">
            <input type="hidden" name="usuario" value="${datosadmin.usuario}">
            <input type="hidden" name="password" value="${datosadmin.contraseña}">
            <input type="submit" name="name" value="Volver"class=" btn btn-outline-light">
        </form>
        </div><br><br>
        
        
        <table class="table table-dark table-hover shadow p-3 mb-5 bg-body rounded">
            <tr>
                <th>Id</th>
                <th>Alias</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Correo Electronico</th>
                <th>Fecha de Registro</th>
                <th>Fecha de Nacimiento</th>
                <th>Usuario</th>
                <th>Contraseña</th>
                <th>Estado</th>
                <th></th>
                <th></th>
            </tr>

            <c:forEach var="item" items="${usuarios}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.alias}</td>
                    <td>${item.nombre}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.correoElectronico}</td>
                    <td>${item.fechaRegistro}</td>
                    <td>${item.fechaNacimiento}</td>
                    <td>${item.usuario}</td>
                    <td>${item.contrasenia}</td>
                    <td>${item.estado}</td>
                    <td> <a class="btn btn-outline-danger"href="UsuarioController?action=edit&id=${item.id}&id_admin=${datosadmin.id}">Banear</a> </td>
                    <td> <a class="btn btn-outline-success"href="UsuarioController?action=delete&id=${item.id}&id_admin=${datosadmin.id}">Desbanear</a> </td>                   
                </tr>
            </c:forEach>
        </table>
    </body>
</html>