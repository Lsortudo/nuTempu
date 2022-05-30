package com.example.nutempu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nutempu.databinding.CodeItemBinding
import com.example.nutempu.model.Code

class CodeListAdapter(
    private val context: Context
) : RecyclerView.Adapter<CodeListAdapter.ViewHolder>() {

    private val codes = arrayListOf<Code>()


    fun addItem(code: Code){
        codes.add(code)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val code = codes[position]
        holder?.let {
            it.bindView(code)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = CodeItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return codes.size
    }

    class ViewHolder(val binding: CodeItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(note: Code) {
            val codObjeto = binding.codeItemTitle
            val description = binding.codeItemDescription

            codObjeto.text = note.objetos[0].codObjeto
            description.text = note.objetos[0].eventos[0].descricao
        }

    }


}