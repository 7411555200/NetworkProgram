package com.gd.network.auth.model.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: BinBin
 * @Date: 2023/05/10/14:55
 * @Description:
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TUserRole {
    private Integer userID;        // 用户ID

    private Integer roleID;        // 规则ID
}
