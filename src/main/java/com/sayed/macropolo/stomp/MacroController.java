package com.sayed.macropolo.stomp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MacroController {

	private static final Logger logger = LoggerFactory.getLogger(MacroController.class);

	@MessageMapping("/macro")
	@SendTo("/topic/shout")
	public Shout handleShout(Shout incoming) {
		logger.info("Received message: " + incoming.getMessage());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}

		Shout outgoing = new Shout();
		outgoing.setMessage("Polo!");

		return outgoing;
	}

	@SubscribeMapping({ "/macro" })
	public Shout handleSubscription() {
		Shout outgoing = new Shout();
		outgoing.setMessage("Polo!");
		return outgoing;
	}

}
