package com.example.proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyecto.databinding.FragmentWishlistBinding

class wishlistFragment : Fragment() {
    private lateinit var binding: FragmentWishlistBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWishlistBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_wishlist, container, false)
    }
}