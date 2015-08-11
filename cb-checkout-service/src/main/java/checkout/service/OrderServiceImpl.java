package checkout.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class OrderServiceImpl implements OrderService {

    private final AtomicLong counter = new AtomicLong();

    private RestTemplate restTemplate = new RestTemplate();
    
    @Value("${payment.service.url:http://localhost:8090/payment}")
    private String paymentServiceEndpoint;
    
	@Override
	@HystrixCommand(fallbackMethod="purchaseFallBack")
	public Order purchaseOrder() {
		restTemplate.getForObject(paymentServiceEndpoint, Payment.class);
		return new Order(counter.incrementAndGet(), "Hello Order");	
	}

	public Order purchaseFallBack() {
		return new Order(counter.incrementAndGet(), "Hello FallbackOrder");	
	}
}
