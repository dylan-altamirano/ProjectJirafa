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
            <!--main container-->
            <div id="wrapper">
                <!-- Navigation -->
                <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                         
                        <a class="navbar-brand" href="#">SISE-Sistema para Gestion de Servicios</a>
                    </div>
                    <!-- /.navbar-header -->
                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="fa fa-user fa-fw"></i><i class="fa fa-caret-down"></i></a>
                            <ul class="dropdown-menu dropdown-user">
                                <li>
                                    <a href="#">
                                        <i class="fa fa-user fa-fw"></i>User Profile</a>
                                </li>
                                 
                                <li>
                                    <a href="#">
                                        <i class="fa fa-gear fa-fw"></i>Settings</a>
                                </li>
                                 
                                <li class="divider"></li>
                                 
                                <li>
                                    <a href="#">
                                        <i class="fa fa-sign-out fa-fw"></i>Logout</a>
                                </li>
                            </ul>
                            <!-- /.dropdown-user -->
                        </li><!-- /.dropdown -->
                    </ul>
                    <!-- /.navbar-top-links -->
                    <div class="navbar-default sidebar" role="navigation">
                        <div class="sidebar-nav navbar-collapse">
                            <ul class="nav" id="side-menu">
                                <li>
                                    <!--<a href="#"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>-->
                                    <h:outputLink value="RegistroServicios.jsp">
                                        <h:outputText value="Catalogo de Servicios"/>
                                    </h:outputLink>
                                </li>
                                 
                                <li>
                                    <!--<a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>-->
                                    <h:outputLink>
                                        <h:outputText value="Administracion de Clientes"/>
                                    </h:outputLink>
                                    <!--<ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Flot Charts</a>
                                </li>
                                <li>
                                    <a href="morris.html">Morris.js Charts</a>
                                </li>
                            </ul>-->
                                    <!-- /.nav-second-level -->
                                </li>
                                 
                                <li>
                                    <!-- <a href="tables.html"><i class="fa fa-table fa-fw"></i> Tables</a>-->
                                    <h:outputLink>
                                        <h:outputText value="Registro de Ordenes de Servicio"/>
                                    </h:outputLink>
                                </li>
                                 
                                <li>
                                    <!--<a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>-->
                                    <h:outputLink>
                                        <h:outputText value="Facturacion"/>
                                    </h:outputLink>
                                </li>
                            </ul>
                        </div>
                        <!-- /.sidebar-collapse -->
                    </div>
                    <!-- /.navbar-static-side -->
                </nav>
                <div id="page-wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                <h:outputText value="Registro Servicios"/>
                            </h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">Introducción de datos</div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <h:form>
                                                <div class="form-group">
                                                    <label>
                                                        <h:outputText value="Descripcion:"/>
                                                    </label>
                                                     
                                                    <h:inputText styleClass="form-control"/>
                                                    <p class="help-block">Introduzca una breve descripci&oacute;n del
                                                                          servicio.</p>
                                                </div>
                                                <div class="form-group">
                                                    <label>
                                                        <h:outputText value="Tipo Servicio"/>
                                                    </label>
                                                     
                                                    <h:selectOneMenu styleClass="form-control">
                                                        <f:selectItem itemLabel="Financieros" itemValue="Financieros"/>
                                                        <f:selectItem itemLabel="Mecanicos" itemValue="Mecanicos"/>
                                                        <f:selectItem itemLabel="Tecnicos" itemValue="Tecnicos"/>
                                                        <f:selectItem itemLabel="Construccion"
                                                                      itemValue="Construccion"/>
                                                        <f:selectItem itemLabel="Reclutamiento"
                                                                      itemValue="Reclutamiento"/>
                                                    </h:selectOneMenu>
                                                </div>
                                                <div class="form-group input-group">
                                                    <span class="input-group-addon">$</span>
                                                     
                                                    <h:inputText styleClass="form-control"/>
                                                     
                                                    <span class="input-group-addon">.00</span>
                                                </div>
                                                <div class="form-group">
                                                    <label>
                                                        <h:outputText value="Estado:"/>
                                                    </label>
                                                    <div class="checkbox">
                                                        <label>
                                                            <h:selectBooleanCheckbox label="Activo"/>
                                                        </label>
                                                    </div>
                                                </div>
                                                <h:commandButton value="Registrar" styleClass="btn btn-success"/>
                                            </h:form>
                                        </div>
                                        <!-- /.col-lg-6 (nested) -->
                                    </div>
                                    <!-- /.row (nested) -->
                                </div>
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.panel -->
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /#page-wrapper -->
            </div>
            <!-- /#wrapper -->
            <!-- /#wrapper -->
        </body>
    </html>
</f:view>