<!DOCTYPE HTML">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="appProyecto.view.beanRegistroCostosVariables"%>
<%@ page import="appProyecto.model.Costo_Variable"%>
<%@ page import="appProyecto.model.Costo_VariableDB"%>
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
                                    <h:outputLink value="#">
                                        <h:outputText value="Catalogo de Servicios"/>
                                    </h:outputLink>
                                </li>
                                 
                                <li>
                                    <!--<a href="#"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>-->
                                    <h:outputLink value="#">
                                        <h:outputText value="Tipos de Servicio"/>
                                    </h:outputLink>
                                </li>
                                 
                                <li>
                                    <!--<a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>-->
                                    <h:outputLink value="#">
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
                                    <h:outputLink value="#">
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
                                <h1 class="page-header">Resumen de Solicitud de Servicio</h1>
                            </div>
                            <!-- /.col-lg-12 -->
                        </div>
                        <!-- /.row -->
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">Consulta</div>
                                <div class="panel-body">
                                    <h:form id="busqueda">
                                        <div class="form-group">
                                            <label>
                                                <h:outputText value="Buscar:"/>
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <h:inputText id="txtBuscar" styleClass="form-control"
                                                         value="#{beanFacturacion.valorBuscado}"/>
                                            <p class="help-block">Introduzca el valor a buscar.</p>
                                        </div>
                                        <h:commandButton value="BUSCAR" styleClass="btn btn-primary" id="cmdBuscar"
                                                         action="#{beanFacturacion.obtenerOrden}"/>
                                    </h:form>
                                </div>
                                <!--/.panel-body-->
                            </div>
                            <!--/.panel-->
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">Solicitud de Servicio</div>
                                    <div class="panel-body">
                                        <h:form>
                                            <table class="table" style="table-layout:fixed;" cellspacing="1"
                                                   cellpadding="2">
                                                <tr>
                                                    <th colspan="6" style="text-align:center;">Detalles del la Solicitud</th>
                                                </tr>
                                                 
                                                <tr>
                                                    <td colspan="2">N&ordm; Solicitud:</td>
                                                    <td colspan="0">
                                                        <h:outputText value="#{beanFacturacion.codigoSolicitud}"
                                                                      id="codigo"/>
                                                    </td>
                                                    <td colspan="2">Fecha de Registro:</td>
                                                    <td colspan="0">
                                                        <h:outputText value="#{beanFacturacion.fechaRegistro}"
                                                                      id="fecRegistro"/>
                                                    </td>
                                                </tr>
                                                 
                                                <tr>
                                                    <td colspan="2">Fecha de Ejecucion:</td>
                                                    <td colspan="0">
                                                        <h:outputText value="#{beanFacturacion.fecEjecucion}"
                                                                      id="fecEjecucion"/>
                                                    </td>
                                                    <td colspan="2">Duracion(horas):</td>
                                                    <td colspan="0">
                                                        <h:outputText value="#{beanFacturacion.estimacionHoras}"
                                                                      id="estimacionHoras"/>
                                                    </td>
                                                </tr>
                                                 
                                                <tr>
                                                    <td colspan="3">Estado:</td>
                                                    <td colspan="3">
                                                        <h:outputText value="#{beanFacturacion.estado}" id="estado"/>
                                                    </td>
                                                </tr>
                                                 
                                                <tr>
                                                    <th colspan="6" style="text-align:center;">Detalles del Cliente</th>
                                                </tr>
                                                 
                                                <tr>
                                                    <td>ID:</td>
                                                    <td>
                                                        <h:outputText id="clienteID"
                                                                      value="#{beanFacturacion.idCliente}"/>
                                                    </td>
                                                    <td>Nombre:</td>
                                                    <td>
                                                        <h:outputText id="clienteNombre"
                                                                      value="#{beanFacturacion.nombreCliente}"/>
                                                    </td>
                                                    <td>Correo electr&oacute;nico:</td>
                                                    <td>
                                                        <h:outputText id="clienteCorreo"
                                                                      value="#{beanFacturacion.correoCliente}"/>
                                                    </td>
                                                </tr>
                                                 
                                                <tr>
                                                    <th colspan="6" style="text-align:center;">Detalles del Servicio</th>
                                                </tr>
                                                 
                                                <tr>
                                                    <td>N&ordm; Servicio:</td>
                                                    <td>
                                                        <h:outputText id="servicioID"
                                                                      value="#{beanFacturacion.idServicio}"/>
                                                    </td>
                                                    <td>Nombre:</td>
                                                    <td>
                                                        <h:outputText id="servicioNombre"
                                                                      value="#{beanFacturacion.nombreServicio}"/>
                                                    </td>
                                                    <td>Tipo:</td>
                                                    <td>
                                                        <h:outputText id="servicioTipo"
                                                                      value="#{beanFacturacion.tipoServicio}"/>
                                                    </td>
                                                </tr>
                                                 
                                                <tr>
                                                    <th colspan="6" style="text-align:center;">Costos del servicio</th>
                                                </tr>
                                                 
                                                <tr>
                                                    <td>Costo por hora:</td>
                                                    <td>
                                                        <h:outputText id="servicioCostoHora"
                                                                      value="#{beanFacturacion.costoHora}"/>
                                                    </td>
                                                    <td>Subtotal:</td>
                                                    <td>
                                                        <h:outputText id="servicioParcial"
                                                                      value="#{beanFacturacion.subtotal}"/>
                                                    </td>
                                                    <td>Total:</td>
                                                    <td>
                                                        <h:outputText id="servicioTotal"
                                                                      value="#{beanFacturacion.total}"/>
                                                    </td>
                                                </tr><tr>
                                                    <td colspan="3" style="text-align:left;">Descuento aplicado</td>
                                                    <td colspan="3" style="text-align:left;">
                                                        <h:outputText value="#{beanFacturacion.deascuentoAplicado}"
                                                                      id="descAplicado"/>
                                                    </td>
                                                </tr>
                                                 
                                                <tr>
                                                    <td colspan="3" style="text-align:left;">Detalles:</td>
                                                    <td colspan="3" style="text-align:left;">
                                                        <h:outputText value="#{beanFacturacion.detalles}"
                                                                      id="servicioDetalle"/>
                                                    </td>
                                                </tr>
                                                 
                                                <tr>
                                                    <td colspan="3" style="text-align:left;">Observaciones:</td>
                                                    <td colspan="3" style="text-align:left;">
                                                        <h:outputText value="#{beanFacturacion.observaciones}"
                                                                      id="servicioObservaciones"/>
                                                    </td>
                                                </tr>
                                                 
                                                <tr>
                                                    <td colspan="3" style="text-align:left;">
                                                        <h:commandButton value="Facturar" id="cmdFormalizar"
                                                                         styleClass="btn btn-primary"
                                                                         action="#{beanFacturacion.Facturar}"/>
                                                    </td>
                                                    <td colspan="3" style="text-align:left;">
                                                        <h:commandButton value="Cancelar" id="idCancelar"
                                                                         styleClass="btn btn-primary"/>
                                                    </td>
                                                </tr>
                                            </table>
                                        </h:form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.container-fluid -->
                </div>
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