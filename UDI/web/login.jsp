<%-- 
Document   : login
Created on : 22-jul-2015, 17:01:17
Author     : Miguel Angel Lemos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <%session = request.getSession();
        try {
            if (!session.isNew() | !session.getAttribute("user").equals(null)) {
                response.sendRedirect("index.jsp");
            }
        } catch (java.lang.NullPointerException e) {
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>UDI</title>

        <!-- Bootstrap core CSS -->

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="fonts/css/font-awesome.min.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet">

        <!-- Custom styling plus plugins -->
        <link href="css/custom.css" rel="stylesheet">
        <link href="css/icheck/flat/green.css" rel="stylesheet">


        <script src="js/jquery.min.js"></script>

        <!--[if lt IE 9]>
            <script src="../assets/js/ie8-responsive-file-warning.js"></script>
            <![endif]-->

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
              <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
            <![endif]-->

    </head>

    <body class="border-dark nav-md">

        <div class="">
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <!-- Mensaje de alerta-->
            <div class="alert alert-<%=request.getParameter("msgAlt") != null ? request.getParameter("msgAlt") : ""%>" role="alert">   
                <b>
                    <h2 style="text-align: center;">
                        <a style="color:white"><%= request.getParameter("msg") != null ? request.getParameter("msg") : ""%></a>
                    </h2>
                </b>
            </div>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <section class="login_content">
                        <form action="ingreso" method="post">
                            <h1>Accede</h1>

                            <div>
                                <input type="text" id="user" name="user" class="form-control" placeholder="Usuario" required="" />
                            </div>
                            <div>
                                <input type="password" id="pass" name="pass" class="form-control" placeholder="Contrase&ntilde;a" required="" />
                            </div>
                            <div>
                                <input type="submit" class="btn btn-success submit" value="Ingresar"/>
                                <a class="reset_pass" href="#">&iquest;&Oacute;lvidaste tu contrase&ntilde;a?</a>
                            </div>
                            <div class="clearfix"></div>
                            <div class="separator">

                                <p class="change_link">&iquest;Nuevo en la aplicaci&oacute;n?
                                    <a href="#toregister" class="to_register"> Crea una cuenta </a>
                                </p>
                                <div class="clearfix"></div>
                                <br />
                                <div>
                                    <h1>
                                        <i class="fa fa-check-circle" style="font-size: 26px;" onclick="window.location = 'index.jsp'"></i> UDI&reg;
                                    </h1>

                                    <p>©2015 Unlimited Dreams. Todos los derechos reservados.</p>
                                </div>
                            </div>
                            <input type="hidden" name="action" id="action" value="otro"/>
                        </form>
                        <!-- form -->
                    </section>
                    <!-- content -->
                </div>
                <div id="register" class="animate form">
                    <section class="login_content">
                        <form action="ingreso" method="get">
                            <h1>Crear una cuenta</h1>
                            <table class="table-condensed">
                                <tr>
                                    <td>
                                        <input type="text" id="name" name="name" 
                                               class="form-control" placeholder="Nombre" required="" />
                                    </td>
                                    <td>
                                        <input type="text" id="lastname" name="lastname" 
                                               class="form-control" placeholder="Apellido" required="" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" id="id" name="id" 
                                               class="form-control" placeholder="Identificación" required=""
                                               onchange="alert('Cambio!')"/>
                                    </td>
                                    <td>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" id="user" name="user" id="user" name="user" 
                                               class="form-control" placeholder="Usuario" required="" />
                                    </td>
                                    <td>
                                        <input type="password" class="form-control" id="pass" name="pass" 
                                               placeholder="Contrase&ntilde;a" required="" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="email" class="form-control" id="email" name="email" 
                                               placeholder="Email" required="" />
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" id="phone" name="phone" 
                                               placeholder="Teléfono" required="" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="submit" class="btn btn-success submit" value="Registrarse"/>
                                    </td>
                                    <td>
                                        <input type="button" class="btn btn-warning submit" onclick="window.location.href = ('index.jsp')" value="Volver"></a>
                                    </td>
                                </tr>
                            </table>

                            <div class="clearfix"></div>
                            <div class="separator">
                                <p class="change_link">&iquest;Ya eres miembro?
                                    <a href="#tologin" class="to_register">Accede</a>
                                </p>
                                <div class="clearfix"></div>
                                <br />
                                <div onclick="window.location = 'index.jsp'">
                                    <h1><i class="fa fa-check-circle" style="font-size: 26px;"></i> UDI&REG;</h1>

                                    <p>©2015 Unlimited Dreams. Todos los derechos reservados.</p>
                                </div>
                            </div>
                        </form>
                        <!-- form -->
                    </section>
                    <!-- content -->
                </div>
            </div>
        </div>

    </body>

</html>
