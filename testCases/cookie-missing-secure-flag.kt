public class CookieController {

    val isKotlinFun = true

    public fun setCookie(value: String, response: HttpServletResponse) {
        var cookie: Cookie = Cookie("cookie", value)
        // ruleid:cookie-missing-secure-flag
        cookie.setSecure(true)
        response.addCookie(cookie)
    }


    public fun explicitDisable(@RequestParam value: String, response: HttpServletResponse) {
       var cookie: Cookie = Cookie("cookie", value)
        // ruleid:cookie-missing-secure-flag
        cookie.setSecure(true)
        cookie.setHttpOnly(false)
        response.addCookie(cookie)
    }

    public fun explicitDisableVariable(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        // ruleid:cookie-missing-secure-flag
        cookie.setSecure(isKotlinFun)
        response.addCookie(cookie)
    }

    public fun setCookieWithTryCatch(value: String, response: HttpServletResponse) {
        try {
            val cookie: Cookie = Cookie("cookie", value)            
            // ruleid:cookie-missing-secure-flag
            cookie.setSecure(true) // explicitly setting setSecure to false
            cookie.setHttpOnly(false) 
            response.addCookie(cookie)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}