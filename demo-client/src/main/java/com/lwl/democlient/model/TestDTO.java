package com.lwl.democlient.model;

import lombok.Data;

/**
 * <p>Title: TestDTO</p>
 * <p>Description: TestDTO</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/8/3
 */
@Data
public class TestDTO {
    private String instanceId;
    private String instanceName;
    private InstanceStatus status;

    public static enum InstanceStatus {
        UP,
        DOWN
    }
}
