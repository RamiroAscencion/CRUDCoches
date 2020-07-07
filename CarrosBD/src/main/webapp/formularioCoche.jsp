<%-- 
    Document   : modificarCoche
    Created on : 2 jul. 2020, 21:31:54
    Author     : AMD
--%>
<%@page import="Dao.*"%>
<%@page import="Config.Conexion"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String titulo = "Agregar Coche", coches = "", action="agregado.jsp";
    int id = 0;
    if (request.getParameter("idC") != null) {
        id = Integer.parseInt(request.getParameter("idC"));
        titulo = "Editar Coche";
        action = "modificado.jsp";
        CocheBD coc = new CocheBD(); 
        //coches = coc.modificarCoche(new Coche(id));                   
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>Insercion de Usuario</title>
    </head>
    <body>
        <div class="container">
            <h1><%=titulo%></h1>
            <form action="<%out.print(action);%>" methode="POST" class="form" >
                <div class="form-row">
                    <%if(id != 0 ){%>
                    <div class="col">
                        <input  type="hidden" class="form-control" name="id_usuario" value="<%=id%>"/>
                    </div>
                    <% } %>
                    <div class="col">
                        <input  type="text" placeholder="<%=usuarios%>" class="form-control" placeholder="Nombre" name="usuario" requiered/>
                    </div>
                     <div class="col">
                        <input type="int" class="form-control" placeholder="Edad" name="edad"  requiered />
                    </div>
                    <%if (id == 0) {%>
                    <div class="col">
                        <input type="password" class="form-control" placeholder="Contraseña" name="password"  requiered />
                    </div>
                    <% }%>
                    <div class="col">
                        <input type="submit" class="btn btn-success btn-block" value="Enviar" />
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
