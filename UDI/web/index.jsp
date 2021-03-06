<%-- 
    Document   : index
    Created on : 23-jul-2015, 15:09:48
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Unlimited Documentaci&oacute;n e Informaci&oacute;n</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="fonts/css/font-awesome.min.css" rel="stylesheet">


        <!-- Custom styling plus plugins -->
        <link href="css/stylish-portfolio.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">




    </head>


    <body class="border-dark nav-md">

        <!-- Docs master nav -->


        <header id="top" class="header">
            <div class="text-vertical-center">
                <h1><a href="#top" class="aero">UDI&REG;</a></h1>
                <h3>Garant&iacute;a y mejora de procesos<br>con un solo Clik</h3>
                <br>
                <a href="#about" class="btn btn-dark btn-lg">Aprende m&aacute;s</a>
                <a href="login.jsp" class="btn btn-light btn-lg">Accede</a>
            </div>

        </header>


        <!-- About -->
        <section id="about" class="about">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h3>&iquest;Muchos procesos para monitoriear, poco tiempo?</h3>
                        <h2>
                            Quiz&aacute; esta aplicaci&oacute;n sea la soluci&oacute;n a tus necesitades, solo necesitas registrarte para empezar la prueba gratis. 
                        </h2>
                        <p class="lead"> &quot;Las m&aacute;quinas no son nada sin una mente humana que las opere, 
                            los cuerpos humanos no pueden hacer lograr la perfecci&oacute;n sin una m&aacute;quina
                            que ayude en las labores m&aacute;s arduas e imposibles para la humanidad&quot;.
                        </p>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container -->
        </section>
        <!-- Footer -->
        <footer>
            <div class="container" id="contacto">
                <div class="row">
                    <div class="col-lg-10 col-lg-offset-1 text-center">
                        <hr class="small">
                        <h2>
                            <strong>UDI&reg;</strong>
                        </h2>   
                        <ul class="list-unstyled">
                            <li><i class="fa fa-phone fa-fw"></i> (318) 265-7417</li>
                            <li><i class="fa fa-envelope-o fa-fw"></i>  <a href="mailto:unlimitedDreamsTi@gmail.com">unlimitedDreamsTi@gmail.com</a>
                            </li>
                        </ul>
                        <br>
                        <ul class="list-inline">
                            <li>
                                <a href="#"><i class="fa fa-facebook fa-fw fa-3x"></i></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-twitter fa-fw fa-3x"></i></a>
                            </li>
                        </ul>
                        <hr class="small">
                        <p class="text-muted">Powered By Unlimited Dreams <br>Copyright &copy; Unlimited Dreams, Todos los derechos reservados.</p>
                    </div>
                </div>
            </div>
        </footer>

        <!-- jQuery -->
        <!-- Bootstrap Core JavaScript -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>


        <!-- Custom Theme JavaScript -->
        <script>
            // Closes the sidebar menu
            $("#menu-close").click(function (e) {
                e.preventDefault();
                $("#sidebar-wrapper").toggleClass("active");
            });

            // Opens the sidebar menu
            $("#menu-toggle").click(function (e) {
                e.preventDefault();
                $("#sidebar-wrapper").toggleClass("active");
            });

            // Scrolls to the selected menu item on the page
            $(function () {
                $('a[href*=#]:not([href=#])').click(function () {
                    if (location.pathname.replace(/^\//, '') === this.pathname.replace(/^\//, '') || location.hostname === this.hostname) {

                        var target = $(this.hash);
                        target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                        if (target.length) {
                            $('html,body').animate({
                                scrollTop: target.offset().top
                            }, 1000);
                            return false;
                        }
                    }
                });
            });
        </script>
    </body>
</html>
