<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
            <link rel="stylesheet" type="text/css" href="recursos/diseñoIngreso.css"></link>
        </head>
        <body>
            <div id="head">
                <h1>
                    <h:outputText value="Registro Servicios"/>
                </h1>
            </div>
            <div id="main">
                <h:form>
                    <table>
                        <tr>
                            <td>
                                <h:outputText value="Descripcion:"/>
                            </td>
                            <td>
                                <h:inputText/>
                            </td>
                        </tr>
                         
                        <tr>
                            <td>
                                <h:outputText value="Tipo Servicio"/>
                            </td>
                            <td>
                                <h:selectOneMenu>
                                    <f:selectItem itemLabel="Financieros" itemValue="Financieros"/>
                                    <f:selectItem itemLabel="Mecanicos" itemValue="Mecanicos"/>
                                    <f:selectItem itemLabel="Tecnicos" itemValue="Tecnicos"/>
                                    <f:selectItem itemLabel="Construccion" itemValue="Construccion"/>
                                    <f:selectItem itemLabel="Reclutamiento" itemValue="Reclutamiento"/>
                                </h:selectOneMenu>
                            </td>
                        </tr>
                         
                        <tr>
                            <td>
                                <h:outputText value="Precio por hora:"/>
                            </td>
                            <td>
                                <h:inputText/>
                            </td>
                        </tr>
                         
                        <tr>
                            <td>
                                <h:outputText value="Estado:"/>
                            </td>
                            <td>
                                <h:selectBooleanCheckbox label="Activo"/>
                            </td>
                        </tr>
                        <tr>
                        <td colspan="2">
                                <h:commandButton value="Registrar"/>
                            </td>
                        </tr>
                    </table>
                </h:form>
            </div>
        </body>
    </html>
</f:view>