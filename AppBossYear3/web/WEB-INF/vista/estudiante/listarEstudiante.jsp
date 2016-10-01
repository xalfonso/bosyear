<%-- 
    Document   : listarGrupo
    Created on : Feb 23, 2015, 10:38:20 AM
    Author     : Leydis & Eduardo
--%>
<%@include file="/WEB-INF/vista/comun/cabecera-menu.jsp"%>
<%
    /*Trabajo con los mensajes*/
    Object valor1 = pageContext.getRequest().getAttribute("isDatosActualizados");
    boolean isDatosActualizados = (Boolean) valor1;
    String display = "none";
    if (isDatosActualizados) {
        display = "";
    }
    /*End Trabajo con los mensajes*/
%>
<script type="text/javascript">
    /*Definicion del Titulo de la Pagina*/
    var tituloPagina = "Listar Estudiante";
    document.getElementsByTagName("title")[0].innerHTML = tituloPagina;
</script> 
<div style='display: <%=display%>' id="divMensajeSucessos">
    <div class="alert alert-success" id="alertaMensajeSucesses">
        <strong>¡Felicidades!</strong> <s:message code="actualizacion.satisfactoria" arguments="estudiante"/> 
    </div>
</div>
<div class="page-header">
    <h1>Estudiantes</h1>
</div>
<div class="table-responsive">
    <table class="table table-bordered">

        <thead>
            <tr>
                <th>Primer Nombre</th>
                <th>Segundo Nombre</th>
                <th>Primer Apellido</th>
                <th>Segundo Apellido</th>
                <th>Grupo</th>
                <th>A&ntilde;o</th>
                <th>Editar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="estudiante" items="${estudiantes}">
                <tr>
                    <td>${estudiante.primerNombre}</td>
                    <td>${estudiante.segundoNombre}</td>
                    <td>${estudiante.primerApellido}</td>
                    <td>${estudiante.segundoApellido}</td>
                    <td>${estudiante.grupo.nombre}</td>
                    <td>${estudiante.grupo.year}</td>
                    <td><a href='<s:url value="/estudiante/editar"> <s:param value="${estudiante.id}" name="id"></s:param></s:url>' >
                            <span class="glyphicon glyphicon-edit"/>
                        </a>
                    </td>
                        </tr>  
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="/WEB-INF/vista/comun/footer.jsp"%>