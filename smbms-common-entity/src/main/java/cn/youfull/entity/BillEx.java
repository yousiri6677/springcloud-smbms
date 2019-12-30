package cn.youfull.entity;

import lombok.Data;

@Data
public class BillEx extends Bill {

    private Provider provider;
    private String creationDateStr;
}
