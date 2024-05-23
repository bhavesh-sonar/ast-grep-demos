public class Cls {

    val value: String = "none" 

    public fun ldapBind(env: Environment): Void {
        // ruleid:anonymous-ldap-bind
        env.put(Context.SECURITY_AUTHENTICATION, "none")
        val ctx: DirContext = InitialDirContext(env)
    }

    public fun ldapBindVarilable(env: Environment): Void {
        // ruleid:anonymous-ldap-bind
        env.put(Context.SECURITY_AUTHENTICATION, value)
        val ctx: DirContext = InitialDirContext(env)
    }

    public fun ldapBindNoAuthInfo(env: Environment): Void {
        // ruleid:anonymous-ldap-bind
        try {
            env.put(Context.SECURITY_AUTHENTICATION, "none")
            val ctx: DirContext = InitialDirContext(env)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    public fun ldapBindEmptyAuthType(env: Environment): Void {
        // ruleid:anonymous-ldap-bind
        env.put(Context.SECURITY_AUTHENTICATION, "")
        val ctx: DirContext = InitialDirContext(env)
    }

    public fun ldapBindAnonymousAuth(env: Environment): Void {
        // ruleid:anonymous-ldap-bind
        env.put(Context.SECURITY_AUTHENTICATION, "anonymous")
        val ctx: DirContext = InitialDirContext(env)
    }

}
