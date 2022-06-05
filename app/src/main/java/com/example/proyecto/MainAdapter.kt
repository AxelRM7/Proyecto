package com.example.proyecto

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.databinding.TiendaBinding
import com.example.proyecto.ProductoListCallback
import com.squareup.picasso.Picasso
import org.json.JSONObject

class MainAdapter(private val productos: Array<JSONObject>, private val callback: ProductoListCallback): RecyclerView.Adapter<MainAdapter.MainHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
                val binding = TiendaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MainHolder(binding,callback)
        }

        override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int){
            holder.render(productos[position])
        }

        override fun getItemCount(): Int = productos.size

        class MainHolder(val binding: TiendaBinding, val callback: ProductoListCallback): RecyclerView.ViewHolder(binding.root){
            fun render(resp: JSONObject){
                binding.nameproducto.setText(resp.getString("title"))
                binding.descripcion.setText(resp.getString("description"))
                binding.precio.setText(resp.getString("price"))
                binding.calificacion.setText((resp.getString("rate")))
                val imagen = binding.imagen
                val link = resp.getString("image").toString()
                if (link != null && !link.isEmpty()) {
                    Picasso.get().load(link).into(imagen)
                }
                binding.detalles.setOnClickListener {
                    callback.onClick(resp.getString("id"))
                }
            }
        }
}

