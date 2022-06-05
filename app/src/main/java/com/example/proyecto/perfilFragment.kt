package com.example.proyecto

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import com.example.proyecto.databinding.FragmentPerfilBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class perfilFragment : Fragment() {

    private lateinit var binding: FragmentPerfilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentPerfilBinding.inflate(layoutInflater)
        //Existen usarios con id 0,1,2
        var id = "0"
        val database=Firebase.database
        val dataref=database.reference
        dataref.child("Usuarios").child("id").child(id).child("name").get().addOnSuccessListener { Name ->
            //Log.d("prueba", Name.value.toString())
            binding.nombre.setText(Name.value.toString())
        }
        dataref.child("Usuarios").child("id").child(id).child("usuario").get().addOnSuccessListener { User ->
            //Log.d("prueba", User.value.toString())
            binding.user.setText(User.value.toString())
        }
        dataref.child("Usuarios").child("id").child(id).child("nivel").get().addOnSuccessListener { Level ->
            binding.nivel.setText(Level.value.toString())
        }
        dataref.child("Usuarios").child("id").child(id).child("puntos").get().addOnSuccessListener { Points ->
            binding.puntos.setText(Points.value.toString())
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}