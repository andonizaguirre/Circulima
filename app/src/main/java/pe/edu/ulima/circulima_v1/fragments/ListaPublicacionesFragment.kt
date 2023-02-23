package pe.edu.ulima.circulima_v1.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.ulima.circulima_v1.R
import pe.edu.ulima.circulima_v1.adapters.ListadoCirculosAdapter
import pe.edu.ulima.circulima_v1.adapters.ListadoPublicacionesAdapter
import pe.edu.ulima.circulima_v1.models.GestorCirculos
import pe.edu.ulima.circulima_v1.models.GestorPublicaciones

class ListaPublicacionesFragment : Fragment(){
    private lateinit var mRviPublicaciones : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Publicaciones"
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_publicaciones, container, false)
        val cirBtn : Button = view.findViewById(R.id.btnLCirculos)
        cirBtn.setOnClickListener {
            val fragment = ListaCirculosFragment()
            val ft = fragmentManager?.beginTransaction()
            ft?.addToBackStack(null)
            ft?.replace(R.id.fcvSecciones, fragment)?.commit()
        }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_publicaciones, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRviPublicaciones = view.findViewById(R.id.rviPublicaciones)

        val gestor = GestorPublicaciones.getInstance()

        GlobalScope.launch(Dispatchers.Main) {
            val lista = withContext(Dispatchers.IO) {
                gestor.obtenerListaPublicaciones()
            }
            val adapter = ListadoPublicacionesAdapter(lista) {
                Log.i("PlanetasFragment","Se hizo click en el planeta " + it.TITULO)
            }
            mRviPublicaciones.adapter = adapter
        }
    }
}