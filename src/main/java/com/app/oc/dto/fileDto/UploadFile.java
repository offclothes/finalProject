package com.app.oc.dto.fileDto;



import com.app.oc.entity.File;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class UploadFile {

    private Long item_seq;
    private String storeFileName; // 파일 저장명 
    private String updateDate; // update 날짜
    private String filename; // 파일 실제 이름




    public UploadFile(String storeFileName, String updateDate,String filename) {
        this.storeFileName = storeFileName;
        this.updateDate = updateDate;
        this.filename = filename;
    }

    public UploadFile(File file) {
        this.item_seq = file.getItem().getItemId();
        this.storeFileName = file.getStorefile();
        this.updateDate = file.getDatePath();
        this.filename = file.getFilename();

    }


    public File toEntity() {
        return File.builder()
                .datePath(updateDate)
                .storefile(storeFileName)
                .filename(filename)
                .build();
    }
}
