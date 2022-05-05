package eu.luminis.workshop.smallsteps.persistence

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

// Understands how to run non-blocking database transactions
internal suspend fun <T> nonBlockingTransaction(
    block: suspend () -> T
): T = newSuspendedTransaction(Dispatchers.IO) {
    block()
}