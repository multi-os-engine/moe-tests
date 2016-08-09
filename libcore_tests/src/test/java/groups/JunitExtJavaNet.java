import libcore.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

    org.apache.harmony.tests.java.net.BindExceptionTest.class,
    org.apache.harmony.tests.java.net.ConnectExceptionTest.class,
    org.apache.harmony.tests.java.net.CookieHandlerTest.class,
    org.apache.harmony.tests.java.net.CookieManagerTest.class,
    org.apache.harmony.tests.java.net.CookiePolicyTest.class,
    org.apache.harmony.tests.java.net.CookieStoreTest.class,
    org.apache.harmony.tests.java.net.DatagramPacketTest.class,
    org.apache.harmony.tests.java.net.DatagramSocketImplTest.class,
    org.apache.harmony.tests.java.net.DatagramSocketTest.class,
    org.apache.harmony.tests.java.net.HttpCookieTest.class,
    org.apache.harmony.tests.java.net.IDNTest.class,
    org.apache.harmony.tests.java.net.Inet4AddressTest.class,
    org.apache.harmony.tests.java.net.Inet6AddressTest.class,
    org.apache.harmony.tests.java.net.InetAddressTest.class,
    org.apache.harmony.tests.java.net.InetAddressThreadTest.class,
    org.apache.harmony.tests.java.net.InetSocketAddressTest.class,
    org.apache.harmony.tests.java.net.InterfaceAddressTest.class,
    org.apache.harmony.tests.java.net.JarURLConnectionTest.class,
    org.apache.harmony.tests.java.net.MalformedURLExceptionTest.class,
    org.apache.harmony.tests.java.net.MulticastSocketTest.class,
    org.apache.harmony.tests.java.net.NetworkInterfaceTest.class,
    org.apache.harmony.tests.java.net.NoRouteToHostExceptionTest.class,
    org.apache.harmony.tests.java.net.PasswordAuthenticationTest.class,
    org.apache.harmony.tests.java.net.ProtocolExceptionTest.class,
    org.apache.harmony.tests.java.net.ProxySelectorTest.class,
    org.apache.harmony.tests.java.net.ResponseCacheTest.class,
    org.apache.harmony.tests.java.net.SecureCacheResponseTest.class,
    org.apache.harmony.tests.java.net.URISyntaxExceptionTest.class,
    org.apache.harmony.tests.java.net.URITest.class,
    org.apache.harmony.tests.java.net.URLDecoderTest.class,
    org.apache.harmony.tests.java.net.URLTest.class,
    org.apache.harmony.tests.java.net.UnknownHostExceptionTest.class,
    org.apache.harmony.tests.java.net.UnknownServiceExceptionTest.class,
    org.apache.harmony.tests.java.net.SocketExceptionTest.class,
    org.apache.harmony.tests.java.net.SocketImplTest.class,
    org.apache.harmony.tests.java.net.SocketTest.class, //crash
    org.apache.harmony.tests.java.net.SocketTimeoutExceptionTest.class, //crash 
    org.apache.harmony.tests.java.net.ProxyTest.class,
    org.apache.harmony.tests.java.net.ServerSocketTest.class, //crash 
    org.apache.harmony.luni.tests.java.net.ContentHandlerTest.class,
    org.apache.harmony.luni.tests.java.net.HttpRetryExceptionTest.class,
    org.apache.harmony.luni.tests.java.net.URLConnectionTest.class,
    org.apache.harmony.luni.tests.java.net.URLEncoderTest.class,
    libcore.java.net.CookiesTest.class,
    libcore.java.net.DatagramSocketTest.class,
    libcore.java.net.IDNTest.class,
    libcore.java.net.InetAddressTest.class,
    libcore.java.net.InetSocketAddressTest.class,
    libcore.java.net.NetworkInterfaceTest.class,
    libcore.java.net.OldAndroidDatagramTest.class,
    libcore.java.net.OldAndroidURITest.class,
    libcore.java.net.OldAuthenticatorRequestorTypeTest.class,
    libcore.java.net.OldAuthenticatorTest.class,
    libcore.java.net.OldDatagramPacketTest.class,
    libcore.java.net.OldDatagramSocketImplFactoryTest.class,
    libcore.java.net.OldFileNameMapTest.class,
    libcore.java.net.OldHttpRetryExceptionTest.class,
    libcore.java.net.OldJarURLConnectionTest.class,
    libcore.java.net.OldPasswordAuthenticationTest.class,
    libcore.java.net.OldProxyTest.class,
    libcore.java.net.OldURITest.class,
    libcore.java.net.OldURLStreamHandlerTest.class,
    libcore.java.net.OldURLTest.class,
    libcore.java.net.OldUnixSocketTest.class,
    libcore.java.net.ProxySelectorTest.class,
    libcore.java.net.URITest.class,
    libcore.java.net.URLTest.class,
    libcore.java.net.UrlEncodingTest.class,
    libcore.java.net.URLStreamHandlerFactoryTest.class,
    libcore.java.net.OldSocketImplFactoryTest.class,
    libcore.java.net.OldServerSocketTest.class,
    libcore.java.net.OldSocketTest.class,
    libcore.java.net.ServerSocketTest.class,
    libcore.java.net.OldCookieHandlerTest.class,
    libcore.java.net.OldURLClassLoaderTest.class, //crash
    libcore.java.net.ConcurrentCloseTest.class,   //crash
    libcore.java.net.SocketTest.class,         //crash 
    libcore.java.net.URLConnectionTest.class, //crash*/
    org.apache.harmony.luni.tests.internal.net.www.protocol.http.HttpURLConnectionTest.class, //crash
    org.apache.harmony.luni.tests.internal.net.www.protocol.https.HttpsURLConnectionTest.class,

})
public class JunitExtJavaNet {
}