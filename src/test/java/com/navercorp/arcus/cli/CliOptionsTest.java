package com.navercorp.arcus.cli;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by charsyam on 2015. 12. 28..
 */
public class CliOptionsTest {
    @Test
    public void TestCliOptionsWithHost() throws Exception {
        String [] args = {"-h", "abc.com:2181", "-c", "charsyam", "cluster_info"};
        CliOptions options = new CliOptions();
        options.parse(args);
        Assert.assertEquals(options.getHosts(), args[1]);
        Assert.assertEquals(options.getCmd(), args[4]);
    }

    @Test
    public void TestCliOptionsWithNoHost() throws Exception {
        String [] args = {"-c", "charsyam", "cluster_info"};
        CliOptions options = new CliOptions();
        options.parse(args);
        Assert.assertEquals(options.getHosts(), "localhost:2181");
        Assert.assertEquals(options.getCmd(), args[2]);
    }

}
