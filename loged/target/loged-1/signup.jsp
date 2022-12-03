<%-- 
    Document   : signup
    Created on : 24 nov. 2022, 23:16:26
    Author     : CJ
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Formulario Usuario</title>
    </head>
    <body class="p-3 mb-2 bg-light text-dark">
        <a href="login.jsp" class="btn btn-danger">Atras</a>
        <form action="SignUpController" method="post">
            <div class="modal-dialog">
                <div class="modal-content shadow p-3 mb-5 bg-body rounded">
                    <div class="modal-header">
                        <h5 class="modal-title">Nuevo Usuario</h5>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="id">

                        <label class="form-label">Usuario</label>
                        <input class="form-control"type="text" name="usuario" required=""> 

                        <label class="form-label">Contraseña</label>
                        <input class="form-control" type="password" name="contrasenia" required=""> 

                        <label class="form-label">Correo Electronico</label>
                        <input class="form-control"type="email" name="correoElectronico" required=""> 


                        <label class="form-label">Nombre Completo</label>
                        <input class="form-control"type="text" name="nombre" required=""> 


                        <label class="form-label">Alias</label>
                        <input class="form-control"type="text" name="alias" required=""> 

                        <label class="form-label">Descripcion</label>
                        <input class="form-control"type="text" name="descripcion"> 

                        <label class="form-label">Fecha de Nacimiento</label>
                        <input class="form-control"type="date" name="fechaNacimiento" required=""> 
                    </div>
                    <div class="modal-footer">
                        <input type="submit" value="Enviar" class="btn btn-outline-primary"> 
                        
                    </div>
                </div>
            </div>





            

        </form>
    </body>
</html>
