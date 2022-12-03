<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

%>
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
                <div class="modal-header">
                    <h2 class="modal-title">Bienvenido a las salas inscritas</h2> 
                </div>
                <div class="modal-body  justify-content-center aling-items-center">
                    <h5>Bienvenido ${info.alias} puedes entrar a las salas </h5><br><br>
                    <table " >


                        <c:forEach var="item" items="${salas}">
                            <tr>
                                <td WIDTH="300"><h4>${item.nombre_sala}</h4> </td>
                                <td "> <a class="btn btn-outline-success " role="button" href="MensajeControlador?id_usuario=${info.id}&id_sala=${item.id_sala}">Ingresar<i class="fa-solid fa-check"></i> </a></td>
                                <td><a class="btn btn-outline-danger" class="btn-close"role="button" href="SalaControlador?action=delete&id_Us_Sa=${item.id}&id=${info.id}"><i class="fa-sharp fa-solid fa-circle-xmark"></i></a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="modal-footer">
                    <form action="LoginController"method="post">
                        <input type="hidden" name="usuario" value="${info.usuario}">
                        <input type="hidden" name="password" value="${info.contrasenia}">
                        <input type="submit" name="enviar" value="Atras" class="btn btn-danger" >
                    </form>
                </div>
            </div>
        </div>





    </body>
</html>
