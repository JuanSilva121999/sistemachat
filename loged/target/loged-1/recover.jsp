<%-- 
    Document   : recover
    Created on : 28 nov. 2022, 15:15:56
    Author     : CJ
--%>
<%
    if (session.getAttribute("noCorreo") == "OK") {

    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <div class="modal-header">
                    <h5 class="modal-title">Recuperación de Usuario y Contraseña</h5>
                </div>
                <div class="modal-body">
                    <form action="RecoverController" method="post">
                        <label class="form-label">Ingrese su correo electronico</label>
                        <input class="form-control" type="email" name="correoElectronico">
                        <div id="emailHelp" class="form-text">Se enviara los datos al correo registrado si este es valido.</div>
                        <input type="submit" value="Submit"class="btn btn-primary">
                    </form>
                </div>
                <div class="modal-footer">
                    <a class="btn btn-outline-dark"href="login.jsp">Salir</a>
                </div>
            </div>
        </div>
    </body>
</html>
