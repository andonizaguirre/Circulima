package pe.edu.ulima.circulima_v1.models

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import pe.edu.ulima.circulima_v1.models.beans.Publicacion

class GestorUsuarios {
    val dbFirebase = Firebase.firestore
    val listaPublicacion = mutableListOf<Publicacion>()

    companion object{
        private var instance : GestorUsuarios? = null

        fun getInstance() : GestorUsuarios {
            if (instance == null){
                instance = GestorUsuarios()
            }
            return instance!!
        }
    }
}