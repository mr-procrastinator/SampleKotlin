package mrpro.samplekotlin.model.interactors

import rx.Subscriber
import rx.subscriptions.Subscriptions

/**
 * Created by Andrey on 11/12/15.
 */
abstract class BaseInteractor<T> {
    protected var subscription = Subscriptions.empty()

    abstract fun execute(callback: Subscriber<T>)

    /**
     * Unsubscribes from current [rx.Subscription].
     */
    fun unsubscribe() {
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
        subscription = Subscriptions.empty()
    }
}
