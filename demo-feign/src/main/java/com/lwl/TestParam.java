package com.lwl;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;

/**
 * <p>Title: TestParam</p>
 * <p>Description: TestParam</p>
 * <p>Company: sanjieke</p>
 *
 * @author liuweilong
 * @version 1.0
 * @date 2020/10/29
 */
@Data
public class TestParam {
    private String name;

    public static void main(String[] args) {
        final ArrayList<String> strings = Lists.newArrayList("1", "2", "3", "4");
        TestParam param = new TestParam();
        param.setName("shit");
        final TestParam reduce = strings.parallelStream()
                // invoke each individual capability and feed the result to the next one.
                // This is equivalent to:
                // Capability cap1 = ...;
                // Capability cap2 = ...;
                // Capability cap2 = ...;
                // Contract contract = ...;
                // Contract contract1 = cap1.enrich(contract);
                // Contract contract2 = cap2.enrich(contract1);
                // Contract contract3 = cap3.enrich(contract2);
                // or in a more compact version
                // Contract enrichedContract = cap3.enrich(cap2.enrich(cap1.enrich(contract)));
                .reduce(
                        param,
                        (result, capability) -> {
                            result.setName(result.getName() + capability);
                            return result;
                        },
                        (component, enrichedComponent) -> {
                            return enrichedComponent;
                        });
        System.out.println();
    }
}
