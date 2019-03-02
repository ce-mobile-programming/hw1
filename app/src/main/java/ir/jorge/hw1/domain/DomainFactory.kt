package ir.jorge.hw1.domain

import ir.jorge.hw1.system.systemFactory

interface DomainFactory {
    fun newMessageController(): MessageController
    fun newNotificationCenter(): NotificationCenter
}

object DomainFactoryImpl : DomainFactory {
    override fun newMessageController(): MessageController =
            MessageController(StorageManager(systemFactory.newFileSystem()), ConnectionManager())

    override fun newNotificationCenter(): NotificationCenter =
            NotificationCenter()
}

var domainFactory: DomainFactory = DomainFactoryImpl
