package com.gd.network.command.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author: BinBin
 * @Date: 2023/05/12/13:16
 * @Description:
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TCommand {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String command;

    private String description;

    private Date created;

    private Date updated;

}
