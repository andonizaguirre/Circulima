package pe.edu.ulima.circulima_v1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.circulima_v1.R
import pe.edu.ulima.circulima_v1.models.beans.Circulo

class ListadoCirculosAdapter(private val mListaPlanetas : List<Circulo>,
    private val mOnItemClickListener : (circulo : Circulo) -> Unit)
    : RecyclerView.Adapter<ListadoCirculosAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tviCirculoNombre : TextView
        val tviCirculoDescripcion : TextView
        val tviCarrera : TextView

        init {
            tviCirculoNombre = view.findViewById(R.id.tviCirculoNombre)
            tviCirculoDescripcion = view.findViewById(R.id.tviCirculoDescripcion)
            tviCarrera = view.findViewById(R.id.tviCarrera)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_circulo, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val circulo = mListaPlanetas[position]
        holder.tviCirculoNombre.text = circulo.NOMBRE
        holder.tviCirculoDescripcion.text = circulo.DESCRIPCION
        holder.tviCarrera.text = circulo.CARRERA

        holder.itemView.setOnClickListener {
            mOnItemClickListener(circulo)
        }
    }

    override fun getItemCount(): Int {
        // Devolver el nro de items a mostrar
        return mListaPlanetas.size
    }
}