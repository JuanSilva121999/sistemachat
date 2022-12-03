<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : tiporeporte
    Created on : 2 dic. 2022, 9:56:46
    Author     : Display
--%>

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
    <body class="bg-light text-dark">
        <div class="p-3  bg-primary text-white">
            <h1>Lista de tipo de reportes</h1>
            <form action="AdminController" method="POST">
                <input type="hidden" name="usuario" value="${datosadmin.usuario}">
                <input type="hidden" name="password" value="${datosadmin.contraseña}">
                <input type="submit" name="name" value="Volver" class=" btn btn-outline-light">
            </form>
        </div><br><br>

        <a class=" btn btn-outline-dark "href="TipoReporteControlador?action=add&id_administrador=${datosadmin.id}">Nuevo</a>

        <table class="table table-dark table-hover shadow p-3 mb-5 bg-body rounded">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Nombre del ultimo administrador que modifico</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${tipor}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.nombre_administrador}</td>
                    <td><a class="btn btn-outline-warning"href="TipoReporteControlador?action=edit&id_administrador=${datosadmin.id}&id=${item.id}">Editar</a></td>
                    <td><a class="btn btn-outline-danger"href="TipoReporteControlador?action=delete&id=${item.id}&id_admin=${datosadmin.id}">Eliminar</a></td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
