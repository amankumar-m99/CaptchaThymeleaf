package indeedcoder.captchathymeleaf.captcha;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import cn.apiclub.captcha.Captcha;

public class CaptchaUtil {

	private CaptchaUtil() {}

	public static Captcha generateCaptcha(int width, int height) {
		return new Captcha.Builder(width, height)
				.addBackground()
				.addText()
				.addNoise()
				.build();
	}

	public static String encodeBase64(Captcha captcha) {
		String imageBase64 = "";
		try {
			String fileExtension = "png";
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(captcha.getImage(), fileExtension, os);
			byte[] arr = Base64.getEncoder().encode(os.toByteArray());
			imageBase64 = new String(arr);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return imageBase64;
	}
}
