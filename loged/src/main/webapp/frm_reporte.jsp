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
            <div class="modal-content shadow  mb-5 bg-body rounded">
                <div class="modal-header" style="background:#99F9F9;">
                    <h4 class="modal-title">Sala de reportes</h4>
                    <h5>El reporte no se vera a plena vista pero se llevara al administrasdor</h5>
                </div>
                <div class="modal-body">
                    <form action="ReporteControlador" method="POST">
                        <input type="hidden" name="id" value="${datos.id}">
                        <input type="hidden" name="id_sala" value="${ususal.id_sala}">
                        <input type="hidden" name="id_usuario" value="${ususal.id_usuario}">
                        <label>Seleccione la sala el tipo de reporte</label><br>
                        <select name="reporte" class="form-control">
                            <option value="">--seleccione--</option>
                            <c:forEach var="item" items="${reportes}">
                                <option value="${item.id}" 
                                        >${item.nombre}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <input type="submit" name="enviar" class="btn btn-primary">
                    </form>


                </div>
                <div class="modal-footer">
                    <a class="btn btn-danger"href="MensajeControlador?id_usuario=${ususal.id_usuario}&id_sala=${ususal.id_sala}">Atras</a>
                </div>
            </div>
        </div>


    </body>
</html>