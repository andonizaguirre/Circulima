package pe.edu.ulima.circulima_v1.models.beans

import java.util.*

class Publicacion {
    var ID: String
    var TITULO : String
    var CONTENIDO : String
    var FECHA : String
    var ID_CIRCULO : String

    constructor(ID: String, TITULO: String, CONTENIDO: String, FECHA: String, ID_CIRCULO: String) {
        this.ID = ID
        this.TITULO = TITULO
        this.CONTENIDO = CONTENIDO
        this.FECHA = FECHA
        this.ID_CIRCULO = ID_CIRCULO
    }
}