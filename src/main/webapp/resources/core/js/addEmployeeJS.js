/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $("#emAdmin").mouseup(function () {
        // Enable write speed input
        $("#emAdmin").prop("checked") ? $("#emSpeed").prop("disabled","true" ) : $("#emSpeed").prop("disabled",null );
    });

});

