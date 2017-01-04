package mrpro.samplekotlin.ui.adapters.misc

interface ViewType <out T:Any> {
    fun getViewType(): Int
    fun getItem():T
}