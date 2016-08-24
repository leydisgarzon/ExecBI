/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#list_offices").change(insertViaAjax);
});

function insertViaAjax() {
    var id = $("#list_offices").val();
    var url = $("#rutaBase").val() + "office/edit/editOffice";
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: url,
        data: id,
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            display(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done: function (e) {
            console.log("DONE");
            enableSearchButton(true);
        }
    });

}

function display(data) {
    $('#office_name').val(data.result['name']);
    $('#office_tel').val(data.result['telephone']);
    $('#office_fax').val(data.result['fax']);
    $('#office_city').val(data.result['address']['city']);
    $('#office_street').val(data.result['address']['street']);
    $('#office_number').val(data.result['address']['number']);
    $('#office_manager').val(data.result['manager']['name']);
    $('#addressId').val(data.result['address']['id']);
    
    /*
    //para adicionar elementos html
    var $selec = $('<option />', {id: 'select' + this.begin + "_" + this.end + "_" + this.unit, value: this.begin + "_" + this.end + "_" + this.unit});
    $selec.appendTo("#list_offices")
    //para manipular el elemento creado
    $selec.prop('selected',true)*/
}   