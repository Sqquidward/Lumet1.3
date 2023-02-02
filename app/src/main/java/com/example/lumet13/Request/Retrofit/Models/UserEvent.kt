package lumetbackend.entities



open class UserEvent(
    open var id: Int?,
    open var createdEvents: Array<Int>,
    open var historyCreatedEvents: Array<Int>,
    open var participationEvents: Array<Int>,
    open var historyParticipationEvents: Array<Int>
)