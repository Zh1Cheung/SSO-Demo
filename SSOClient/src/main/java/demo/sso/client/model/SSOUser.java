package demo.sso.client.model;

import java.io.Serializable;
import java.util.Set;

/**
 * 当前登录用户
 * 
 * @author preach
 *
 */
public interface SSOUser extends Serializable {

    /**
     * 能够区分用户的唯一标识
     * 
     * @return
     */
    public String getId();

    /**
     * 按名称获取用户属性值
     * 
     * @param propertyName
     * @param type
     * @return
     */
    public Object getProperty(String propertyName);

    /**
     * 获取所有可用属性名集合
     * 
     * @return
     */
    public Set<String> propertyNames();
}
