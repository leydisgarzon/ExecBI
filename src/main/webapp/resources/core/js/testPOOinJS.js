/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//alert("I'm in");

        class Animal {
        constructor(nombre) {
        this.nombre = nombre;
        }

        hablar() {
        console.log(this.nombre + ' hace un ruido.');
        }
        }

        class Perro extends Animal {
        hablar() {
        super.hablar();
        console.log(this.nombre + ' ladra.');
        }
        }

        var p = new Perro('Mitzie');
        p.hablar();
