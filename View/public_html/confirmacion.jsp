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
            <link href="recursos/css/custom-style.css" rel="stylesheet"></link>
        </head>
        <body>
            <!--Card-->
            <div class="container" style="margin-top:5%;">
                <div class="row">
                    <!--Card content-->
                    <div class="panel panel-success">
                        <!--Title-->
                        <div class="panel-heading">
                            <h:outputText value="Operacion Exitosa"/>
                        </div>
                        <!--Text-->
                        <div class="panel-body">
                            <h:outputText value="Se han incluido exitosamente los datos en la base de datos."/>
                        </div>
                        <div class="panel-footer panel-custom">
                            <h:outputLink value="principal.jsp">
                                <h:outputText value="Volver a la página principal al sistema."/>
                            </h:outputLink>
                        </div>
                    </div>
                </div>
            </div>
            <!--/.Card-->
            <!-- jQuery -->
            <script type="text/javascript" src="recursos/js/jquery.min.js"></script>
            <!-- Bootstrap Core JavaScript -->
            <script type="text/javascript" src="recursos/js/bootstrap.min.js"></script>
            <!-- Metis Menu Plugin JavaScript -->
            <script type="text/javascript" src="recursos/js/metisMenu.min.js"></script>
            <!-- Custom Theme JavaScript -->
            <script type="text/javascript" src="recursos/js/sb-admin-2.js"></script>
            <!-- Bootstrap tooltips -->
        </body>
    </html>
</f:view>