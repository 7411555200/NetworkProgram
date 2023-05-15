package com.gd.network.server.model.dto;


import lombok.Data;

@Data
public class CreateServerDto {

    private String serverName;
    private String ip;
    private String user;
    private String password;
    private String serverFactory;
    private String serverModel;
    private String physicalLocation;


}
