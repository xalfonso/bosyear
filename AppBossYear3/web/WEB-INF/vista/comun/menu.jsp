<%-- 
    Document   : menu
    Created on : Feb 20, 2015, 9:59:16 PM
    Author     : Leydis & Eduardo
--%>

<!-- Fixed navbar -->

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<s:url value="/home"/>'>Inicio</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href='<s:url value="/probando"/>'>Contact</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Disciplina <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href='<s:url value="/disciplina/salvar"/>'>Insertar</a></li>
                        <li><a href='<s:url value="/disciplina"/>'>Listar</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Asignatura</li>
                        <li><a href='<s:url value="/asignatura/salvar"/>'>Insertar</a></li>
                        <li><a href='<s:url value="/asignatura"/>'>Listar</a></li>                       
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">P1<b class="caret"></b></a>
                    <ul class="dropdown-menu">       
                        <li><a href='<s:url value="/semanap1/salvar"/>'>Insertar</a></li>
                        <li><a href='<s:url value="/semanap1"/>'>Listar</a></li>                       
                        <li class="divider"></li>
                        <li class="dropdown-header">Semana del P1</li>
                        <li><a href='<s:url value="/semanap1/salvar"/>'>Insertar</a></li>
                        <li><a href='<s:url value="/semanap1"/>'>Listar</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Local</li>
                        <li><a href='<s:url value="/local/salvar"/>'>Insertar</a></li>
                        <li><a href='<s:url value="/local"/>'>Listar</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Tipo de Actividad</li>
                        <li><a href='<s:url value="/tipoactividad/salvar"/>'>Insertar</a></li>
                        <li><a href='<s:url value="/tipoactividad"/>'>Listar</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Medio de Ense&ntilde;anza</li>
                        <li><a href='<s:url value="/medio/salvar"/>'>Insertar</a></li>
                        <li><a href='<s:url value="/medio"/>'>Listar</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Profesor <b class="caret"></b></a>
                    <ul class="dropdown-menu">                        
                        <li class="divider"></li>
                        <li class="dropdown-header">Categoria Cient&iacute;fica</li>
                        <li><a href='<s:url value="/categoriac/salvar"/>'>Insertar</a></li>
                        <li><a href='<s:url value="/categoriac"/>'>Listar</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Categoria Docente</li>
                        <li><a href='<s:url value="/categoriad/salvar"/>'>Insertar</a></li>
                        <li><a href='<s:url value="/categoriad"/>'>Listar</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Grupo Docente <b class="caret"></b></a>
                    <ul class="dropdown-menu">                        
                        <li><a href='<s:url value="/grupo/salvar"/>'>Insertar</a></li>
                        <li><a href='<s:url value="/grupo"/>'>Listar</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Estudiante</li>
                        <li><a href='<s:url value="/estudiante/salvar"/>'>Insertar</a></li>
                        <li><a href='<s:url value="/estudiante"/>'>Listar</a></li>
                    </ul>
                </li>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
