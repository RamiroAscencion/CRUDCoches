<%-- 
    Document   : index
    Created on : 4 jun. 2020, 15:19:31
    Author     : AMD
--%>

<%@page import="Dao.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Connection conexion = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/coches", "root", "");
        stmt = conexion.createStatement();
        rs = stmt.executeQuery("Select * from coche");
    } catch (Exception e) {
        out.println("error" + e);
    }%>
    
<%
    List<Coche> coches = new CocheBD().ListadoCoches();
    List<Marca> marcas = new MarcaBD().ListadoMarcas();

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <h1  style="text-align:center;">CRUD DE COCHES</h1>
    <title>CRUD de COCHES</title>
    <p align="center">
        <font face="Tahoma" size="2">
        </font>
    </p>
    </head>
    <body>
        <h1>Los registros en la base de datos son: </h1>
        <div class="container">
            <table class="table table-hover">
                <thead class=" thead-dark">
                    <tr>
                        <td colspan="2"><h2>Coches</h2></td>
                        <td><a class="btn btn-success btn-block" href="formularioCoche.jsp">Agregar coche</a></td>
                    </tr>
                    <tr>
                        <th scope="col" style="text-align:center;">Numero de serie</th>
                        <th scope="col" style="text-align:center;">Color</th>
                        <th scope="col" style="text-align:center;">Modelo</th>
                        <th scope="col" style="text-align:center;">Tipo de combustible</th>
                        <th scope="col" style="text-align:center;">Tipo</th>
                        <th scope="col" style="text-align:center;">Id Marca</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Coche coche : coches) {%>
                    <tr>
                        <th scope="row" style="text-align:center;"><%=coche.getNume_serie()%></th>
                        <td style="text-align:center;"><%=coche.getColor()%></td>
                        <td style="text-align:center;"><%=coche.getModelo()%></th>
                        <td style="text-align:center;"><%=coche.getTipo_combustible()%></td>
                        <td style="text-align:center;"><%=coche.getTipo()%></td>
                        <%
                            int idCata=coche.getId_catalogo();
                            MarcaBD mark = new MarcaBD(); 
                            String marca = mark.dameNombre(new Marca(idCata)); 
                        %>
                        <td style="text-align:center;"><%out.print(marca);%></td>
                        
                        
                        <td><a class="btn btn-warning btn-block" href="formularioCoche.jsp?idC=<%=coche.getNume_serie()%>"></a>Editar</td>
                        <td><a class="btn btn-danger btn-block"  href="eliminarCoche.jsp?idC=<%=coche.getNume_serie()%>"></a>Eliminar</td>
                    </tr>
                    <% }%> 
                </tbody>
            </table>
        </div>
    <br>
    <br>
    <br>
        <div class="container">
            <table class="table table-hover">
                <thead class=" thead-dark">
                    <tr>
                        <td colspan="2"><h2>Catalogo marca</h2></td>
                        <td><a class="btn btn-success btn-block" href="formularioMarca.jsp">Agregar Marca</a></td>
                    </tr>
                    <tr>
                        <th scope="col" style="text-align:center;">Id catalogo</th>
                        <th scope="col" style="text-align:center;">Marca</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Marca marca : marcas) {%>
                    <tr>
                        <th scope="row" style="text-align:center;"><%=marca.getId_marca()%></th>
                        <td style="text-align:center;"><%=marca.getNom_marca()%></td>                        
                        <td><a class="btn btn-warning btn-block" href="formularioMarca.jsp?id=<%=marca.getId_marca()%>"></a>Editar</td>
                        <td><a class="btn btn-danger btn-block"  href="eliminarMarca.jsp?id=<%=marca.getId_marca()%>"></a>Eliminar</td>
                    </tr>
                    <% }%>
                </tbody>
            </table>    
        </div>
    </body>
</html>
