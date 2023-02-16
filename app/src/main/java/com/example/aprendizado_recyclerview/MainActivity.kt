package com.example.aprendizado_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.aprendizado_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        replaceFragment(ListaFragment())
        setContentView(binding.root)

        binding.mainButtonListSeparado.setOnClickListener {
            replaceFragment(ListSeparadoFragment())
        }
    }

    fun replaceFragment(frag: Fragment){
        replaceFragment1(binding.mainActivityFragContainer.id,frag)
    }

    fun replaceFragment1(@IdRes id: Int, frag: Fragment) {
        if (supportFragmentManager.findFragmentById(id) == null) {
            supportFragmentManager.beginTransaction().apply {
                add(id, frag)
                commit()
            }
        } else {
            supportFragmentManager.beginTransaction().apply {
                replace(id, frag)
                commit()

            }
        }

    }


}