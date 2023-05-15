package com.gd.network.role.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: BinBin
 * @Date: 2023/05/15/10:58
 * @Description:
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TRole {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String role_name;

    private String role_desc;
}
