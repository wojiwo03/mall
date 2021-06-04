package com.wojiwo.auth.security;

import com.wojiwo.auth.entity.TbFunction;
import com.wojiwo.auth.entity.TbRole;
import com.wojiwo.auth.mapper.TbFunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    TbFunctionMapper tbFunctionMapper;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<TbFunction> tbFunctionList = tbFunctionMapper.selectFRAll();
        for (TbFunction tbFunction : tbFunctionList) {
            if (antPathMatcher.match(tbFunction.getUrl(), requestUrl)) {
                List<TbRole> tbRoleList = tbFunction.getTbRoleList();
                String[] roleNames = new String[tbRoleList.size()];
                for (int i = 0; i < tbRoleList.size(); i++) {
                    roleNames[i] = "ROLE_" + tbRoleList.get(i).getName();
                }
                return SecurityConfig.createList(roleNames);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
