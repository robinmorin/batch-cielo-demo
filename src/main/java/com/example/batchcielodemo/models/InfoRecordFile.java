package com.example.batchcielodemo.models;


import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoRecordFile {

    private Integer idRecord;
    private String nameInfo;
    private String addressInfo;
    private String phoneInfo;

}
