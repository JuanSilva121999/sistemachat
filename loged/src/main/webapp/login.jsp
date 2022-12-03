<%-- 
    Document   : login
    Created on : 24 nov. 2022, 23:15:16
    Author     : CJ
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado de Persona</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="bg-light p-2 text-dark bg-opacity-10 " >    



        <div class="bg-primary p-2 text-dark bg-opacity-10"><h2>LAWEAA.kt</h2></div>

        <div class="modal-dialog">

            <div class="modal-content">
                <div class="shadow-lg p-3 mb-5 bg-body rounded">
                    <div class="modal-header">
                        <h3 class="modal-title">LOGIN</h3>
                    </div>

                    <div class="modal-body">
                        <form action="LoginController" method="post">
                            <div class="mb-3">
                                <input type="text" name="usuario"class="form-control">
                                <label for="exampleInputEmail1" class="form-label">Usuario</label>
                                <input type="password" name="password"class="form-control" aria-describedby="passwordHelpInline">
                                <label for="exampleInputEmail1" class="form-label">Contraseña</label><br>
                                <input type="submit" value="Ingresar" class="btn btn-primary">  
                            </div>   
                        </form>
                        
                        <a href="signup.jsp">Registrarse en LAWEA.KT</a><br>
                        <a href="recover.jsp">¿Olvidaste tu usuario o contraseña?</a><br>
                        <a href="logadmin.jsp">Ingresar como admnistrador</a>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
