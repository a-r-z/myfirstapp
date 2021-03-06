package com.example.myfirstapp.presentation.list


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfirstapp.R
import com.example.myfirstapp.presentation.api.CovidResponse

class CovidAdapter(private var dataSet: List<CovidResponse>, var listener: ((CovidResponse) -> Unit )? = null) :
        RecyclerView.Adapter<CovidAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    // val listener: ((CovidListResponse) -> Unit)? =null
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.covid_country)
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView.setOnClickListener{

            }
            imageView = view.findViewById(R.id.covid_img)
        }
    }

    fun updateList(list: List<CovidResponse>){
        dataSet = list
        notifyDataSetChanged()
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.covid_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val covid =  dataSet[position]
        val covidResponse : CovidResponse = dataSet[position]
        val flag = covidResponse.ISO2
        viewHolder.textView.text = covid.Country
        viewHolder.itemView.setOnClickListener {
            listener?.invoke(covid);
        }


        Glide

                .with(viewHolder.itemView.context)

                .load("https://www.countryflags.io/${flag}/flat/64.png")
                .centerCrop()
                .into(viewHolder.imageView)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
