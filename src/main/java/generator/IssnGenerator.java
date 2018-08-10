package generator;

import generator.annotation.EightDigits;
import generator.annotation.Loggable;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@EightDigits
public class IssnGenerator implements NumberGenerator {
	@Inject
	private Logger logger;
	
	@Loggable
	public String generateNumber() {
		String issn = "8-" + Math.abs(new Random().nextInt());
		logger.info("Сгененрирован ISSN : " + issn);
		return issn;
	}
}
