package com.example.proyecto

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.proyecto.databinding.FragmentSearchBinding
import com.example.proyecto.remote.ProductEntry
import com.example.proyecto.remote.RetroFitBuilder
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class searchFragment : Fragment(), ProductoListCallback {
    private lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSearchBinding.inflate(layoutInflater)

        binding.botonb.setOnClickListener {
            val busqueda=binding.buscar.text.toString()
            val retrofit=RetroFitBuilder.create().getProductsById(busqueda)
            retrofit.enqueue(object : retrofit2.Callback<ProductEntry> {
                override fun onResponse(
                    call: Call<ProductEntry>,
                    response: Response<ProductEntry>
                ) {
                    val respuesta = response.body()
                    val productos: Array<JSONObject> = arrayOf(
                        JSONObject("{\"id\": \"${respuesta?.id.toString()}\",\"title\": \"${respuesta?.title.toString()}\", \"price\":\"$${respuesta?.price.toString()}\",\"description\":\"${respuesta?.description.toString()}\",\"image\":\"${respuesta?.image.toString()}\",\"rate\":\"${respuesta?.rating?.rated.toString()}\"}"),
                    )
                    var adapter = MainAdapter(productos,this@searchFragment)
                    binding.productos.adapter = adapter
                }

                override fun onFailure(call: Call<ProductEntry>, t: Throwable) {
                    Log.w("ErrorEnRetro", "error: ${t.message}")
                }
            })
        }
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onClick(id: String) {
        val direcction = searchFragmentDirections.actionSearchFragmentToDetalles2(id)
        findNavController().navigate(direcction)
    }
}