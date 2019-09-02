package com.example.darshnak.bottomnavigtaionproj.utility
import android.os.Handler
import android.os.Looper
import android.os.Process
import java.util.concurrent.BlockingQueue
import java.util.concurrent.Future
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

class ThreadManager private constructor() {

    val mWorkQueue: BlockingQueue<Runnable> = LinkedBlockingDeque()
    var threadPoolExecutor: ThreadPoolExecutor

    init {
        uiHandler = Handler(Looper.getMainLooper())
        threadPoolExecutor = ThreadPoolExecutor(
            CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_SECONDS.toLong(), TimeUnit.SECONDS,
            mWorkQueue, CustomThreadFactory(), ThreadPoolExecutor.DiscardPolicy()
        )
    }

    fun doWork(runnable: Runnable): Future<*> {
        return instance!!.threadPoolExecutor.submit(runnable)
    }

    abstract class CustomRunnable : Runnable {

        abstract fun onBackground()

        open fun onUi() {}

        override fun run() {
            onBackground()
            if (uiHandler != null) {
                uiHandler!!.post { onUi() }
            }

        }
    }

    private class CustomThreadFactory internal constructor() : ThreadFactory {
        private val group: ThreadGroup
        private val threadNumber = AtomicInteger(1)
        private val namePrefix: String

        init {
            val s = System.getSecurityManager()
            group = if (s != null)
                s.threadGroup
            else
                Thread.currentThread().threadGroup
            namePrefix = "CryptoAssignmentPool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-"
        }

        override fun newThread(r: Runnable): Thread {
            val wrapperRunnable = Runnable {
                try {
                    Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND)
                } catch (t: Throwable) {

                }

                r.run()
            }
            return Thread(group, wrapperRunnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L)
        }

        companion object {
            private val poolNumber = AtomicInteger(1)
        }
    }

    companion object {
        private val CPU_COUNT = Runtime.getRuntime().availableProcessors()

        private val CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4))
        private val MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1
        private val KEEP_ALIVE_SECONDS = 5
        var instance: ThreadManager? = null
            private set
        private var uiHandler: Handler?=null

        init {
            instance = ThreadManager()
        }
    }
}