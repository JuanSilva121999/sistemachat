<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                    <h5 class="modal-title">Añadir nuevas salas</h5>
                </div>
                <div class="modal-body">
                    <form action="AdminSalaControlador" method="POST">
                        <input type="hidden" name="id" value="${sala.id}">
                        <input type="hidden" name="idad" value="${dat_admin.id}">
                        <label class="form-label">Nombre</label><br>
                        <input class="form-control"type="text" name="nombre" value="${sala.nombre}"placeholder="Ingrese el usuario"><br>
                        <label class="form-label">Estado</label><br>
                        <input class="form-control"type="text" name="estado" value="${sala.estado}"placeholder="Ingrese su contraseña"><br>
                        <label class="form-label">Tipo de sala</label><br>
                        <select class="form-control"name="id_tipo_sala">
                            <option value="">--seleccione--</option>
                            <c:forEach var="item" items="${tiposala}">
                                <option value="${item.id}"
                                        >${item.nombre}</option>
                            </c:forEach>

                            >
                        </select><br>

                        <input type="submit" name="enviar"class="btn btn-primary">
                    </form>
                </div>
                <div class="modal-footer">
                     <a class="btn btn-outline-dark"href="AdminSalaControlador?id_admin=${dat_admin.id}">Salir</a>
                </div>
            </div>
        </div>
    </body>
</html>
