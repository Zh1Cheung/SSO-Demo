package demo.sso.server.service;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import demo.sso.server.model.LoginUser;

/**
 * 用户信息序列化工具
 *
 * @author : Zh1Cheung 945503088@qq.com
 * @date : 2018/6/6 20:21
 */
public abstract class UserSerializer {

    /**
     * 用户数据类型
     * 
     * @author Administrator
     *
     */
    protected class UserData {
        private String id; // 唯一标识
        private Map<String, Object> properties = new HashMap<String, Object>(); // 其它属性

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Map<String, Object> getProperties() {
            return properties;
        }

        public void setProperties(Map<String, Object> properties) {
            this.properties.putAll(properties);
        }

        // 新增单个属性
        public void setProperty(String key, Object value) {
            this.properties.put(key, value);
        }

    }

    /**
     * 数据转换
     * 
     * @param loginUser
     * @param userDate
     * @throws Exception
     */
    protected abstract void translate(LoginUser loginUser, UserData userData) throws Exception;

    /**
     * 序列化
     * 
     * @param loginUser
     * @return
     * @throws Exception
     */
    public String serial(LoginUser loginUser) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        UserData userData = new UserData();
        
        // 在继承的具体实现类中完成转换
        if (loginUser != null) {
            translate(loginUser, userData);
        }

        return mapper.writeValueAsString(userData);
    }
}
