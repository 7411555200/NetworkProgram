package com.gd.network.auth.model.dto;

import lombok.Data;

/**
 * @Author: BinBin
 * @Date: 2023/04/26/09:50
 * @Description:
 */
@Data
public class LoginDto {
    private String account;

    private String password;
}
