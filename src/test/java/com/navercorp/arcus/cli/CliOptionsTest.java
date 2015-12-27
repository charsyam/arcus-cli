package com.navercorp.arcus.cli;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by charsyam on 2015. 12. 28..
 */
public class CliOptionsTest {
    @Test
    public void TestCliOptionsWithHost() throws Exception {
        String [] args = {"java", "-h", "abc.com:2181", "cluster_info"};
        CliOptions options = new CliOptions();
        options.parse(args);
        Assert.assertEquals(options.getHosts(), args[2]);
        Assert.assertEquals(options.getCmd(), args[3]);
    }

    @Test
    public void TestCliOptionsWithNoHost() throws Exception {
        String [] args = {"java", "cluster_info"};
        CliOptions options = new CliOptions();
        options.parse(args);
        Assert.assertEquals(options.getHosts(), "localhost:2181");
        Assert.assertEquals(options.getCmd(), args[1]);
    }

}
