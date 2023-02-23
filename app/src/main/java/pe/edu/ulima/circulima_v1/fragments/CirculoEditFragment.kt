package pe.edu.ulima.circulima_v1.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import pe.edu.ulima.circulima_v1.R
import pe.edu.ulima.circulima_v1.models.GestorCirculos

class CirculoEditFragment : Fragment(R.layout.fragment_circulo_edit){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Circulo Edit"
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_circulo_edit, container, false)
        val textViewNombre : TextView = view.findViewById(R.id.tviNombre)
        val editViewDesc : TextView = view.findViewById(R.id.editDescription)
        val guardarBtn : Button = view.findViewById(R.id.btnGuardar)

        val args = this.arguments
        val inputDataNombre = args?.get("dataNombre")
        textViewNombre.text = inputDataNombre.toString()//sds
        val editDataDesc = args?.get("dataDescripcion")
        editViewDesc.text = editDataDesc.toString()

        guardarBtn.setOnClickListener {
            GestorCirculos.getInstance().actualizarDescripcion(args?.get("dataID").toString(), editViewDesc.text.toString())
            val fragment = ListaCirculosFragment()
            val ft = fragmentManager?.beginTransaction()
            ft?.addToBackStack(null)
            ft?.replace(R.id.fcvSecciones, fragment)?.commit()
        }

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}