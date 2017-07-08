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
                <h:outputText value="Autencion de sesion de usuario fallida. Por favor, vuelva a intentarlo."/>
            </p>
            <p>
                <h:outputLink>
                    <h:outputText value="Regresar"/>
                </h:outputLink>
            </p>
        </body>
    </html>
</f:view>