package com.gd.network.command.controller;

import com.gd.network.common.vo.DataTablesResult;
import com.gd.network.command.model.dto.CreateCommandDto;
import com.gd.network.command.model.pojo.TCommand;
import com.gd.network.command.service.CommandService;
import com.gd.network.common.vo.Render;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: BinBin
 * @Date: 2023/05/12/13:36
 * @Description:
 */
@RestController
@RequestMapping(value = "/command/")
public class CommandController {

    @Autowired
    private CommandService commandService;

    @PostMapping("create")
    public Object create(@RequestBody CreateCommandDto createCommandDto) {
        boolean result = commandService.create(createCommandDto);
        if (!result) {
            return Render.fail("Failed to add command");
        }
        return Render.ok(true);
    }

    @GetMapping("get")
    public Object findCommandById(@RequestParam("id") Integer id) {
        TCommand tCommand = commandService.findCommandById(id);
        return Render.ok(tCommand);
    }

    @GetMapping("get/list")
    public Object findCommandListData(@RequestParam("start") Integer start,
                                                @RequestParam("length") Integer length,
                                                @RequestParam("search") String search) {
        DataTablesResult result = commandService.findCommandListData(start, length, search);
        return Render.ok(result);
    }

    @PostMapping("update")
    public Object update(@RequestBody TCommand tCommand) {
        boolean result = commandService.update(tCommand);
        if (!result) {
            return Render.fail("Failed to update command");
        }
        return Render.ok(true);
    }

    @PostMapping("delete")
    public Object delete(@RequestParam("id") Integer id) {
        boolean result = commandService.delete(id);
        if (!result) {
            return Render.fail("Failed to delete command");
        }
        return Render.ok(true);
    }

}
