package com.wojiwo.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wojiwo.auth.entity.TbRole;
import com.wojiwo.auth.entity.TbUser;
import com.wojiwo.auth.mapper.TbUserMapper;
import com.wojiwo.auth.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser>
        implements TbUserService {
    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TbUser tbUser = tbUserMapper.selectOneByUsername(s);
        if (tbUser == null) {
            throw new UsernameNotFoundException("账户不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList();
        for (TbRole tbRole : tbUser.getTbRoleList()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + tbRole.getName()));
        }
        tbUser.setAuthorities(authorities);
        System.out.println(tbUser);
        return tbUser;
    }
}




