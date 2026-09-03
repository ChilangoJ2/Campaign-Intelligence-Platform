package com.jay.myfirstapp.models

class User {
    var jina: String=""
    var email: String=""
    var pass: String=""
    var confirmpass: String=""
    var userid: String=""


    constructor(jina: String, email: String,
                pass: String, confirmpass: String, userid: String) {
        this.jina=jina
        this.email=email
        this.pass=pass
        this.confirmpass=confirmpass
        this.userid=userid
    }
    constructor()

}