package com.gd.network.auth.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

/**
 * @Author: BinBin
 * @Date: 2023/05/10/14:55
 * @Description:
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TRole implements GrantedAuthority {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;         // 自增ID

    private String role_name;   // 规则名称

    private String role_desc;   // 规则描述

    @JsonIgnore
    @Override
    public String getAuthority() {
        return role_name;
    }
}
