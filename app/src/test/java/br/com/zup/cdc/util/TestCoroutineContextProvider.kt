package br.com.zup.cdc.util

import br.com.zup.cdc.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class TestCoroutineContextProvider : CoroutineContextProvider() {
    override val IO: CoroutineContext = Dispatchers.Unconfined
    override val Main: CoroutineContext = Dispatchers.Unconfined
}