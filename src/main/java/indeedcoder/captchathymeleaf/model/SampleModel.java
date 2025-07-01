package indeedcoder.captchathymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SampleModel {

	private String name;
	private Integer age;
	private String captchaBase64;
	private String captchaAnswerActual;
	private String captchaAnswerUser;
}
