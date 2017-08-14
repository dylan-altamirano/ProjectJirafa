<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="appProyecto.view.beanRegistroServicios"%>
<%@ page import="appProyecto.model.Servicio"%>
<%@ page import="appProyecto.model.ServicioDB"%>
<%@ page import="appProyecto.model.TipoServicio"%>
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
                        <div class="col-lg-6">
                            <div class="panel panel-default">
                                <div class="panel-heading">Introducci&oacute;n de datos</div>
                                <div class="panel-body">
                                    <h:form>
                                        <div class="form-group">
                                            <label>
                                                <h:outputText value="Identificador:"/>
                                            </label><h:inputText value="#{beanRegistroServicios.codigo}"
                                                                 styleClass="form-control"/>
                                            <p class="help-block">Introduzca una identificaci&oacute;n para el servicio.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <h:outputText value="Descripcion:"/>
                                            </label>
                                             
                                            <h:inputText styleClass="form-control"
                                                         value="#{beanRegistroServicios.descripcion}"/>
                                            <p class="help-block">Introduzca una breve descripci&oacute;n del servicio.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <h:outputText value="Tipo Servicio"/>
                                            </label><h:selectOneMenu styleClass="form-control"
                                                                     value="#{beanRegistroServicios.tipoServicioSeleccionado}">
                                                <f:selectItem itemValue="#{null}" itemLabel="-- select one --"/>
                                                <f:selectItems value="#{beanRegistroServicios.tipoServicios}"/>
                                            </h:selectOneMenu>
                                        </div>
                                        <div class="form-group input-group">
                                            <span class="input-group-addon">$</span>
                                             
                                            <h:inputText styleClass="form-control"
                                                         value="#{beanRegistroServicios.costo}"/>
                                             
                                            <span class="input-group-addon">.00</span>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <h:outputText value="Estado:"/>
                                            </label><h:selectOneMenu styleClass="form-control"
                                                                     value="#{beanRegistroServicios.estado}">
                                                <f:selectItem itemLabel="Activo" itemValue="1"/>
                                                <f:selectItem itemLabel="Inactivo" itemValue="2"/>
                                            </h:selectOneMenu>
                                        </div>
                                        <h:commandButton value="Registrar" styleClass="btn btn-primary"
                                                         action="#{beanRegistroServicios.validar}"/>
                                        <h:commandButton value="Eliminar" styleClass="btn btn-primary"
                                                         style="margin-left:10px"/>
                                        <h:commandButton value="Cancelar" styleClass="btn btn-primary"
                                                         style="margin-left:10px"/>
                                    </h:form>
                                </div>
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.panel -->
                        </div>
                        <!-- /.col-lg-12 -->
                        <div class="col-lg-6">
                            <div class="panel panel-default">
                                <div class="panel-heading">Consulta</div>
                                <div class="panel-body">
                                    <h:form>
                                        <div class="form-group">
                                            <label>
                                                <h:outputText value="Buscar por:"/>
                                            </label><h:selectOneMenu styleClass="form-control"
                                                                     value="#{beanRegistroServicios.opcionFiltrado}">
                                                <f:selectItem itemValue="#{null}" itemLabel="-- Seleccione uno --"/>
                                                <f:selectItem itemLabel="Identificador" itemValue="1"/>
                                                <f:selectItem itemLabel="Nombre" itemValue="2"/>
                                                <f:selectItem itemLabel="Tipo" itemValue="3"/>
                                                <f:selectItem itemLabel="Activos" itemValue="4"/>
                                            </h:selectOneMenu>
                                        </div>
                                        <div class="form-group">
                                            <h:inputText value="#{beanRegistroServicios.valorBuscado}"
                                                         styleClass="form-control"/>
                                            <p class="help-block">Introduzca el valor a buscar.</p>
                                        </div>
                                        <h:commandButton value="BUSCAR" styleClass="btn btn-primary"
                                                         action="#{beanRegistroServicios.obtenerLista}"/>
                                    </h:form>
                                </div>
                                <!--/.panel-body-->
                            </div>
                            <!--/.panel-->
                        </div>
                        <!--/.col-lg-6-->
                        <!--Resultados-->
                        <div class="col-lg-6">
                            <div class="panel panel-default">
                                <div class="panel-heading">Consulta</div>
                                <table class="table">
                                    <tr>
                                        <th>Codigo</th>
                                        <th>Descripcion</th>
                                        <th>Tipo</th>
                                        <th>Precio</th>
                                        <th>Estado</th>
                                        <th></th>
                                    </tr>
                                     
                                    <%         
                    beanRegistroServicios servicioBean = new beanRegistroServicios();//Instancia del beans
                    
                    
                     //metodo que llena la lista
                    
                    LinkedList<Servicio> lista = new LinkedList<Servicio>();// ArrayList
                    
                    lista = servicioBean.getListaServicios(); //Se llena la lista
                    
                    for (int i=0;i<lista.size();i++){
                       out.println("<tr id='t"+lista.get(i).getID()+"'>");
                       out.println("<td>"+lista.get(i).getID()+"</td>");
                       out.println("<td>"+lista.get(i).getDescripcion()+"</td>");
                       out.println("<td>"+lista.get(i).getTipo().getDescripcion()+"</td>");
                       out.println("<td>"+lista.get(i).getPrecioPorHora()+"</td>");
                       String estado="";
                       if(lista.get(i).isEstado()==true){estado="Activo";}
                       else{estado="Inactivo";}

                       out.println("<td>"+estado+"</td>");
                       out.println("<td align='center'>"+"<button type='button' class='btn btn-primary' onclick='editar(t"+lista.get(i).getID()+")'>EDITAR</button></td>");
                       out.println("</tr>");
                    }
                     %>
                                </table>
                                <!--/.panel-body-->
                            </div>
                            <!--/.panel-->
                        </div>
                        <!--/.col-lg-6-->
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