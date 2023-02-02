package lumetbackend.entities






class EventDTO(
    val id:Int,
    val userrating: Int?,
    val userid: Int?,
    val name: String?,
    val description: String?,
    val hobbytype: String?,
    val avatarimage: String?,
    val time: String?,
    val desiredage: Int?,
    val participantLimit: Int?,
    val participantsAnonymity: String?,
    val privacyStatus: String?,
    val registrationSettings: String?,
    var confirmedParticipants: Array<Int>?,
    var latitude: String?,
    var longitude: String?
): java.io.Serializable {


}


