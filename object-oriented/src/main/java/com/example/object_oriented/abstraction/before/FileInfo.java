package com.example.object_oriented.abstraction.before;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileInfo {

    private CloudId cloudId;
    private String fileId;
    private String name;
    private long length;

}
