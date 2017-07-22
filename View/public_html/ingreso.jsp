<!DOCTYPE HTML">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="X-UA-Compatible" content="IE=edge;  charset=windows-1252"></meta>
            <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
            <meta name="description" content=""></meta>
            <meta name="author" content=""></meta>
            <title>Ingreso</title>
            <!-- Bootstrap Core CSS -->
            <link href="recursos/css/bootstrap.min.css" rel="stylesheet"></link>
            <!-- MetisMenu CSS -->
            <link href="recursos/css/metisMenu.min.css" rel="stylesheet"></link>
            <!-- Custom CSS -->
            <link href="recursos/css/sb-admin-2.css" rel="stylesheet"></link>
            <!-- Custom Fonts -->
            <link href="recursos/css/font-awesome.min.css" rel="stylesheet" type="text/css"></link>
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
                                        <h:inputText styleClass="form-control marcagua-user" id="usuario"
                                                     value="#{beanIngreso.usuario}"/>
                                    </div>
                                    <div class="form-group">
                                        <h:selectOneMenu label="Seleccione el rol..." styleClass="form-control"
                                                         value="#{beanIngreso.rol}">
                                            <f:selectItem itemLabel="Administrador" itemValue="Administrador"/>
                                            <f:selectItem itemLabel="Corriente" itemValue="Corriente"/>
                                        </h:selectOneMenu>
                                    </div>
                                    <div class="form-group">
                                        <h:inputSecret styleClass="form-control marcagua-pass" id="clave"
                                                       value="#{beanIngreso.clave}"/>
                                    </div>
                                    <h:commandButton value="Ingresar" action="#{beanIngreso.validaNulos}"
                                                     styleClass="btn btn-lg btn-success btn-block"/>
                                                     <div class="form-group">
                                                    <label>
                                                        <h:outputText value="#{beanIngreso.nulos}"/>
                                                    </label>
                                                    <p class="help-block"></p>
                                                </div>
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
          $('.marcagua-user').attr('placeholder', 'Usuario');
          $('.marcagua-pass').attr('placeholder', 'Clave');
        </script>
    </html>
</f:view>