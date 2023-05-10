package com.gd.network.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gd.network.auth.mapper.TbRoleMapper;
import com.gd.network.auth.mapper.TbUserMapper;
import com.gd.network.auth.mapper.TbUserRoleMapper;
import com.gd.network.auth.model.pojo.TRole;
import com.gd.network.auth.model.pojo.TUser;
import com.gd.network.auth.model.pojo.TUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: BinBin
 * @Date: 2023/04/25/16:27
 * @Description: 验证token中信息是否允许访问
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private TbUserRoleMapper tbUserRoleMapper;
    @Autowired
    private TbRoleMapper tbRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        TUser tbUser = tbUserMapper.selectOne(new QueryWrapper<TUser>().eq("account", account));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<TUserRole> tbUserRoles = tbUserRoleMapper.selectList(new QueryWrapper<TUserRole>().eq("userID", tbUser.getId()));
        tbUserRoles.forEach(tbUserRole -> {
            TRole tbRole = tbRoleMapper.selectById(tbUserRole.getRoleID());
            GrantedAuthority grantedAuthority = tbRole::getAuthority;
            grantedAuthorities.add(grantedAuthority);
        });
        return new User(tbUser.getAccount(), tbUser.getPassword(), grantedAuthorities);
    }
}

