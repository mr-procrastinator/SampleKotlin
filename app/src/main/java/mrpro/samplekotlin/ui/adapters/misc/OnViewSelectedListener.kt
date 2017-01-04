package mrpro.samplekotlin.ui.adapters.misc

/**
 * Created by Andrey on 12/15/16.
 */
interface OnViewSelectedListener <in T: Any>{
    fun onItemSelected(item: T)
}