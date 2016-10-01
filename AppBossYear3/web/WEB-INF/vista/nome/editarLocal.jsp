<%-- 
    Document   : editarLocal
    Created on : Feb 28, 2015, 10:54:17 AM
    Author     : Leydis & Eduardo
--%>

<%@include file="/WEB-INF/vista/comun/cabecera-menu.jsp"%>
<%
    /*Trabajo con los mensajes de error*/
    Object valor1 = pageContext.getRequest().getAttribute("isProblemaActualizacion");
    boolean isProblemaActualizacion = (Boolean) valor1;
    String displayError = "none";
    if (isProblemaActualizacion) {
        displayError = "";
    }
    /*End Trabajo con los mensajes de error*/
%>
<script type="text/javascript">
    /*Definicion del Titulo de la Pagina*/
    var tituloPagina = "Editar Local";
    document.getElementsByTagName("title")[0].innerHTML = tituloPagina;
</script> 
<div style='display: <%=displayError%>' id="divMensajeError">
    <div class="alert alert-danger" id="alertaMensajeError">
        <strong>¡Opp!</strong> <s:message code="actualizacion.error" arguments="local"/>
    </div>
</div>

<div class="page-header">
    <h1>Editar Local</h1>
</div>
    <f:form role="form" method="post" commandName="local">
        <div class="form-group">                
            <label for="inp_nombre">Nombre</label>
            <f:input path="nombre" placeholder="nombre" id="inp_nombre" class="form-control"/>
            <f:hidden path="id" />
        </div>        
        <button type="submit" class="btn btn-success">Aceptar</button>
        <button type="reset" class="btn btn-warning">Cancelar</button>
    </f:form>
<%@include file="/WEB-INF/vista/comun/footer.jsp"%>



