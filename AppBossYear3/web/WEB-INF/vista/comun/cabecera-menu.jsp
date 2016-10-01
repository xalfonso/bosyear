<%-- 
    Document   : cabecera
    Created on : Feb 20, 2015, 10:12:12 PM
    Author     : Leydis & Eduardo
--%>

<%@include file="/WEB-INF/vista/comun/directivas.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">      
        <link rel="shortcut icon" href='<s:url value="/resources/ico/favicon.png"/>'/>       
        <title>Theme Template for Bootstrap</title>

        <!-- Bootstrap core CSS resources/css/bootstrap.min.css-->      
        <link href='<s:url value="/resources/css/bootstrap.min.css"/>' rel="stylesheet" type="text/css"/>

        <!-- Bootstrap theme -->
        <link href="<s:url value="/resources/css/bootstrap-theme.min.css"/>" rel="stylesheet" type="text/css"/>

        <!-- Custom styles for this template -->
        <link href='<s:url value="/resources/css/theme.css"/>' rel="stylesheet"/>

    </head>
    <body>
        <!-- Apertura del Div del Contenido -->
        <div class="container theme-showcase"> 
            <%@include file="/WEB-INF/vista/comun/menu.jsp"%>