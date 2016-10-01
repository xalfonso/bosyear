<%-- 
    Document   : estudianteAsignatura
    Created on : 09-abr-2015, 9:50:08
    Author     : Leydis & Eduardo Alfonso
--%>
<%@include file="/WEB-INF/vista/comun/cabecera-menu.jsp"%>
<script type="text/javascript">
    /*Definicion del Titulo de la Pagina*/
    var tituloPagina = "Incluir Estudiante";
    document.getElementsByTagName("title")[0].innerHTML = tituloPagina;
</script> 
<f:form commandName="probando" method="POST">
    <table id="tabla_incluir">

        <%--! <tr>
             <th>Estudiante</th>
             <th>Grupo</th>
             <th>Asignatura</th>
         </tr>--%>
        <tr>

            <%-- Approach 2: Property is of an array or of type java.util.Collection --%>
            <td>
                Arturo: <f:hidden path="estudiantes" value="Arturo"/>               

            </td>
        </tr>
        <tr>
            <td>               
                Angel: <f:hidden path="estudiantes" value="Angel"/>
            </td>
        </tr>

    </table>
    <div class="form-group">                
        <label for="inp_nombre">Nombre</label>
        <input placeholder="nombre" id="inp_nombre" class="form-control"/>            
    </div>      
                <input type="button" id="btn_incluir" class="btn btn-success" value="Incluir"></input>
    <f:form  commandName="proban2" method="POST">
      <table id="tabla_asig">  
        <tr>
            <td>               
                Fisica: <f:hidden path="asignaturas" value="Fisica"/>
            </td>
        </tr>
        <tr>
            <td>               
                Fisica: <f:hidden path="asignaturas" value="Fisica"/>
            </td>
        </tr>
      </table>
        <div class="form-group">                
            <label for="inp_asig">Asignatura</label>
            <input placeholder="asignatura" id="inp_asig" class="form-control"/>            
        </div>
   
    </f:form>
                <button type="submit" class="btn btn-success">Aceptar</button>       
</f:form>
        
<%@include file="/WEB-INF/vista/comun/footer.jsp"%>