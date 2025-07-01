package indeedcoder.captchathymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cn.apiclub.captcha.Captcha;
import indeedcoder.captchathymeleaf.captcha.CaptchaUtil;
import indeedcoder.captchathymeleaf.model.SampleModel;

@Controller
public class MainController {

	@GetMapping("/")
	public String getHomePage(Model m) {
		Captcha captcha = CaptchaUtil.generateCaptcha(120, 80);
		String captchaAnswer = captcha.getAnswer();
		String captchaBase64 = CaptchaUtil.encodeBase64(captcha);
		SampleModel s = new SampleModel("", null, captchaBase64, captchaAnswer, "");
		m.addAttribute("backendData", s);
		return "HomePage";
	}

	@PostMapping("/save")
	public String saveData(@ModelAttribute SampleModel sm, Model m) {
		String s = (sm.getCaptchaAnswerActual().equals(sm.getCaptchaAnswerUser()))?"PASS":"FAIL";
		m.addAttribute("data", sm);
		m.addAttribute("captchaStatus", s);
		return "ResultPage";
	}

}
