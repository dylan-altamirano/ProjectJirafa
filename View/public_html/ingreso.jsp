<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
            <title>Ingreso</title>
            <link rel="stylesheet" type="text/css" href="../recursos/diseñoIngreso.css"
        </head>
        <body>
        
        <div id="head" style="text-align:center">
            <h1>Ingreso</h1>
        </div>
        
        <div id="main">
        <h:form>
            <table align="center" width="338">
            <tr><td>Nombre de usuario:<td><h:inputText/></td></td></tr>
            <tr><td>Contraseña:<td><h:inputSecret/></td></td></tr>
            <tr><td align="center"> <h:commandButton value="Ingresar" action="bien"/></td></tr>
            </table>
            </h:form>
        </div>
        
        <div id="footer" style="margin-top:36%; text-align:right;">
            <p>Copyrights SISE 2017</p>
        </div>
            
        </body>
    </html>
</f:view>