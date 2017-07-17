<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
            <link rel="stylesheet" type="text/css" href="recursos/css/diseñoIngreso.css"></link>
        </head>
        <body>
            <div id="header">
                <h1>
                    <h:outputText value="SISE"/>
                </h1>
                 
                <h2>
                    <h:outputText value="Sistema para Gestion de Servicios"/>
                </h2>
            </div>
            <div id="nav">
                <ul id="nav-list">
                    <li>
                        <h:outputLink value="RegistroServicios.jsp">
                            <h:outputText value="Catalogo de Servicios"/>
                        </h:outputLink>
                    </li>
                     
                    <li>
                        <h:outputLink>
                            <h:outputText value="Administracion de Clientes"/>
                        </h:outputLink>
                    </li>
                     
                    <li>
                        <h:outputLink>
                            <h:outputText value="Registro de Ordenes de Servicio"/>
                        </h:outputLink>
                    </li>
                     
                    <li>
                        <h:outputLink>
                            <h:outputText value="Facturacion"/>
                        </h:outputLink>
                    </li>
                </ul>
            </div>
            <div id="main"></div>
        </body>
    </html>
</f:view>