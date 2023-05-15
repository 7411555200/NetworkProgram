package com.gd.network.role.service;

import com.gd.network.common.vo.DataTablesResult;
import com.gd.network.role.model.dto.CreateRoleDto;
import com.gd.network.role.model.pojo.TRole;
import org.springframework.stereotype.Service;

/**
 * @Author: BinBin
 * @Date: 2023/05/15/11:07
 * @Description:
 */
@Service
public interface RoleService {

    /**
     * 创建权限
     * @param createRoleDto
     * @return
     */
    int create(CreateRoleDto createRoleDto);

    /**
     * 根据ID查询权限
     * @param id
     * @return
     */
    TRole findRoleById(Integer id);

    /**
     * 分页多条件查询权限
     * @param start
     * @param length
     * @param search
     * @return
     */
    DataTablesResult findRoleListData(Integer start, Integer length, String search);

    /**
     * 编辑权限
     * @param tRole
     * @return
     */
    boolean update(TRole tRole);

    /**
     * 删除权限
     * @param id
     * @return
     */
    boolean delete(Integer id);

}
