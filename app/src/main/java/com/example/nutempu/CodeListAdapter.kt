package com.example.nutempu

import com.example.nutempu.model.Code

class CodeListAdapter(private val codes: List<Code>,
                      private val context: Context) : Adapter<CodeListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val code = codes[position]
        holder?.let {
            it.bindView(code)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.code_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return codes.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(note: Code) {
            val title = itemView.note_item_title
            val description = itemView.note_item_description

            title.text = note.title
            description.text = note.description
        }

    }

}