package com.navercorp.arcus.cli;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by charsyam on 2015. 12. 27..
 */
public class CliOptions {
    ImmutableSet<String> options = ImmutableSet.of(
            "-h",
            "-c"
            );

    private String hosts = "localhost:2181";
    private String cmd = "";

    public void parse(String [] args) throws Exception {
        if (args.length < 2) {
            throw new Exception("Invalid Parameters");
        }

        int cmdIdx = 1;
        boolean hasHost = StringUtils.equals(args[1], "-h");

        if (hasHost && args.length < 4) {
            throw new Exception("Invalid Parameters");
        }

        if (hasHost) {
            hosts = args[2];
            cmdIdx = 3;
        }


        StringBuilder sb = new StringBuilder();
        sb.append(args[cmdIdx]);
        for (int i = cmdIdx+1; i < args.length; i++) {
            sb.append(" ");
            sb.append(i);
        }

        cmd = sb.toString();
    }

    public String getHosts() {
        return hosts;
    }

    public String getCmd() {
        return cmd;
    }
}
