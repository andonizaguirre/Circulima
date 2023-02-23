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

class CirculoFragment : Fragment(R.layout.fragment_circulo) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Circulos"
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_circulo, container, false)
        val textViewNombre : TextView = view.findViewById(R.id.tviNombre)
        val textViewDesc : TextView = view.findViewById(R.id.tviDescripcion2)
        val editBtn : Button = view.findViewById(R.id.btnEdit)

        val args = this.arguments
        val inputDataNombre = args?.get("dataNombre")
        textViewNombre.text = inputDataNombre.toString()
        val inputDataDesc = args?.get("dataDescripcion")
        textViewDesc.text = inputDataDesc.toString()

        editBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("dataID", args?.get("dataID").toString())
            bundle.putString("dataNombre", inputDataNombre.toString())
            bundle.putString("dataDescripcion", inputDataDesc.toString())
            val fragment = CirculoEditFragment()
            fragment.arguments = bundle
            val ft = fragmentManager?.beginTransaction()
            ft?.addToBackStack(null)
            ft?.replace(R.id.fcvSecciones, fragment)?.commit()
        }

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)//a

    }
}