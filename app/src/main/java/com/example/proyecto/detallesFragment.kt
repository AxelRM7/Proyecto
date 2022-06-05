package com.example.proyecto

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.proyecto.databinding.FragmentDetallesBinding
import com.example.proyecto.remote.ProductEntry
import com.example.proyecto.remote.RetroFitBuilder
import com.squareup.picasso.Picasso
import okhttp3.Response

class detallesFragment : Fragment() {
    private lateinit var binding: FragmentDetallesBinding
        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentDetallesBinding.inflate(layoutInflater)
            val id = arguments?.getString("id")
            val retrofit = RetroFitBuilder.create().getProductsById(id.toString())
            val navController = findNavController()
            retrofit.enqueue(object : retrofit2.Callback<ProductEntry> {
                override fun onResponse(
                    call: retrofit2.Call<ProductEntry>,
                    response: retrofit2.Response<ProductEntry>
                ) {
                    val respuesta = response.body()
                    if (respuesta != null) {
                        binding.nameproducto.setText(respuesta?.title.toString())
                        binding.descripcion.setText(respuesta?.description.toString())
                        binding.precio.setText("$ ${respuesta?.price.toString()}")
                        binding.calificacion.setText(respuesta?.rating?.rated.toString())
                        val imagen = binding.imagen
                        Picasso.get().load(respuesta?.image.toString()).into(imagen)
                    }
                }

                override fun onFailure(call: retrofit2.Call<ProductEntry>, t: Throwable) {
                    Log.w("ErrorEnRetro", "error: ${t.message}")
                }
            })
        // Inflate the layout for this fragment
        return binding.root
    }
}