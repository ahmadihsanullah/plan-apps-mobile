package belajar.android.plan_apps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import belajar.android.plan_apps.R
import belajar.android.plan_apps.model.ModelPlan

class PlanAdapter(
    var callback : OnListener
): RecyclerView.Adapter<PlanAdapter.ViewHolder>() {

    private var datalist : List<ModelPlan> = ArrayList()

    fun setData(data: List<ModelPlan>){
        this.datalist = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: PlanAdapter.ViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

    override fun getItemCount(): Int = datalist.size

    class ViewHolder(itemView: View,val callback: OnListener) : RecyclerView.ViewHolder(itemView) {
        var tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        var tv_desc = itemView.findViewById<TextView>(R.id.tv_desc)
        fun bind(data: ModelPlan){
            tv_title.text = data.title
            tv_desc.text = data.title

            itemView.setOnClickListener {
                callback.onClick(data)
            }
        }



    }

    interface OnListener {
        fun onClick(data: ModelPlan)
    }
}