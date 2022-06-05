package com.example.proyecto

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.proyecto.databinding.FragmentPerfilBinding
import com.example.proyecto.databinding.FragmentStoreBinding
import com.example.proyecto.remote.ProductEntry
import com.example.proyecto.remote.RetroFitBuilder
import com.example.proyecto.ProductoListCallback
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import kotlin.random.Random

class storeFragment : Fragment(), ProductoListCallback{

    private lateinit var binding: FragmentStoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreBinding.inflate(layoutInflater)
        val top5: Array<JSONObject> = arrayOf(
            JSONObject("{\"title\": \"\", \"price\":\"\",\"description\":\"\",\"image\":\"\",\"rate\":\"\"}"),
            JSONObject("{\"title\": \"\", \"price\":\"\",\"description\":\"\",\"image\":\"\",\"rate\":\"\"}"),
            JSONObject("{\"title\": \"\", \"price\":\"\",\"description\":\"\",\"image\":\"\",\"rate\":\"\"}"),
            JSONObject("{\"title\": \"\", \"price\":\"\",\"description\":\"\",\"image\":\"\",\"rate\":\"\"}"),
            JSONObject("{\"title\": \"\", \"price\":\"\",\"description\":\"\",\"image\":\"\",\"rate\":\"\"}"),
        )
        for (i in 0..4) {
            val numberproducts = (1..20)
            val elegido = numberproducts.random()
            val retrofit = RetroFitBuilder.create()
            val response = retrofit.getProductsById(elegido.toString())
            response.enqueue(object : retrofit2.Callback<ProductEntry> {
                override fun onResponse(
                    call: Call<ProductEntry>,
                    response: Response<ProductEntry>
                ) {
                    val respuesta = response.body()
                    top5.set(
                        i,
                        JSONObject("{\"id\": \"${respuesta?.id.toString()}\",\"title\": \"${respuesta?.title.toString()}\", \"price\":\"$${respuesta?.price.toString()}\",\"description\":\"${respuesta?.description.toString()}\",\"image\":\"${respuesta?.image.toString()}\",\"rate\":\"${respuesta?.rating?.rated.toString()}\"}"),
                    )
                    Log.d("json",response.body().toString())
                    var adapter = MainAdapter(top5,this@storeFragment)
                    binding.productos.adapter = adapter
                }

                override fun onFailure(call: Call<ProductEntry>, t: Throwable) {
                    Log.w("ErrorEnRetro", "error: ${t.message}")
                }
            })

        }
        return binding.root
    }

    override fun onClick(id: String) {
        val direcction = storeFragmentDirections.actionStoreFragmentToDetalles2(id)
        findNavController().navigate(direcction)
    }
}
