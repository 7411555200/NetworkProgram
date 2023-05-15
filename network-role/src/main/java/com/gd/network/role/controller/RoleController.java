package com.gd.network.role.controller;

import com.gd.network.common.vo.DataTablesResult;
import com.gd.network.common.vo.Render;
import com.gd.network.role.model.dto.CreateRoleDto;
import com.gd.network.role.model.pojo.TRole;
import com.gd.network.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: BinBin
 * @Date: 2023/05/15/11:19
 * @Description:
 */
@RestController
@RequestMapping(value = "/role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("create")
    public Object create(@RequestBody CreateRoleDto createRoleDto) {
        int result = roleService.create(createRoleDto);
        if (result == -1) {
            return Render.fail("Write database exception");
        }
        else if (result == 0) {
            return Render.fail("Field name cannot be empty");
        }
        else if (result == 2) {
            return Render.fail("The permission name already exists");
        }
        return Render.ok("Successfully added permissions");
    }

    @GetMapping("get")
    public Object findRoleById(@RequestParam("id") Integer id) {
        TRole result = roleService.findRoleById(id);
        return Render.ok(result);
    }

    @GetMapping("get/list")
    public Object findRoleListData(@RequestParam("start") Integer start,
                                   @RequestParam("length") Integer length,
                                   @RequestParam("search") String search) {
        DataTablesResult result = roleService.findRoleListData(start, length, search);
        return Render.ok(result);
    }

    @PostMapping("update")
    public Object update(@RequestBody TRole tRole) {
        boolean result = roleService.update(tRole);
        return Render.ok(result);
    }

    @PostMapping("delete")
    public Object delete(@RequestParam("id") Integer id) {
        boolean result = roleService.delete(id);
        return Render.ok(result);
    }

}
