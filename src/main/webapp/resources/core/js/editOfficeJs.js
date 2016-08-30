/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#idformOffice").find('input, button, select').focus(function () {
        //if ($('#id_divMessaje').index() !== -1) {
        $('#id_divMessaje').remove();
        //}
    });

    validation();
    $("#list_offices").change(insertViaAjax);
});

$.validator.addMethod('letters', function (value, element) {
    return this.optional(element) || /^[a-z' ]+$/i.test(value);
}, 'solo letras o apostrofe');

function validation() {
    $("#idformOffice").validate({
        rules: {
            name: {
                required: true,
                letters: true
            },
            telephone: {
                required: true,
                digits: true
            },
            fax: {
                digits: true
            },
            'address.number': {
                required: true,
                digits: true
            },
            'address.city': {
                required: true,
                lettersonly: true
            },
            'address.street': "required"
        },
        messages: {
            name: {
                required: "Este campo es obligatorio",
                lettersonly: "Solo letras"
            },
            telephone: {
                required: "Debe llenar este campo",
                digits: 'Solo digitos'
            },
            fax: {
                digits: 'Solo digitos'
            }
            ,
            'address.number': {
                digits: 'Solo digitos'
            },
            'address.street': {
                required: 'Ponga la direcc exacta'
            }
        }
    });
}
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