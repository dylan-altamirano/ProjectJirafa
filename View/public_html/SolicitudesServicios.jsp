<!DOCTYPE HTML">
<%@ page contentType="text/html;charset=utf-8"%>
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
            <link href="recursos/css/jquery-ui.css" rel="stylesheet" type="text/css"></link>
        </head>
        <body>
            <div id="wrapper">
                <!-- Navigation -->
                <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                        </button>
                         
                        <a class="navbar-brand" href="#">SISE-Sistema para Gestion de Servicios</a>
                    </div>
                    <!-- /.navbar-header -->
                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown">
                            <ul class="dropdown-menu dropdown-user">
                                <li>
                                    <a href="#">Perfil del usuario</a>
                                </li>
                                 
                                <li>
                                    <a href="#">Ajustes</a>
                                </li>
                                 
                                <li class="divider">&nbsp;</li>
                                 
                                <li>
                                    <a href="ingreso.jsp">Salir</a>
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
                                    <!--<a href="#"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>-->
                                    <h:outputLink value="RegistroTipoServicios.jsp">
                                        <h:outputText value="Tipos de Servicio"/>
                                    </h:outputLink>
                                </li>
                                 
                                <li>
                                    <!--<a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>-->
                                    <h:outputLink value="RegistroClientes.jsp">
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
                                    <h:outputLink value="SolicitudesServicios.jsp">
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
                </nav><!-- Page Content -->
                <div id="page-wrapper">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">Registro de solicitudes de servicio</h1>
                            </div>
                            <!-- /.col-lg-12 -->
                        </div>
                        <!-- /.row -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">Detalle del Servicio</div>
                                    <div class="panel-body">
        
                                                <h:form id="detalleOrden">
                                                    <div class="form-group">
                                                        <label>
                                                            <h:outputText value="Fecha:"/>
                                                        </label>
                                                         
                                                        <h:inputText styleClass="form-control"
                                                                     value="#{beanRegistroDetalle.fecha}"
                                                                     id="datepicker">
                                                </h:inputText>
                                                    </div>
                                                    <div class="form-group input-group">
                                                        <span class="input-group-addon">Duracion(Estimacion en horas)</span>
                                                         
                                                        <h:selectOneMenu styleClass="form-control"
                                                                         value="#{beanRegistroDetalle.horas}">
                                                            <f:selectItem itemValue="#{null}"
                                                                          itemLabel="-- Seleccione uno --"/>
                                                            <f:selectItems value="#{beanRegistroDetalle.listaHoras}"/>
                                                        </h:selectOneMenu>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>
                                                            <h:outputText value="Detalle del servicio:"/>
                                                        </label>
                                                        <h:inputTextarea id="txaDetalle" styleClass="form-control" rows="5" cols="60"
                                                                         value="#{beanRegistroDetalle.detalle}"/>
                                                    </div>
                                                   
                                                    <div class="form-group">
                                                        <label>
                                                            <h:outputText value="Observaciones:"/>
                                                        </label><h:inputTextarea id="txaObservaciones" rows="5"
                                                                                 cols="60" styleClass="form-control"
                                                                                 value="#{beanRegistroDetalle.observaciones}"/>
                                                        <p class="help-block">Describa algunas observaciones o notas importantes del servicio.</p>
                                                    </div>
                                            <h:commandButton value="Siguiente" id="cmdSiguiente"
                                                             action="#{beanRegistroDetalle.guardar}"
                                                             styleClass="btn btn-primary"/>
                                            <h:commandButton value="Cancelar" styleClass="btn btn-primary"/>
                                                </h:form>
                                    </div>                
                                </div>
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.panel -->
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->
            <!-- /#wrapper -->
            <script src="recursos/js/jquery.min.js"></script>
            <script src="recursos/js/jquery-ui.js"></script>
            <script src="recursos/js/ui.js"></script>
            <script src="recursos/js/bootstrap.min.js"></script>
            <script src="recursos/js/metisMenu.min.js"></script>
            <script src="recursos/js/sb-admin-2.js"></script>
        </body>
    </html>
</f:view>