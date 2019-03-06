package ir.jorge.hw1.domain

import ir.jorge.hw1.system.FileSystem

interface DomainFactory {
    fun newMessageController(uiRunner: UIRunner, fileSystem: FileSystem): MessageController
    fun newNotificationCenter(): NotificationCenter
}

private object DomainFactoryImpl : DomainFactory {
    override fun newMessageController(uiRunner: UIRunner, fileSystem: FileSystem): MessageController =
            MessageControllerImpl(
                    StorageManagerImpl(fileSystem),
                    ConnectionManagerImpl,
                    NotificationCenterImpl,
                    uiRunner
            )

    override fun newNotificationCenter(): NotificationCenter =
            NotificationCenterImpl
}

var domainFactory: DomainFactory = DomainFactoryImpl
