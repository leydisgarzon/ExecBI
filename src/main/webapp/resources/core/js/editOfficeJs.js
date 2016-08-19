/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#list_offices").change(function () {
       // alert("select had changed" + $("#list_offices").val());
        insertViaAjax();
        /*
         if($("#checkbox").prop("checked")=== false){   
         $("#mgData").prop("disabled",null);
         //$("#mgData").removeAttr("disabled");
         $("#mgList").prop("disabled","true");
         }
         else{
         $("#mgData").prop("disabled","true");
         $("#mgList").prop("disabled",null)
         }*/
    });

    function insertViaAjax() {

        /*var insert = {};
        insert["id"] = $("#list_offices").val();
        insert["name"] = "not";
	insert["telephone"] = 15478;
        insert["fax"] = 789788;*/
        //var url = $("#rutaBase").val() + "insert/office/getInsertResult";
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
		var json = //"<h4>Ajax Response</h4><pre>"+ 
                        JSON.stringify(data, null, 4) 
                        //+ "</pre>"
                        ;
		//$('#feedback').html(json);
                $('#office_name').val(data.result['name']);
                $('#office_tel').val(data.result['telephone']);
                $('#office_fax').val(data.result['fax']);
                $('#office_city').val(data.result['address']['city']);
                $('#office_street').val(data.result['address']['street']);
                $('#office_number').val(data.result['address']['number']);
                $('#office_manager').val(data.result['manager']['name']);
                
	}

});