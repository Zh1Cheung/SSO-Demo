
## SSO单点登陆


### 特性

    SSO概述
    SSO相关核心技术
    同域下单点登录系统分析与设计
    同域下单点登录系统服务端实现
    同域下单点登录系统客户端实现
    跨域单点登录系统面临的问题与解决方案


### SSO相关核心技术

    1、HTTP、cookie与session
    2、cookie与session的关系
    3、cookie，SSO令牌的载体
    4、决定cookie内容、生命周期和有效范围的7个属性
    1）name & value
    2）expires
    3）path & domain
    4）httpOnly & secure
    5、JavaScript操作cookie的方法
    6、Java Web应用中操作cookie的方法
    7、filter，Web层的拦截器




![](http://i2.51cto.com/images/blog/201810/06/667e88749a8c1d637f10b7d631ae0d91.png?x-oss-process=image/watermark,size_16,text_QDUxQ1RP5Y2a5a6i,color_FFFFFF,t_100,g_se,x_10,y_10,shadow_90,type_ZmFuZ3poZW5naGVpdGk=)


![](http://i2.51cto.com/images/blog/201810/06/f46b642b4f5c9219882bcb91b9be6bb9.png?x-oss-process=image/watermark,size_16,text_QDUxQ1RP5Y2a5a6i,color_FFFFFF,t_100,g_se,x_10,y_10,shadow_90,type_ZmFuZ3poZW5naGVpdGk=)





### 跨域SSO原理与技术

    跨域SSO原理分析
    跨域读写Cookie
    跨域AJAX请求
    跨域frame通信
#### 跨域SSO原理分析


![](http://i2.51cto.com/images/blog/201810/06/b7718e8c594e13c61a6c45506ba08629.png?x-oss-process=image/watermark,size_16,text_QDUxQ1RP5Y2a5a6i,color_FFFFFF,t_100,g_se,x_10,y_10,shadow_90,type_ZmFuZ3poZW5naGVpdGk=)


#### 跨域读写Cookie

    Cookie信息跨域共享的实现：
        利用HTML Script标签跨域写Cookie
        P3P协议
        通过URL参数实现跨域信息传递
        读取其它域的Cookie信息




#### 跨域AJAX请求

    向其它域发起AJAX请求：
        通过jsonp实现跨域请求
        CORS，跨域资源共享
        两种方案对比


#### 跨域frame通信

    同一窗口中，各frame页面之间可通过JavaScript实现互访，但跨域页面间的直接调用是被阻止的：
    frame页面间通过JavaScript实现互访
    跨域时，通过域间页面跳转传参实现通信
    HTML5新API，postMessage
    postMessage通用封装




### 系统规划设计

    服务端需求介绍
    客户端模块与用户系统需求介绍
    服务端模块流程分析
    客户端模块流程分析

#### 服务端需求介绍


    核心功能需求
        用户授权认证界面及认证服务
        用户令牌生成、传递、验证服务
        单点退出功能

    易用性需求
        业务系统的统一配置管理
        集中的访问入口界面
        记住账号、密码功能
        自动登录功能

    可扩展性需求
        认证体系与用户体系的解耦
        为业务系统提供登录模块和登录接口，满足多样化的整合需求

    安全性需求
        用户认证信息的安全传输与存储
        令牌的有效期管理
        防止恶意登录

#### 客户端模块与用户系统需求介绍


    客户端模块需求
        拦截请求进行授权有效性验证
        提供访问授权用户信息的API供业务系统使用
        缓存授权信息，降低服务端压力

    用户系统的核心需求
        机构与用户数据存储体系
        基本的CRUD操作
        提供给业务系统使用的用户信息同步接口


#### 服务端模块流程分析


    服务端的核心运行流程
    自动登录功能的实现方式分析


#### 客户端模块流程分析

客户端的核心运行流程
认证授权信息缓存的实现方案分析
用户信息获取API的实现方式分析



### 服务端实现


    配置信息实时生效
    客户端系统配置管理
    支持验证码的登录页面
    单点退出
    账号信息安全传输
    自动登录功能的实现
    自动登录功能的优化实现




#### 配置信息实时生效

    
    spring bean的init-method与destroy-method属性
    配置信息动态重载



#### 客户端系统配置管理

    xml文件读取
    客户端系统信息的配置


#### 支持验证码的登录页面

    登录预处理扩展接口
    验证码生成


#### 单点退出

    单点退出接口的实现


#### 账号信息安全传输

    HTTPS安全传输
    使用MD5对敏感信息加密传输


#### 自动登录功能的实现

    自动登录流程实现
    敏感信息安全存储

#### 自动登录功能的优化实现

    实现自动登录标识失效机制
    在服务端存储自动登录状态信息








### 客户端实现

    Filter整合配置
    从服务端获取用户信息
    本地缓存与消息接口
    User信息存放与读取
    从服务端获取登录状态信息
    整合测试





#### Filter整合配置

    在业务系统web.xml中引用SSOFilter
    通过url-pattern设置拦截模式
    自定义excludes属性指定不需要拦截的资源
    自定义属性配置系统间通信地址


#### 从服务端获取用户信息


    User类接口与实现
    服务端生成User对象
    使用HttpClient实现系统间通信
    User对象序列化传输

#### 本地缓存与消息接口

    令牌本地存储实现授权状态缓存
    超时、退出、服务关闭等消息接口的实现
    
#### User信息存放与读取


    通过ThreadLocal和HttpServletRequest存放User对象
    提供UserHolder工具类供业务系统获取User信息

#### 从服务端获取登录状态信息


    引导浏览器重定向至服务端
    处理服务端发回的授权状态信息
    授权失败的处理

#### 整合测试

实现CookieSetServlet供服务端跨域写Cookie
完善配置信息实现信息整合
整合测试
