package com.gd.network.common.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author: BinBin
 * @Date: 2023/04/10/15:01
 * @Description:
 */
@Data
@Accessors(chain = true)
public class DataTablesResult {

    private Long pages;

    private Long current;

    private List<?> data;

}
