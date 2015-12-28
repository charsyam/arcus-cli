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
    private String hosts = "localhost:2181";
    private String serviceCode = null;
    private String cmd = "";

    public void parse(String [] args) throws Exception {
        if (args.length < 3) {
            throw new Exception("Invalid Parameters");
        }

        int cmdIdx = 2;
        boolean hasHost = false;
        boolean hasServiceCode = false;

        String arg = args[0];
        if (StringUtils.equals("-h", arg)) {
            hasHost = true;
            hosts = args[1];
        } else if (StringUtils.equals("-c", arg)) {
            hasServiceCode = true;
            serviceCode = args[1];
        }

        arg = args[2];
        if (StringUtils.equals("-h", arg)) {
            hasHost = true;
            hosts = args[3];
            cmdIdx = 4;
        } else if (StringUtils.equals("-c", arg)) {
            hasServiceCode = true;
            serviceCode = args[3];
            cmdIdx = 4;
        }

        if (serviceCode == null) {
            throw new Exception("Invalid Parameters");
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

    public String getServiceCode() {
        return serviceCode;
    }
}