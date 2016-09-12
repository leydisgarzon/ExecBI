/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//class employee{}...

class Address{
constructor(city, street, number){
        this.city = city;
        this.number = number;
        this.street = street; 
    }
}

class Familiar{
constructor(id,name, telephone, relation, address) {
        this.name = name;
        this.telephone = telephone;
        this.relation = relation;
        this.address = address;
        this.id = id;
    }
}

class Office{
    constructor(id){
        this.id = id;
    }
}

class Employee{
    //constructor(telephone,dni,name,job,birthday,dateIn,salary,speedWrite,officeId,address){
    constructor(){
        this.familiars = [];
        var telephone;//this.telephone = telephone;
        var dni;//this.dni = dni;
        var name;//this.name = name;
        var job//this.job = job;
        var birthday;//this.birthday = birthday;
        var dateIn;//this.dateIn = dateIn;
        var salary;//this.salary = salary;
        var speedWrite;//this.speedWrite = speedWrite;
        this.office = new Office("");//this.officeId = officeId;
        this.address = new Address("","","") ;//this.address = address;
    }
    
    addFamiliar(familiar){
        if (this.familiars.length == 0)
            createTable();
        this.familiars.push(familiar);
        addToTable(familiar);
        console.log(this.familiars);
    }
    
    deleteFamiliar(idDel){
        //eliminar familiar de array familiars
        for(var i=0; i<this.familiars.length; i++){
            if(this.familiars[i].id == idDel)
                this.familiars.splice(i, 1);
        }
        console.log(this.familiars);
    }
    
}


var employee = new Employee(); 

$(document).ready(function () {
    $("#emAdmin").mouseup(function () {
        // Enable write speed input
        $("#emAdmin").prop("checked") ? $("#emSpeed").prop("disabled", "true") : $("#emSpeed").prop("disabled", null);
    });

    $("#addFamiliar").click(createFamiliar);
    
    $("#resetFamiliar").click(function(){
        $("#fmData input").val("");   
    });

    $("#listFamiliars").on("click", "a", function(){
        employee.deleteFamiliar($(this).closest("tr").find('td:first').text());
        $(this).closest("tr").remove();
        if($("#listFamiliars tbody").has("tr").length === 0)
        $("#tbFamiliars").remove();
    });
    
    $("#addEmployee-form").submit(function(event) {
                       
        // Disble the search button
    //    enableInsertButton(false);

        // Prevent the form from submitting via the browser.
        event.preventDefault();
        
        insertViaAjax();

    });
});


function createFamiliar(){
    var address = new Address($("#fmCity").val(), $("#fmStreet").val(), $("#fmNumber").val());
    var familiar = new Familiar(new Date().getTime(),$("#fmName").val(), $("#fmTel").val(), $("#fmRelation").val(), address);
    employee.addFamiliar(familiar);
}

function createTable(){
    var table = "<table id='tbFamiliars' class='table table-striped table-responsive'><thead><tr>" +
                "<th>Name</th><th>Relation</th><th>Telephone</th><th>City</th><th>Streets</th>" +
                "<th>Number</th></tr></thead><tbody></tbody></table>";
    $("#listFamiliars").append(table);
}

function addToTable(familiar){
    var td = "<tr><td id='fieldId'  class='hidden'>" + familiar.id + "</td>"+
                 "<td>" + familiar.name + "</td>" +
                 "<td>" + familiar.relation + "</td>" +
                 "<td>" + familiar.telephone + "</td>" +
                 "<td>" + familiar.address.city + "</td>" +
                 "<td>" + familiar.address.street + "</td>" +
                 "<td>" + familiar.address.number + "</td>"+
                 "<td><a> delete </a></td></tr>";
    $("#listFamiliars tbody").append(td);  
}

function insertViaAjax() {
    employee.name = $("#emName").val();
    employee.dni = $("#emDni").val();
    employee.telephone = $("#emTelephone").val();
    employee.birthday = $("#embirthday").val();
    employee.dateIn = $("#emInDate").val();
    employee.job = $("#emJob").val();
    employee.salary = $("#emSalary").val();
    employee.speedWrite = $("#emSpeed").val();
    employee.address.city = $("#emCity").val();
    employee.address.number = $("#emNumber").val();
    employee.address.street = $("#emStreet").val();
    employee.office.id = $("#emOffice").val();
    var url = $("#rutaBase").val() + "employee/add";


    $.ajax({
            type : "POST", 
            contentType : "application/json",
            url : url,
            data : JSON.stringify(employee),
            dataType : 'json',
            timeout : 100000,
            success : function(data) {
                    console.log("SUCCESS: ");
                    display(data);
            },
            error : function(e) {
                    console.log("ERROR: ", e);
                   // display(e);
            },
            done : function(e) {
                    console.log("DONE");
                    enableSearchButton(true);
            }
    });
    
    function display(data) {
        var cssMessaje= "alert ";
        var headerMessaje;
        switch (data.type){
            case 0:
               cssMessaje = cssMessaje + "alert-danger";
               headerMessaje = "¡Error!";
               break;
            case 1:
                cssMessaje = cssMessaje + "alert-warning";
                headerMessaje = "¡Warning!";
                break;
            case 2:
                cssMessaje = cssMessaje + "alert-info";
                headerMessaje = "¡Ok!";
                break;
        }
        
        
	var msg = " <div class='" + cssMessaje + "' id='alertaMensaje'><strong>" + headerMessaje + "</strong>" + data.message + " " + JSON.stringify(data, null, 4) + "</div>" ;
	$('#id_divMessaje').html(msg);
                    
	}

}
