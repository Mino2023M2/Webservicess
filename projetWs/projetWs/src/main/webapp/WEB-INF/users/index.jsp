<%-- 
    Document   : index
    Created on : 31-ago-2019, 0:37:22
    Author     : Akin Ramirez
--%>
<%@page import="java.util.List"%> 
<%@page import="com.metier.model.Professeur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

  </head>
  <%
    List<Professeur> list = (List<Professeur>) request.getAttribute("donnee");
  %>
  <body>
    <div class="container mt-4">
      <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8"> 
          <div class="card">
            <div class="card-header">
              <form method="POST" action="Service">
                <button class="btn btn-primary btn-sm" type="submit" name="accion" value="add">ajouter</button>
              </form>
            </div>
            <div class="card-body">
              <table class="table table-sm table-responsive-sm table-hover"> 
                <thead>
                  <tr>
                    <th>#</th>
                    <th>nom</th>
                    <th>prenom</th>
                    <th>age</th>
                    <th style="width: 180px;">Acciones</th>
                  </tr>
                </thead>
                <tbody>
                  <% for (Professeur user : list) {%>
                  <tr>
                    <td><%= user.getId()%></td>
                    <td><%= user.getNom()%></td>
                    <td><%= user.getPreNom()%></td>
                    <td><%= user.getAge()%></td>
                    <td>
                      <a href="Service?accion=edit&id=<%= user.getId()%>" class="btn btn-warning btn-sm"> Edit</a>
                      <a href="Service?accion=delete&id=<%= user.getId()%>" class="btn btn-danger btn-sm"> Eliminer</a>
                    </td>
                  </tr>
                  <%}%>
                </tbody>
              </table>
            </div>
          </div>      
        </div>
      </div>
    </div>
  </body>
</html>
