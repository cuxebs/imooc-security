package com.imooc.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * LN
 * 2019/9/6 0006 14:48
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    //处理用户信息获取逻辑
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据用户名查找用户信息
        logger.info("登录用户名：" + s);
        //验证用户s的密码是否为12313，后边的参数是：验证通过后该用户有哪些权限
        return new User(s, "12313", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
