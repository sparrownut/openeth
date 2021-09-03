package com.stupidfish.tool

import java.util.*
import javax.mail.Session


class MailSender(val mailName: String,val mailPassword: String,val mailUrl: String,val text: String, val oppositeMail: String) {
    fun send() {
        var prop = Properties()
        prop.setProperty("mail.host", "smtp.sohu.com")
        prop.setProperty("mail.transport.protocol", "smtp")
        prop.setProperty("mail.smtp.auth", "true")
        val session = Session.getInstance(prop)
        val ts = session.transport
        ts.connect(mailUrl, mailName, mailPassword)
        //val message = createSimpleMail(session)

    }
}