package com.gd.network.command.service;

import com.gd.network.common.vo.DataTablesResult;
import com.gd.network.command.model.dto.CreateCommandDto;
import com.gd.network.command.model.pojo.TCommand;
import org.springframework.stereotype.Service;

/**
 * @Author: BinBin
 * @Date: 2023/05/12/13:21
 * @Description:
 */
@Service
public interface CommandService {

    /**
     * 创建命令
     * @param createCommandDto
     * @return
     */
    boolean create(CreateCommandDto createCommandDto);

    /**
     * 分页条件查询命令
     * @param start
     * @param length
     * @param search
     * @return
     */
    DataTablesResult findCommandListData(Integer start, Integer length, String search);

    /**
     * 编辑命令
     * @param tCommand
     * @return
     */
    boolean update(TCommand tCommand);

    /**
     * 删除命令
     * @param id
     * @return
     */
    boolean delete(Integer id);

}
