package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepositoryV0;
    private final TraceTemplate trace;

    public OrderServiceV5(OrderRepositoryV5 orderRepositoryV0, LogTrace trace) {
        this.orderRepositoryV0 = orderRepositoryV0;
        this.trace = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        trace.execute("OrderServiceV1.orderItem()", () -> {
            orderRepositoryV0.save(itemId);
            return null;
        });
    }
}
