package pe.edu.ulima.circulima_v1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.circulima_v1.R
import pe.edu.ulima.circulima_v1.models.beans.Publicacion

class ListadoPublicacionesAdapter(private val mListaPublicaciones : List<Publicacion>,
                                  private val mOnItemClickListener : (publicacion: Publicacion) -> Unit)
    : RecyclerView.Adapter<ListadoPublicacionesAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tviPubTitulo : TextView
        val tviPubContenido : TextView
        val tviFecha : TextView

        init {
            tviPubTitulo = view.findViewById(R.id.tviPubTitulo)
            tviPubContenido = view.findViewById(R.id.tviPubContenido)
            tviFecha = view.findViewById(R.id.tviFecha)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_publicacion, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val publicacion = mListaPublicaciones[position]
        holder.tviPubTitulo.text = publicacion.TITULO
        holder.tviPubContenido.text = publicacion.CONTENIDO
        holder.tviFecha.text = publicacion.FECHA

        holder.itemView.setOnClickListener {
            mOnItemClickListener(publicacion)
        }
    }

    override fun getItemCount(): Int {
        // Devolver el nro de items a mostrar
        return mListaPublicaciones.size
    }
}