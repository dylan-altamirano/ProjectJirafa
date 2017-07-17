<!DOCTYPE HTML">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
    <html>    
    <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge;  charset=windows-1252">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Ingreso</title>

    <!-- Bootstrap Core CSS -->
    <link href="recursos/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="recursos/css/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="recursos/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="recursos/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
    
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Ingreso al sistema</h3>
                    </div>
                    <div class="panel-body">
                        <h:form id="loginForm">
                            <fieldset>
                                <div class="form-group">
                                    <h:inputText styleClass="form-control marcagua-user" id="usuario"/>
                                </div>
                                <div class="form-group">
                                    <h:inputSecret styleClass="form-control marcagua-pass" id="clave"/>
                                </div>
                                <h:commandButton value="Ingresar" action="bien"
                                                 styleClass="btn btn-lg btn-success btn-block"/>
                            </fieldset>
                        </h:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script type="text/javascript" src="recursos/js/jquery.js"></script>
    <script type="text/javascript" src="recursos/js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script type="text/javascript" src="recursos/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script type="text/javascript" src="recursos/js/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script type="text/javascript" src="recursos/js/sb-admin-2.js"></script>
    
    <script type="text/javascript">
        $('.marcagua-user').attr('placeholder','Usuario');
        $('.marcagua-pass').attr('placeholder','Clave');
    </script>
    
</body>
        
    </html>
</f:view>