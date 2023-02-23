package pe.edu.ulima.circulima_v1.models.beans

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Usuario {
    @PrimaryKey
    var ID: Int
    var NOMBRE : String

    constructor(ID: Int, NOMBRE: String, FECHA: Int) {
        this.ID = ID
        this.NOMBRE = NOMBRE
    }
}