package demo.sso.server.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.sso.server.Config;
import demo.sso.server.SpringContextUtil;
import demo.sso.server.TokenManager;
import demo.sso.server.model.LoginUser;
import demo.sso.server.service.UserSerializer;

/**
 *
 * 提供系统内网间VT验证服务
 *
 * @author : Zh1Cheung 945503088@qq.com
 * @date : 2018/6/6 20:21
 */

@WebServlet("/validate_service")
public class ValidateServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        // 客户端传来的vt
        String vt = request.getParameter("vt");
        LoginUser user = null;

        // 验证vt有效性
        if (vt != null) {
            user = TokenManager.validate(vt);
        }

        // 返回结果
        Config config = SpringContextUtil.getBean(Config.class);
        UserSerializer userSerializer = config.getUserSerializer();
        try {
            response.getWriter().write(userSerializer.serial(user));
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

}
