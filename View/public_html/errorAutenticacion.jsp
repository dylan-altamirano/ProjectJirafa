<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="X-UA-Compatible" content="IE=edge charset=utf-8"></meta>
            <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
            <meta name="description" content=""></meta>
            <meta name="author" content=""></meta>
            <title>SISE | Sistema para Gesti&oacute;n de Servicios</title>
            <!-- Bootstrap Core CSS -->
            <link href="recursos/css/bootstrap.min.css" rel="stylesheet"></link>
            <!-- MetisMenu CSS -->
            <link href="recursos/css/metisMenu.min.css" rel="stylesheet"></link>
            <!-- Custom CSS -->
            <link href="recursos/css/sb-admin-2.css" rel="stylesheet"></link>
            <!-- Custom Fonts -->
            <link href="recursos/css/font-awesome.min.css" rel="stylesheet" type="text/css"></link>
        </head>
        <body>
            <div id="wrapper">
                <div id="page-wrapper">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">
                                    <h:outputText value="Autenticacion de sesion de usuario fallida. Por favor, vuelva a intentarlo."/>
                                    <small>
                                        <h:outputLink>
                                            <h:outputText value="Regresar"/>
                                        </h:outputLink>
                                    </small>
                                </h1>
                            </div>
                            <!-- /.col-lg-12 -->
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- /#page-wrapper -->
            </div>
            <!-- jQuery -->
            <script type="text/javascript" src="recursos/js/jquery.min.js"></script>
            <!-- Bootstrap Core JavaScript -->
            <script type="text/javascript" src="recursos/js/bootstrap.min.js"></script>
            <!-- Metis Menu Plugin JavaScript -->
            <script type="text/javascript" src="recursos/js/metisMenu.min.js"></script>
            <!-- Custom Theme JavaScript -->
            <script type="text/javascript" src="recursos/js/sb-admin-2.js"></script>
        </body>
    </html>
</f:view>