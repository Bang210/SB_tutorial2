package com.ll.sb_tutorial2.global.rsData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class RsData<T> {
    private final String resultCode;
    private final String msg;
    private T data;
}
