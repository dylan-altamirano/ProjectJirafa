<!DOCTYPE HTML">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="java.util.LinkedList"%>
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
                                    <h:outputLink value="#" >
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
                                <h1 class="page-header">Registro de solicitudes de servicio</h1>
                            </div>
                            <!-- /.col-lg-12 -->
                        </div>
                        <!-- /.row -->
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">Agregar costos variables</div>
                                    <div class="panel-body">
                                        <h:form id="costosVariables">
                                            <div class="form-group">
                                                <label>
                                                    <h:outputText value="Tipo:"/>
                                                </label><h:selectOneMenu id="cboTipo" styleClass="form-control"
                                                                         value="#{beanRegistroCostosVariables.tipo}">
                                                    <f:selectItems value="#{beanRegistroCostosVariables.tipoCosto}"/>
                                                </h:selectOneMenu>
                                            </div>
                                            <div class="form-group input-group">
                                                <span class="input-group-addon">$</span><h:inputText id="txtMonto"
                                                                                                     styleClass="form-control"
                                                                                                     value="#{beanRegistroCostosVariables.monto}"/>
                                                 
                                                <span class="input-group-addon">.00</span>
                                            </div>
                                            <h:commandButton value="Agregar" id="cmdAgregar"
                                                             styleClass="btn btn-primary" style="margin-right:10px"
                                                             action="#{beanRegistroCostosVariables.agregarCosto}"/>
                                            <h:commandButton value="Limpiar" id="cmdLimpiar"
                                                             styleClass="btn btn-primary"/>
                                        </h:form>
                                    </div>
                                </div>
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.panel -->
                             <!--Resultados-->
                        <div class="col-lg-6">
                            <div class="panel panel-default">
                                <div class="panel-heading">Costos agregados</div>
                                <h:form id="resultados">
                                    <table class="table" style="table-layout:fixed;" cellspacing="1" cellpadding="2">
                                        <tr>
                                            <th>Tipo</th>
                                            <th>Precio</th>
                                        </tr>
                                         
                                        <%         
                                beanRegistroCostosVariables servicioBean = new beanRegistroCostosVariables();//Instancia del beans
                                
                                
                                 //metodo que llena la lista que procede del bean
                                
                                LinkedList<Costo_Variable> lista = new LinkedList<Costo_Variable>();// ArrayList
                                
                                lista = servicioBean.getListaCostos(); //Se llena la lista
                                
                                for (int i=0;i<lista.size();i++){
                                   out.println("<tr id='t"+lista.get(i).getId()+"'>");
                                   out.println("<td style='word-wrap:break-word;'>"+lista.get(i).getTipo().toString()+"</td>");
                                   out.println("<td>"+lista.get(i).getMonto()+"</td>");
                                   out.println("</tr>");
                                }
                            %>
                                    </table>
                                </h:form><!--/.panel-body-->
                            </div>
                            <!--/.panel-->
                        </div>
                        <!--/.col-lg-6-->
                        <div class="col-lg-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">Resumen Costos Variables</div>
                                    <div class="panel-body">
                                        <div class="form-group">
                                                <label>
                                                <h:outputText value="Total: "/>
                                            </label><h:outputText value="#{beanRegistroCostosVariables.totalCostos}" id="lblResultado"
                                                                  style="text-align:right"/>
                                        </div>
                                    </div>
                                </div>
                        </div>
                        
                        
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