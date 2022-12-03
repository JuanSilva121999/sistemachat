<%-- 
    Document   : noCorreo
    Created on : 28 nov. 2022, 17:55:19
    Author     : CJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Error</title>
    </head>
    <body class="bg-light text-dark">

        
        <div class="modal-dialog">
            <div class="modal-content shadow p-3 mb-5 bg-body rounded">
                <div class="modal-header">
                    <h3 class="modal-title">Correo no registrado</h3>
                    
                </div>
                <div class="modal-body">
                    <p>No se encontro su correo electronico en la base de datos</p>
                    <p>Por favor ingrese un correo electronico registrado</p>
                </div>
                <div class="modal-footer">
                    <a class="btn btn-outline-danger"href="recover.jsp">Recuperacion de usuario y contraseña</a>
                </div>
            </div>
        </div>
    </body>
</html>
