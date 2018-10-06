package demo.sso.server.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * 登录页前置处理器
 *
 * @author : Zh1Cheung 945503088@qq.com
 * @date : 2018/6/6 20:21
 */
public interface IPreLoginHandler {

	public static final String SESSION_ATTR_NAME = "login_session_attr_name";

	/**
	 * 前置处理
	 */
	public abstract Map<?, ?> handle(HttpSession session) throws Exception;
}
