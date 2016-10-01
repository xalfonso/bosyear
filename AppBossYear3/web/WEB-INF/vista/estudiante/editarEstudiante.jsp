<%-- 
    Document   : editarEstudiante
    Created on : Feb 26, 2015, 10:06:34 PM
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
    var tituloPagina = "Editar Estudiante";
    document.getElementsByTagName("title")[0].innerHTML = tituloPagina;
</script> 
<div style='display: <%=displayError%>' id="divMensajeError">
    <div class="alert alert-danger" id="alertaMensajeError">
        <strong>¡Opp!</strong> <s:message code="actualizacion.error" arguments="estudiante"/>
    </div>
</div>

<div class="page-header">
    <h1>Editar Estudiante</h1>
</div>
<f:form role="form" method="post" commandName="estudiante" id="idformEstudiante">
    <div class="form-group">                
        <label for="inp_primernombre">Primer Nombre</label>
        <f:input path="primerNombre" placeholder="primer nombre" id="inp_primernombre" class="form-control"/> 
        <f:hidden path="id" />
    </div>
    <div class="form-group">                
        <label for="inp_segundonombre">Segundo Nombre</label>
        <f:input path="segundoNombre" placeholder="segundo nombre" id="inp_segundonombre" class="form-control"/>            
    </div>
    <div class="form-group">                
        <label for="inp_primerapellido">Primer Apellido</label>
        <f:input path="primerApellido" placeholder="primer apellido" id="inp_primerapellido" class="form-control"/>            
    </div>
    <div class="form-group">                
        <label for="inp_segundoapellido">Segundo Apellido</label>
        <f:input path="segundoApellido" placeholder="segundo apellido" id="inp_segundopellido" class="form-control"/>            
    </div>
    <div class="form-group">                
        <label for="inp_grupo">Grupo</label>
        <f:select id="inp_grupo" path="grupo.id" items="${grupos}" itemLabel="nombre" itemValue="id" cssClass="form-control"/>        
    </div>
    <button type="submit" class="btn btn-success">Aceptar</button>
    <button type="reset" class="btn btn-warning">Cancelar</button>
</f:form>
<%@include file="/WEB-INF/vista/comun/footer.jsp"%>

