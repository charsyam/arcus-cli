// ArcusCli.java

package com.navercorp.arcus.cli;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import net.spy.memcached.ArcusClient;
import net.spy.memcached.ConnectionFactoryBuilder;
import org.apache.commons.lang3.StringUtils;

public class ArcusCli {

    private String arcusAdmin;
    private String serviceCode;
    private ArcusClient arcusClient;

    public ArcusCli(String arcusAdmin, String serviceCode) {
        this.arcusAdmin = arcusAdmin;
        this.serviceCode = serviceCode;

        // Arcus 클라이언트 객체를 생성합니다.
        // - arcusAdmin : Arcus 캐시 서버들의 그룹을 관리하는 admin 서버(ZooKeeper)의 주소입니다.
        // - serviceCode : 사용자에게 할당된 Arcus 캐시 서버들의 집합에 대한 코드값입니다.
        // - connectionFactoryBuilder : 클라이언트 생성 옵션을 지정할 수 있습니다.
        //
        // 정리하면 arcusAdmin과 serviceCode의 조합을 통해 유일한 캐시 서버들의 집합을 얻어 연결할 수 있는 것입니다.
        this.arcusClient = ArcusClient.createArcusClient(arcusAdmin, serviceCode, new ConnectionFactoryBuilder());
    }

    public void main(String [] args) {
        CliOptions options = new CliOptions();
        try {
            options.parse(args);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ArcusCli cli = new ArcusCli(options.getHosts(), "00");
        if (StringUtils.equalsIgnoreCase(options.getCmd(), "cluster_info")) {
            Collection<SocketAddress> nodes = arcusClient.getAvailableServers();
            int count = 0;
            for (SocketAddress node : nodes) {
                System.out.println("node(" + i + ") -> " + node.toString());
            }
        }
    }
}