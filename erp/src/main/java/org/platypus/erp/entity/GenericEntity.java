package org.platypus.erp.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface GenericEntity {

    @Id
    @NotNull
//    @UniqueColumn
//    @OnPreperist
//    @PlatypusColumn("id")
    long id = 0;

    @NotBlank
    @Size(max = 100)
    @Column(name = "methodName")
    String name = null;

    @Size(max = 100)
    @Column(name = "code")
    String code = null;

    @NotNull
    @Version
    @Column(name = "version")
    long version = 0;

    @NotNull
//    @OnPreperist
    @Column(updatable = false, name = "create_date")
    LocalDateTime createDate = LocalDateTime.now();

//    @OnPreUpdate
    @Column(updatable = true, name = "write_date")
    LocalDateTime writeDate = LocalDateTime.now();

    String getTableName();

    long getId();


    void setId(long id);

    LocalDateTime getCreateDate();

    void setCreateDate(LocalDateTime createDate);

    LocalDateTime getWriteDate();

    void setWriteDate(LocalDateTime createDate);

    String getName();

    void setName(String name);

    String getCode();

    void setCode(String code);

    long getVersion();
}
