package com.gd.network.command.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gd.network.common.vo.DataTablesResult;
import com.gd.network.command.mapper.TbCommandMapper;
import com.gd.network.command.model.dto.CreateCommandDto;
import com.gd.network.command.model.pojo.TCommand;
import com.gd.network.command.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: BinBin
 * @Date: 2023/05/12/13:21
 * @Description:
 */
@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    private TbCommandMapper tbCommandMapper;

    @Override
    public boolean create(CreateCommandDto createCommandDto) {
        if (createCommandDto.getCommand().isEmpty()) {
            return false;
        }
        TCommand tCommand = new TCommand();
        tCommand.setCommand(createCommandDto.getCommand())
                .setDescription(createCommandDto.getDescription())
                .setCreated(new Date())
                .setUpdated(new Date());
        return tbCommandMapper.insert(tCommand) == 1;
    }

    @Override
    public DataTablesResult findCommandListData(Integer start, Integer length, String search) {
        DataTablesResult result = new DataTablesResult();
        LambdaQueryWrapper<TCommand> lambdaQueryWrapper = Wrappers.lambdaQuery();
        lambdaQueryWrapper.orderByDesc(TCommand::getCreated);
        Page<TCommand> page = new Page<>(start,length);
        IPage<TCommand> iPage = tbCommandMapper.selectPage(page, lambdaQueryWrapper);
        result.setPages(iPage.getPages())
                .setCurrent(iPage.getCurrent())
                .setData(iPage.getRecords());
        return result;
    }

    @Override
    public boolean update(TCommand tCommand) {
        if (tCommand.getCommand().isEmpty()) {
            return false;
        }
        TCommand inTCommand = tbCommandMapper.selectById(tCommand.getId());
        inTCommand.setCommand(tCommand.getCommand())
                .setDescription(tCommand.getDescription())
                .setUpdated(new Date());
        return tbCommandMapper.updateById(inTCommand) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return tbCommandMapper.deleteById(id) == 1;
    }
}
