
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
                    <h5 class="modal-title">Administradores Formulario</h5>
                </div>
                <div class="modal-body">
                    <form action="AdminControlador" method="POST">
                        <input type="hidden" name="id_ad" value="${dat_admin.id}">
                        <input type="hidden" name="id" value="${Admin.id}">
                        <label class="form-label">Usuario</label>
                        <input class="form-control"type="text" name="usuario" value="${Admin.usuario}"placeholder="Ingrese el usuario"><br>
                        <label class="form-label">Contraseña</label>
                        <input class="form-control"type="text" name="password" value="${Admin.contraseña}"placeholder="Ingrese su contraseña"><br>
                        <input type="submit" name="enviar" class="btn btn-primary">
                    </form>
                </div>
                <div class="modal-footer">
                    <a class="btn btn-outline-dark"href="AdminControlador?id_admin=${dat_admin.id}">Exit</a>
                </div>
            </div>
        </div>
    </body>
</html>
