
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="appProyecto.view.beanRegistroOrdenServicio"%>
<%@ page import="appProyecto.model.Servicio"%>
<%@ page import="appProyecto.model.ServicioDB"%>
<%@ page import="appProyecto.model.TipoServicio"%>
<%@ page import="utilidades.conversion"%>
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
            <!--FCUNCION JAVA SCRIPT PARA EXTRAER LOS VALORES DE LA TABLA-->
            <script type="text/javascript">
              function editar(objeto) {

                  var codigo = document.getElementById("registro:txtCodigo");
                  codigo.value = objeto.cells[0].childNodes[0].nodeValue;

                  var descripcion = document.getElementById('registro:txtDescripcion');
                  descripcion.value = objeto.cells[1].childNodes[0].nodeValue;

                  var tipo = document.getElementById('registro:txtTipo');
                  tipo.value = objeto.cells[2].childNodes[0].nodeValue;

                  var costo = document.getElementById('registro:txtCosto');
                  costo.value = objeto.cells[4].childNodes[0].nodeValue;

                  var estado = document.getElementById('registro:cboEstado');

                  if (objeto.cells[4].childNodes[5].nodeValue == 'Activo') {
                      estado.value = 1;
                  }
                  else {
                      estado.value = 2;
                  }

              }

              function limpiar() {
                  var codigo = document.getElementById("registro:txtCodigo");
                  codigo.value = "";

                  var descripcion = document.getElementById('registro:txtDescripcion');
                  descripcion.value = "";

                  var tipo = document.getElementById('registro:txtTipo');
                  tipo.value = "";

                  var costo = document.getElementById('registro:txtCosto');
                  costo.value = "";

                  var estado = document.getElementById('registro:cboEstado');
                  estado = "";
              }
            </script>
        </head>
        <body>
            <!--main container-->
            <div id="wrapper">
                <!-- Navigation -->
                <div class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
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
                </div>
                <div id="page-wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                <h:outputText value="Servicio"/>
                            </h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="panel panel-default">
                                <div class="panel-heading">Seleccion del Servicio a contratar</div>
                                <div class="panel-body">
                                    <h:form id="registro">
                                        <div class="form-group">
                                            <label>
                                                <h:outputText value="Identificador:"/>
                                            </label><h:inputText id="txtCodigo"
                                                                 value="#{beanRegistroOrdenServicio.codigo}"
                                                                 styleClass="form-control" readonly="true"/>
                                            <p class="help-block">Introduzca una identificaci&oacute;n para el servicio.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <h:outputText value="Descripcion:"/>
                                            </label><h:inputText id="txtDescripcion"
                                                                               value="#{beanRegistroOrdenServicio.descripcion}"
                                                                               styleClass="form-control"
                                                                               readonly="true"/>
                                            <p class="help-block">Introduzca una breve descripci&oacute;n del servicio.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <h:outputText value="Tipo Servicio"/>
                                            </label><h:inputText id="txtTipo"
                                                                 value="#{beanRegistroOrdenServicio.tipoServicio}"
                                                                 styleClass="form-control" readonly="true"/>
                                        </div>
                                        <div class="form-group input-group">
                                            <span class="input-group-addon">$</span><h:inputText styleClass="form-control"
                                                                                                 id="txtCosto"
                                                                                                 value="#{beanRegistroOrdenServicio.costo}"/>
                                             
                                            <span class="input-group-addon">.00</span>
                                        </div>
                                        <div class="form-group">
                                            <label>
                                                <h:outputText value="Estado:"/>
                                            </label><h:selectOneMenu id="cboEstado"
                                                                     value="#{beanRegistroOrdenServicio.estado}"
                                                                     styleClass="form-control">
                                                <f:selectItem itemLabel="Activo" itemValue="1"/>
                                                <f:selectItem itemLabel="Inactivo" itemValue="0"/>
                                            </h:selectOneMenu>
                                        </div>
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
                                    <h:form id="busqueda">
                                        <div class="form-group">
                                            <label>
                                                <h:outputText value="Buscar por:"/>
                                            </label><h:selectOneMenu styleClass="form-control"
                                                                     value="#{beanRegistroOrdenServicio.opcionFiltrado}">
                                                <f:selectItem itemLabel="--Seleccione uno--" itemValue="0"/>
                                                <f:selectItem itemLabel="Identificador" itemValue="1"/>
                                                <f:selectItem itemLabel="Nombre" itemValue="2"/>
                                                <f:selectItem itemLabel="Tipo" itemValue="3"/>
                                                <f:selectItem itemLabel="Estado" itemValue="4"/>
                                            </h:selectOneMenu>
                                        </div>
                                        <div class="form-group">
                                            <h:inputText id="txtValorBuscado"
                                                         value="#{beanRegistroOrdenServicio.valorBuscado}"
                                                         styleClass="form-control"/>
                                            <p class="help-block">Introduzca el valor a buscar.</p>
                                        </div>
                                        <h:commandButton value="BUSCAR" id="cmdBuscar"
                                                         action="#{beanRegistroOrdenServicio.obtenerLista}"
                                                         styleClass="btn btn-primary"/>
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
                                <h:form id="resultados">
                                    <table class="table" style="table-layout:fixed;" cellspacing="1" cellpadding="2">
                                        <tr>
                                            <th>Codigo</th>
                                            <th>Descripcion</th>
                                            <th>Tipo</th>
                                            <th>Precio</th>
                                            <th>Estado</th>
                                            <th></th>
                                        </tr>
                                         
                                        <%         
                                beanRegistroOrdenServicio servicioBean = new beanRegistroOrdenServicio();//Instancia del beans
                                
                                
                                 //metodo que llena la lista que procede del bean
                                
                                LinkedList<Servicio> lista = new LinkedList<Servicio>();// ArrayList
                                
                                lista = servicioBean.getListaServicios(); //Se llena la lista
                                
                                for (int i=0;i<lista.size();i++){
                                   out.println("<tr id='t"+lista.get(i).getID()+"'>");
                                   out.println("<td style='word-wrap:break-word;'>"+lista.get(i).getID()+"</td>");
                                   out.println("<td>"+lista.get(i).getDescripcion()+"</td>");
                                   out.println("<td style='display:none;'>"+lista.get(i).getTipo().getID()+"</td>");
                                   out.println("<td>"+lista.get(i).getTipo().getDescripcion()+"</td>");
                                   out.println("<td>"+lista.get(i).getPrecioPorHora()+"</td>");
                                   String estado="";
                                   if(lista.get(i).isEstado()==true){estado="Activo";}
                                   else{estado="Inactivo";}
            
                                   out.println("<td>"+estado+"</td>");
                                   out.println("<td align='center'>"+"<button type='button' class='btn btn-primary' onclick='editar(t"+lista.get(i).getID()+")'>SELECCIONAR</button></td>");
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
                            <div class="text-primary" id="mensajeConfirmacion">
                                <h:outputText value="#{beanRegistroServicios.mensajeConfirmacion}" id="mensaje"/>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /#page-wrapper -->
            </div>
            <!-- /#wrapper -->
            <!-- /#wrapper -->
            <script type="text/javascript" src="recursos/js/jquery.js"></script>
            <script type="text/javascript" src="recursos/js/jquery.min.js"></script>
            <!-- Bootstrap Core JavaScript -->
            <script type="text/javascript" src="recursos/js/bootstrap.min.js"></script>
            <!-- Metis Menu Plugin JavaScript -->
            <script type="text/javascript" src="recursos/js/metisMenu.min.js"></script>
            <!-- Custom Theme JavaScript -->
            <script type="text/javascript" src="recursos/js/sb-admin-2.js"></script>
            <script type="text/javascript">
                  $('#registro:cmdRegistrar').click(function () {
                      $('#mensajeConfirmacion').fadeOut(5000);
                  });
            </script>
        </body>
    </html>
</f:view>