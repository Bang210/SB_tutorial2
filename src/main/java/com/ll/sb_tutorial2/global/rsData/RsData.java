package com.ll.sb_tutorial2.global.rsData;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;
}
