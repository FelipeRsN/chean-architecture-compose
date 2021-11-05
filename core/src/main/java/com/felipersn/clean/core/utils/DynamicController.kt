package com.felipersn.clean.core.utils

import android.content.Context
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus

object DynamicController {
    private var manager: SplitInstallManager? = null

    const val MODULE_COIN_DETAIL = "coin_detail"

    private fun initManager(context: Context) {
        if (manager == null) manager = SplitInstallManagerFactory.create(context)
    }

    fun checkIfModuleIsAlreadyInstalled(
        context: Context,
        module: String,
    ) {
        initManager(context)
        manager?.installedModules?.contains(module)
    }

    fun requestModule(
        context: Context,
        module: String,
        onDownload: () -> Unit,
        onInstalled: () -> Unit,
        onError: () -> Unit
    ) {
        initManager(context)
        val request = SplitInstallRequest.newBuilder()
            .addModule(module)
            .build()

        manager?.startInstall(request)

        manager?.registerListener {
            when (it.status()) {
                SplitInstallSessionStatus.DOWNLOADING -> onDownload.invoke()
                SplitInstallSessionStatus.INSTALLED -> onInstalled.invoke()
                else -> onError.invoke()
            }
        }
    }
}