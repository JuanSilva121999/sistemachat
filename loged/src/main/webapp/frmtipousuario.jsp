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
                    <h5 class="modal-title">Añadir nuevos tipos de usuarios</h5>
                </div>
                <div class="modal-body">
                    <form action="TipoUsuarioControlador" method="POST">
                        <input type="hidden" name="idad" value="${datosadmin.id}">

                        <input type="hidden" name="idus" value="${tipousuario.id}">
                        <label class="form-label">Nombre</label><br>
                        <input class="form-control"type="text" name="nombre" value="${tipousuario.nombre}"placeholder="Ingrese el nombre de tipo de usuario"required size="50"><br>
                        <label class="form-label">Descripcion</label><br>
                        <input class="form-control"type="text" name="descripcion" value="${tipousuario.descripcion}"placeholder="Añade una descripcion"required size="80"><br>
                        <input type="submit" name="enviar"class="btn btn-primary">
                    </form>
                </div>
                <div class="modal-footer">
                    <a class="btn btn-outline-dark"href="TipoUsuarioControlador?id_admin=${datosadmin.id}">Atras</a>
                </div>
            </div>
        </div>
    </body>
</html>
