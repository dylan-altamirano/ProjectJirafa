<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
        </head>
        <body>
            <p>
                <h:outputText value="SISE"/>
                 &nbsp;
            </p>
            <p>
                <h:outputText value="Sistema para Gestion de Servicios"/>
            </p>
            <p>
                <h:outputLink>
                    <h:outputText value="Catalogo de Servicios"/>
                </h:outputLink>
            </p>
            <p>
                <h:outputLink>
                    <h:outputText value="Administracion de Clientes"/>
                </h:outputLink>
            </p>
            <p>
                <h:outputLink>
                    <h:outputText value="Registro de Solicitudes de Ordenes de Servicio"/>
                </h:outputLink>
            </p>
            <h:outputLink>
                <h:outputText value="Facturacion"/>
            </h:outputLink>
        </body>
    </html>
</f:view>