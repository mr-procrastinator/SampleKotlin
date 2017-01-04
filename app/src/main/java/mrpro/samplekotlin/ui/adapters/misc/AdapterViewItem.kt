package mrpro.samplekotlin.ui.adapters.misc

interface AdapterViewItem<in T : Any> {

    fun onBindViewHolder(item: ViewType<T>)

}