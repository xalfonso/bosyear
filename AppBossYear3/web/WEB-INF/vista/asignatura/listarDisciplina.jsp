<%-- 
    Document   : listarDisciplina
    Created on : Feb 27, 2015, 9:41:18 PM
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
    var tituloPagina = "Listar Disciplina";
    document.getElementsByTagName("title")[0].innerHTML = tituloPagina;
</script> 
<div style='display: <%=display%>' id="divMensajeSucessos">
    <div class="alert alert-success" id="alertaMensajeSucesses">
        <strong>¡Felicidades!</strong> <s:message code="actualizacion.satisfactoria" arguments="disciplina"/> 
    </div>
</div>
<div class="page-header">
    <h1>Disciplinas</h1>
</div>
<div class="table-responsive">
    <table class="table table-bordered">

        <thead>
            <tr>
                <th>Nombre</th>
                <th>Editar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="disciplina" items="${disciplinas}">
                <tr>
                    <td>${disciplina.nombre}</td>
                    <td><a href='<s:url value="/disciplina/editar"><s:param value="${disciplina.id}" name="id"></s:param></s:url>'><span class="glyphicon glyphicon-edit"/></a></td>
                        </tr>  
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="/WEB-INF/vista/comun/footer.jsp"%>

