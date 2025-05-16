package edu.kiligoy.lab8.item;

/*
@author   Dtest
@project   lab5
@class  AuditMetaData
@version  1.0.0
@since 08.04.2025 - 13.10
*/

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@NoArgsConstructor
@Data
public class AuditMetaData {

    @CreatedDate
    @NonNull
    private LocalDateTime createdDate;
    @CreatedBy
    @NonNull
    private String createdBy;
    @LastModifiedDate
    @Nullable
    private LocalDateTime lastModifiedDate;
    @Nullable
    @LastModifiedBy
    private String lastModifiedBy;



}