/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {

		$("#addOffice-form").submit(function(event) {
                       
			// Disble the search button
			enableInsertButton(false);

			// Prevent the form from submitting via the browser.
			event.preventDefault();
                        

			insertViaAjax();

		});

	});

	function insertViaAjax() {

		var insert = {};
		insert["name"] = $("#name").val();
		insert["telephone"] = $("#telephone").val();
                insert["fax"] = $("#fax").val();
                //var url = $("#rutaBase").val() + "insert/office/getInsertResult";
                var url = $("#rutaBase").val() + "addOffice";
                
                
		$.ajax({
			type : "POST", 
			contentType : "application/json",
			url : url,
			data : JSON.stringify(insert),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
				enableSearchButton(true);
			}
		});

	}

	function enableInsertButton(flag) {
		$("#btn-addOffice").prop("disabled", flag);
	}

	function display(data) {
		var json = "<h4>Ajax Response</h4><pre>"
				+ JSON.stringify(data, null, 4) + "</pre>";
		$('#response').html(json);
	}
