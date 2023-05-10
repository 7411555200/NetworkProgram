package com.gd.network.auth.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author: BinBin
 * @Date: 2023/05/10/14:52
 * @Description:
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TUser {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String account;

    private String password;

    private String name;

    private int status;

    private Date created;

    private Date updated;

}
