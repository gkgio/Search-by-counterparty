package com.gig.gio.search_by_counterparty.common;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by georgy on 09.12.2017.
 * GIG
 */

public class OrderedRunner extends BlockJUnit4ClassRunner {

    public OrderedRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> list = super.computeTestMethods();
        List<FrameworkMethod> sorted = new ArrayList<>(list);
        Collections.sort(sorted, (f1, f2) -> {
            Order o1 = f1.getAnnotation(Order.class);
            Order o2 = f2.getAnnotation(Order.class);
            if (o1 == null || o2 == null)
                return -1;
            return o1.value() - o2.value();
        });
        return sorted;
    }
}
