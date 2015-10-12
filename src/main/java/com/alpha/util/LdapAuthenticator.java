package com.alpha.util;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

/**
 * Created by erwinschens on 12.10.15.
 */
public class LdapAuthenticator {

    public static final String BASE_DN = "ou=people,dc=uni-koblenz,dc=de";
    public static final String LDAP_ADDRESS = "ldap://ldap.uni-koblenz.de:389";

    public boolean authenticate(String username, String password) {
        Hashtable<String, String> environment =
                new Hashtable<String, String>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        environment.put(Context.PROVIDER_URL, LdapAuthenticator.LDAP_ADDRESS);
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
        environment.put(Context.SECURITY_PRINCIPAL, "uid=" + username + "," + LdapAuthenticator.BASE_DN);
        environment.put(Context.SECURITY_CREDENTIALS, password);

        try {
            DirContext authContext =
                    new InitialDirContext(environment);
            return true;
        } catch (AuthenticationException ex) {
            return false;
        } catch (NamingException ex) {
            return false;
        }
    }

}
