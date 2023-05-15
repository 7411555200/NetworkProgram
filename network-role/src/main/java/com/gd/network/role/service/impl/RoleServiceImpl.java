package com.gd.network.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gd.network.common.vo.DataTablesResult;
import com.gd.network.role.mapper.TbRoleMapper;
import com.gd.network.role.model.dto.CreateRoleDto;
import com.gd.network.role.model.pojo.TRole;
import com.gd.network.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: BinBin
 * @Date: 2023/05/15/11:07
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private TbRoleMapper tbRoleMapper;

    @Override
    public int create(CreateRoleDto createRoleDto) {
        if (createRoleDto.getRole_name().isEmpty() || createRoleDto.getRole_desc().isEmpty()) {
            return 0;
        }
        List<TRole> list = tbRoleMapper.selectList(new QueryWrapper<TRole>().eq("role_name", createRoleDto.getRole_name()));
        if (list.size() > 0) {
            return 2;
        }
        TRole tRole = new TRole();
        tRole.setRole_name(createRoleDto.getRole_name())
                .setRole_desc(createRoleDto.getRole_desc());
        if (tbRoleMapper.insert(tRole) != 1) {
            return -1;
        }
        return 1;
    }

    @Override
    public TRole findRoleById(Integer id) {
        return tbRoleMapper.selectById(id);
    }

    @Override
    public DataTablesResult findRoleListData(Integer start, Integer length, String search) {
        DataTablesResult result = new DataTablesResult();
        LambdaQueryWrapper<TRole> lambdaQueryWrapper = Wrappers.lambdaQuery();
        Page<TRole> page = new Page<>(start,length);
        IPage<TRole> iPage = tbRoleMapper.selectPage(page, lambdaQueryWrapper);
        result.setPages(iPage.getPages())
                .setCurrent(iPage.getCurrent())
                .setData(iPage.getRecords());
        return result;
    }

    @Override
    public boolean update(TRole tRole) {
        if (tRole.getRole_name().isEmpty() || tRole.getRole_desc().isEmpty()) {
            return false;
        }
        TRole inTRole = tbRoleMapper.selectById(tRole.getId());
        inTRole.setRole_name(tRole.getRole_name())
                .setRole_desc(tRole.getRole_desc());
        return tbRoleMapper.updateById(inTRole) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return tbRoleMapper.deleteById(id) == 1;
    }
}
