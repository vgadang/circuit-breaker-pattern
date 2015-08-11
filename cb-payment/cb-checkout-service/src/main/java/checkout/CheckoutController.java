package checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import checkout.service.Order;
import checkout.service.OrderService;

@RestController
public class CheckoutController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order")
    public Order purchaseOrder() {
		return orderService.purchaseOrder();
    }
	
	@RequestMapping("/status")
    public int status() {
		return 1;
    }
	
}
