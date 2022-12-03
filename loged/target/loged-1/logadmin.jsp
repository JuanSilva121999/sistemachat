<%-- 
    Document   : logadmin
    Created on : 1 dic. 2022, 23:40:14
    Author     : CJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Administrador</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>

    <body class="bg-light p-2 text-dark bg-opacity-10 " >    



        <div class="bg-primary p-2 text-dark bg-opacity-10"><h2>LAWEAA.kt Administrador</h2></div>

        <div class="modal-dialog">

            <div class="modal-content">
                <div class="shadow-lg p-3 mb-5 bg-body rounded">
                    <div class="modal-header">
                        <h3 class="modal-title">LOGIN ADMINSITRADOR</h3>
                    </div>

                    <div class="modal-body">
                        <form action="AdminController" method="post">
                            <input type="text" name="usuario" class="form-control">
                            <label for="exampleInputEmail1" class="form-label">Usuario</label>
                            <input type="password" name="password" class="form-control">
                            <label for="exampleInputEmail1" class="form-label">Contraseña</label><br>
                            <input type="submit" value="Ingresar" class="btn btn-primary">
                        </form>

                        

                    </div>
                    <div class="modal-footer">
                        <a href="login.jsp"class="btn btn-outline-secondary" role="button" >Atras</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
