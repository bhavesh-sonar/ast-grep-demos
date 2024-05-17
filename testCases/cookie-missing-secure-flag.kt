public class CookieController {
    public fun setCookie(value: String, response: HttpServletResponse) {
        var cookie: Cookie = Cookie("cookie", value)
        // ruleid:cookie-missing-secure-flag
        response.addCookie(cookie)
    }


    public fun explicitDisable(@RequestParam value: String, response: HttpServletResponse) {
       var cookie: Cookie = Cookie("cookie", value)
        // ruleid:cookie-missing-secure-flag
        cookie.setSecure(false)
        cookie.setHttpOnly(false)
        response.addCookie(cookie)
    }

}