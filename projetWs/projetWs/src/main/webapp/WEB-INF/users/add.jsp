<%-- 
    Document   : add
    Created on : 01-sep-2019, 7:42:18
    Author     : Akin Ramirez
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

  </head>
  <body>
    <div class="container mt-4">
      <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8"> 
          <div class="card">
            <div class="card-header">
              <h6>Agregar Usuario</h6>
            </div>
            <div class="card-body"> 
                <form role="form" action="Service" method="post">
                <input type="hidden" name="accion" value="insert">

                <label>nom</label>
                <input type="text" name="nom" class="form-control form-control-sm"   autocomplete="off">
                <label>prenom</label>
                <input type="text" name="prenom" class="form-control form-control-sm"  autocomplete="off">
                 <label>age</label>
                <input type="text" name="age" class="form-control form-control-sm" autocomplete="off">
                <br> <br>
                <a href="Service" class="btn btn-secondary btn-sm">Retour</a>
                <button type="submit" class="btn btn-success btn-sm">ajouter</button>
              </form>
            </div>
          </div>      
        </div>
      </div>
    </div>
  </body>
</html>
