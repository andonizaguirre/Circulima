package pe.edu.ulima.circulima_v1.models

import android.content.ContentValues
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import pe.edu.ulima.circulima_v1.models.beans.Circulo
import pe.edu.ulima.circulima_v1.models.beans.Publicacion

class GestorPublicaciones {
    val dbFirebase = Firebase.firestore
    val listaPublicacion = mutableListOf<Publicacion>()

    companion object{
        private var instance : GestorPublicaciones? = null

        fun getInstance() : GestorPublicaciones {
            if (instance == null){
                instance = GestorPublicaciones()
            }
            return instance!!
        }
    }

    fun generarPublicaciones(){
        dbFirebase.collection("publicaciones")
            .get()
            .addOnSuccessListener { result ->
                println("CREACION DE LA LISTA DE OBJETOS")
                var cont = 0
                for (document in result) {
                    Log.d(ContentValues.TAG, "${document.id} => ${document.data} => ${document.get("nombre")}")
                    val ctemp = Publicacion(document.id,
                        document.get("titulo").toString(),
                        document.get("contenido").toString(),
                        document.get("fecha").toString(),
                        document.get("circuloID").toString())
                    listaPublicacion.add(ctemp)
                    println("AÑADIDO: " + listaPublicacion[cont].TITULO)
                    cont++
                }
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents.", exception)
            }
    }

    fun obtenerListaPublicaciones() : List<Publicacion>{
        return listaPublicacion
    }
}