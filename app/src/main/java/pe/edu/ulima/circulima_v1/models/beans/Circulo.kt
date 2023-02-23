package pe.edu.ulima.circulima_v1.models.beans

class Circulo {
    var ID: String
    var NOMBRE : String
    var DESCRIPCION : String
    var CARRERA : String

    constructor(ID: String, NOMBRE: String, DESCRIPCION: String, CARRERA : String) {
        this.ID = ID
        this.NOMBRE = NOMBRE
        this.DESCRIPCION = DESCRIPCION
        this.CARRERA = CARRERA
    }
}