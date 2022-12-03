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
                    <h5 class="modal-title">Inscribase en una de las salas disponibles que tenemos</h5>

                </div>
                <div class="modal-body">
                    <form action="SalaControlador" method="POST">
                        <input type="hidden" name="id" value="${info.id}">
                        <label>Seleccione la sala a la que quiere ingresar</label><br>
                        <select name="sala" class="form-control">
                            <option value="">--seleccione--</option>
                            <c:forEach var="item" items="${salas}">
                                <option value="${item.id}" 
                                        >${item.nombre}</option>
                            </c:forEach>


                        </select>
                        <br>
                        <input type="submit" name="enviar" class="btn btn-primary" >
                    </form>


                </div>
                <div class="modal-footer">
                    <form action="LoginController"method="post">
                        <input type="hidden" name="usuario" value="${info.usuario}">
                        <input type="hidden" name="password" value="${info.contrasenia}">
                        <input type="submit" name="enviar" value= "Atras" class="btn btn-danger" >
                    </form>
                </div>
            </div>
        </div>


    </body>
</html>
