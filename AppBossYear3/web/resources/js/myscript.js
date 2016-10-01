/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var $mensajeSucesses;
var $mensajeError;
$(document).ready(function() {

    /*Animacion de Mensaje de alertas*/
    $mensajeSucesses = $('#alertaMensajeSucesses');
    if ($mensajeSucesses.length)
        $mensajeSucesses.show(200).delay(3000).hide(600);

    /*End Animacion de Mensaje de alertas*/
    
    /*Animacion de Mensaje de error*/
    $mensajeError = $('#alertaMensajeError');
    if ($mensajeError.length)
        $mensajeError.show(200).delay(3000).hide(600);

    /*End Animacion de Mensaje de alertas*/





})


