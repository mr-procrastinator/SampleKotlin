package mrpro.samplekotlin.ui.presenters.interfaces

interface Presenter<T> {

    fun attachView(view :T)

    fun detachView()

}
