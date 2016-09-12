/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*class Address{
constructor(city, streets, number){
        this.city = city;
        this.number = number;
        this.streets = streets; 
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

class Employee{
    //var familiars = [];
    constructor(){
        this.familiars = [];
    }
    
    addFamiliar(familiar){
        if (this.familiars.length == 0)
            createTable();
        this.familiars.push(familiar);
        addToTable(familiar);
        console.log(this.familiars);
    }
    
    
}*/


/*var familiars = []; //new Array();

function createFamiliar(){
    var address = new Address($("#fmCity").val(), $("#fmStreet").val(), $("#fmNumber").val());
    var familiar = new Familiar(new Date().getTime(),$("#fmName").val(), $("#fmTel").val(), $("#fmRelation").val(), address);
    employee.addFamiliar(familiar);
}

function addFamiliar(){
    var address = new Address($("#fmCity").val(), $("#fmStreet").val(), $("#fmNumber").val());
    var familiar = new Familiar(new Date().getTime(),$("#fmName").val(), $("#fmTel").val(), $("#fmRelation").val(), address);
    if (familiars.length == 0)
        createTable();
    familiars.push(familiar);
    addToTable(familiar);
    console.log(familiars);
   
}

function deleteFamiliar(idDel){
    //eliminar familiar de array familiars
    for(var i=0; i<familiars.length; i++){
        if(familiars[i].id == idDel)
            familiars.splice(i, 1);
    }
    console.log(familiars);
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
                 "<td>" + familiar.address.streets + "</td>" +
                 "<td>" + familiar.address.number + "</td>"+
                 "<td><a> delete </a></td></tr>";
    $("#listFamiliars tbody").append(td);
    
}

/*function delFromTable(){
    $(this).closest("tr").remove();
    if($("#listFamiliars tbody").has("tr").length == 0)
        $("#tbFamiliars").remove();
    
}*/






