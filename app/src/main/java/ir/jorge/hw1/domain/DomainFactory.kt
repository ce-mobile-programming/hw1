package ir.jorge.hw1.domain

import android.content.Context
import ir.jorge.hw1.system.FileSystem

interface DomainFactory {
    fun newMessageController(uiRunner: UIRunner, fileSystem: FileSystem, context: Context): MessageController
    fun newNotificationCenter(): NotificationCenter
}

private object DomainFactoryImpl : DomainFactory {
    override fun newMessageController(uiRunner: UIRunner, fileSystem: FileSystem, context: Context): MessageController =
            MessageControllerImpl(
                    StorageManagerImpl(fileSystem, context),
                    ConnectionManagerImpl,
                    NotificationCenterImpl,
                    uiRunner
            )

    override fun newNotificationCenter(): NotificationCenter =
            NotificationCenterImpl
}

var domainFactory: DomainFactory = DomainFactoryImpl
