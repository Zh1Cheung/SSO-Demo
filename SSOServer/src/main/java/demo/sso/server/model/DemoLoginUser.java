package demo.sso.server.model;



/**
 *
 * @author : Zh1Cheung 945503088@qq.com
 * @date : 2018/6/6 20:20
 */


@SuppressWarnings("serial")
public class DemoLoginUser extends LoginUser {

	private String loginName;

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginName() {
		return loginName;
	}
	
	public String getPasswd() {
		return "admin";
	}

	@Override
	public String toString() {
		return loginName;
	}
}
