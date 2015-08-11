package payment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	private long sleepTime = 0;
	
    @RequestMapping("/payment")
    public Payment payment() {
    	
    	sleepNow();
    	
        return new Payment();
    }

	private void sleepNow() {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
    @RequestMapping("/sleep")
    public long sleep(@RequestParam(value="time") long time) {
        sleepTime  = time;
        return sleepTime;
    }
    
}
