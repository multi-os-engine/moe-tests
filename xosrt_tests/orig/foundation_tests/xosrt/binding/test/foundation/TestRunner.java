package xosrt.binding.test.foundation;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.Request;

import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class TestExecutor extends Thread {
    public volatile Result res = null;
    private Request request = null;

    TestExecutor(Class someClass, String methodName) {
        request = Request.method(someClass, methodName);
    }

    public void run() {
        res = new JUnitCore().run(request);
    }
}

public class TestRunner {

    public static void main (String[] args) throws Exception {
        String[] classAndMethos = args[0].split("#");
        Request request = Request.method(Class.forName(classAndMethos[0]), classAndMethos[1]);

        Result res = new JUnitCore().run(request);
        if (res.getFailureCount() > 0) {
            System.out.println("FAILED");
        } else {
            System.out.println("PASSED");
        }
        //System.out.println("Total: " + total + ", Failed: " + failed + ", Ignored: " + ignored);
    }
}
