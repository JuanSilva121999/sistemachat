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
    <body class="bg-dark">



        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header " style="background: #316F3A;color: white">
                    <h5 class="modal-title">Bienvenido a la sala  ${sala.nombre} ${info.nombre} alias ${info.alias}</h5>
                    <a class="btn btn-danger"href="SalaControlador?id=${info.id}">Salir</a>
                </div>
                <div class="modal-body" style="width:490px ;height: 300px;overflow: hidden; overflow-y: scroll">
                    <c:forEach var="item" items="${mensajes}">
                        <div class="toast-header 
                             <c:choose>
                                <c:when test="${item.id_usuario== info.id}">
                                    bg-success text-white
                                </c:when>
                                <c:when test="${item.id_usuario!= info.id}">
                                    
                                    bg-secondary text-white
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>
                             ">
                            <strong class="me-auto ">${item.nombre_usuario}</strong>
                            <c:choose>
                                <c:when test="${item.id_usuario== info.id}">
                                    <i class="fa-solid fa-check text-white"></i>
                                </c:when>
                                <c:when test="${item.id_usuario!= info.id}">
                                    <a class="btn btn-outline-warning" href="ReporteControlador?id_us_rep=${item.id_usuario}&id_sala=${sala.id}&id_usuario=${info.id}"><i class="fa-sharp fa-solid fa-circle-exclamation"></i></a>
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>
                            
                        </div>
                        <div class="toast-body">
                            ${item.asunto}
                        </div>
                    </c:forEach>
                </div>
                <div class="modal-footer">
                    <form action="MensajeControlador"method="post">
                        <input type="hidden" name="id_usuario" value="${info.id}">
                        <input type="hidden" name="id_sala" value="${sala.id}">
                        <input class="form-control" type="text" name="mensaje"placeholder="Escriba el mensaje">
                        <input type="submit" name="enviar" class="btn btn-success" style="width: 470px;">

                    </form
                </div>
            </div>
        </div>
        >
    </body>
</html>
