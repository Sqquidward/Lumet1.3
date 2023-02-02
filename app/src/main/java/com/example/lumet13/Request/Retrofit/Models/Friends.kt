package lumetbackend.entities


open class Friends(
    open var id: Int?,
    open var friendlist: Array<Int>,
    open var userRequests: Array<Int>,
    open var requestsToUser: Array<Int>
)