package pe.edu.ulima.circulima_v1.models

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import pe.edu.ulima.circulima_v1.models.beans.Circulo

class GestorCirculos {
    val dbFirebase = Firebase.firestore
    val listaCirculo = mutableListOf<Circulo>()

    companion object{
        private var instance : GestorCirculos? = null

        fun getInstance() : GestorCirculos {
            if (instance == null){
                instance = GestorCirculos()
            }
            return instance!!
        }
    }

    fun generarCirculos(){
        dbFirebase.collection("circulos")
            .get()
            .addOnSuccessListener { result ->
                println("CREACION DE LA LISTA DE OBJETOS")
                var cont = 0
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data} => ${document.get("nombre")}")
                    val ctemp = Circulo(document.id, document.get("nombre").toString(), document.get("descripcion").toString(), document.get("carrera").toString())
                    listaCirculo.add(ctemp)
                    println("AÑADIDO: " + listaCirculo[cont].NOMBRE)
                    cont++
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    fun obtenerListaCirculos() : List<Circulo>{
        return listaCirculo
    }

    fun  obtenerListaCirculosCorutinas() : List<Circulo>{

        val resultado = mutableListOf<Circulo>()

        dbFirebase.collection("circulos")
            .get()
            .addOnSuccessListener { result ->
                println("CREACION DE LA LISTA DE OBJETOS")
                var cont = 0
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data} => ${document.get("nombre")}")
                    val ctemp = Circulo(document.id, document.get("nombre").toString(), document.get("descripcion").toString(), document.get("carrera").toString())
                    listaCirculo.add(ctemp)
                    println("AÑADIDO: " + listaCirculo[cont].NOMBRE)
                    cont++
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
        return resultado
    }

    fun actualizarDescripcion(id: String, descripcion : String){
        dbFirebase.collection("circulos")
            .document(id)
            .update(mapOf(
                "descripcion" to descripcion,
            ))
        listaCirculo.find { it.ID == id }!!.DESCRIPCION = descripcion
        println(listaCirculo.find { it.ID == id }!!.DESCRIPCION)
        println("Actualizar descripción: " + descripcion)
    }
}