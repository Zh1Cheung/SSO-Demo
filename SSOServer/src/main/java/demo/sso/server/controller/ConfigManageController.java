package demo.sso.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.sso.server.Config;

/**
 * 只是一个演示性的配置管理控制器
 *
 * @author : Zh1Cheung 945503088@qq.com
 * @date : 2018/6/6 20:20
 */
@Controller
public class ConfigManageController {

	@Autowired
	private Config config;

	@RequestMapping("/config")
	public void configPage() {
	}

	@RequestMapping("/config/refresh")
	@ResponseBody
	public boolean config(String code) throws Exception {
		if ("test".equals(code)) {

			config.refreshConfig();
			return true;
		}

		return false;
	}
}
