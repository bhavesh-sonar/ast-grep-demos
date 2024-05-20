public class CookieController {

    val isKotlinFun = false
    
    public fun setCookie(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        // ruleid: cookie-missing-httponly
        response.addCookie(cookie)
    }

    public fun setSecureCookie(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        cookie.setSecure(true)
        // ruleid: cookie-missing-httponly
        response.addCookie(cookie)
    }

    public fun explicitDisable(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        cookie.setSecure(false)
        // ruleid:cookie-missing-httponly
        cookie.setHttpOnly(false)
        response.addCookie(cookie)
    }

    public fun explicitDisableVariable(value: String, response: HttpServletResponse) {
        val cookie: Cookie = Cookie("cookie", value)
        // ruleid:cookie-missing-httponly
        cookie.setHttpOnly(isKotlinFun)
        response.addCookie(cookie)
    }

    public fun setCookieWithTryCatch(value: String, response: HttpServletResponse) {
        try {
            val cookie: Cookie = Cookie("cookie", value)
            cookie.setSecure(true)
            // ruleid:cookie-missing-httponly
            cookie.setHttpOnly(false)
            response.addCookie(cookie)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}