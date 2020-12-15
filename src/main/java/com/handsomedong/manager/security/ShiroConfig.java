package com.handsomedong.manager.security;


import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    @Bean
    public Realm realm() {
        return new UserRealm();
    }

    // @Bean
    // public SecurityManager securityManager() {
    //     DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    //     //设置realm
    //     securityManager.setRealm(realm());
    //     securityManager.setCacheManager(cacheManager());
    //     securityManager.setSessionManager(sessionManager());
    //     return securityManager;
    // }
    //
    // /**
    //  * Session Manager
    //  * 使用的是shiro-redis开源插件
    //  */
    // private DefaultWebSessionManager sessionManager() {
    //     DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
    //     sessionManager.setSessionDAO(redisSessionDAO());
    //     return sessionManager;
    // }
    //
    // /**
    //  * RedisSessionDAO shiro sessionDao层的实现 通过redis
    //  * 使用的是shiro-redis开源插件
    //  */
    // private RedisSessionDAO redisSessionDAO() {
    //     RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
    //     redisSessionDAO.setRedisManager(redisManager());
    //     return redisSessionDAO;
    // }
    //
    // /**
    //  * cacheManager 缓存 redis实现
    //  * 使用的是shiro-redis开源插件
    //  *
    //  * @return RedisCacheManager
    //  */
    // private RedisCacheManager cacheManager() {
    //     RedisCacheManager redisCacheManager = new RedisCacheManager();
    //     redisCacheManager.setRedisManager(redisManager());
    //     return redisCacheManager;
    // }
    //
    // /**
    //  * 配置shiro redisManager
    //  * 使用的是shiro-redis开源插件
    //  *
    //  * @return RedisManager
    //  */
    // @Bean
    // public RedisManager redisManager() {
    //     RedisManager redisManager = new RedisManager();
    //     //        RedisManager redisManager = new RedisManager();
    //     //        redisManager.setHost(host);
    //     //        redisManager.setPort(port);
    //     //        // 配置缓存过期时间
    //     //        redisManager.setExpire(expireTime);
    //     //        redisManager.setTimeout(timeOut);
    //     // redisManager.setPassword(password);
    //     return redisManager;
    // }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
        //可以匿名访问的url
        chain.addPathDefinition("/login", "anon");
        chain.addPathDefinition("/logout", "anon");
        chain.addPathDefinition("/401", "anon");
        chain.addPathDefinition("/403", "anon");
        //其它的都需要登录
        chain.addPathDefinition("/**", "authc");
        return chain;
    }
}
