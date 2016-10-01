/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var $btnIncluir;
var $inpNombre;
//var $selectGrup;
var $inpAsignatura;

$(document).ready(function() {
    /*Ajax*/
    $btnIncluir = $('#btn_incluir');
    $inpNombre = $('#inp_nombre');
    //$selectGrup = $('#inp_grupo');
    //$inpAsignatura = $('#inp_asignatura');

    if ($btnIncluir.length)
        $btnIncluir.click(incluirTabla);
    /*End Ajax*/

    });

function incluirTabla() {

    if (window.confirm('¿Desea agregarlo?'))
    {
        var fila = window.document.createElement("tr");
        var tabla = window.document.getElementById("tabla_incluir");
        
        //celda del nombre
        var celdaNombre = window.document.createElement("td");
        var nomb = document.getElementById('inp_nombre');
        var nombNode = window.document.createTextNode(nomb.value);

        //lo guardo en un campo oculto para poder tomarlo con una variable (guardo el id que es lo importante para obtenerlo de la BD)
        celdaNombre.innerHTML = "<input type='hidden' value='" + nomb.value + "' name='estudiantes' >";
        celdaNombre.appendChild(nombNode);

        //agregar a la fila la celda
        fila.appendChild(celdaNombre);
        //End celda del nombre
        
        //celda del grupo
       // var celdaGrupo = window.document.createElement("td");
        //var grup = document.getElementById('inp_grupo');
        //var grupNode = window.document.createTextNode(grup.text);

        //lo guardo en un campo oculto para poder tomarlo con una variable (guardo el id que es lo importante para obtenerlo de la BD)
        //celdaGrupo.innerHTML = "<input type='hidden' value='" + grup.value + "' name='Grupos[]' >";
        //celdaGrupo.appendChild(grupNode);

        //agregar a la fila la celda
        //fila.appendChild(celdaGrupo);
        //End celda del grupo
        
        
        //agrego la fila a la tabla
        tabla.appendChild(fila);
        
        var fila2 = window.document.createElement("tr");
        var tabla2 = window.document.getElementById("tabla_asig");
        
        //celda del nombre
        var celdaAsig = window.document.createElement("td");
        var asig = document.getElementById('inp_asig');
        var asigNode = window.document.createTextNode(asig.value);

        //lo guardo en un campo oculto para poder tomarlo con una variable (guardo el id que es lo importante para obtenerlo de la BD)
        celdaAsig.innerHTML = "<input type='hidden' value='" + asig.value + "' name='asignaturas' >";
        celdaAsig.appendChild(asigNode);

        //agregar a la fila la celda
        fila2.appendChild(celdaAsig);
        //End celda del nombre
        tabla2.appendChild(fila2);
    }
}