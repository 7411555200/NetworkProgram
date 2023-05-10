package com.gd.network.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gd.network.auth.mapper.TbUserMapper;
import com.gd.network.auth.model.dto.LoginDto;
import com.gd.network.auth.model.pojo.TUser;
import com.gd.network.model.vo.Render;
import com.gd.network.auth.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: BinBin
 * @Date: 2023/05/10/15:05
 * @Description:
 */
@RestController
@RequestMapping("/auth/")
public class AuthenticationController {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("login")
    public Object login(@RequestBody LoginDto loginDto){
        TUser tbUser = tbUserMapper.selectOne(new QueryWrapper<TUser>().eq("account", loginDto.getAccount()));
        if (tbUser != null && bCryptPasswordEncoder.matches(loginDto.getPassword(), tbUser.getPassword())) {
            String jwt = JwtTokenUtil.createToken(tbUser.getAccount(),"");
            return Render.ok(jwt);
        }
        return Render.fail("Login Failed");
    }
}
