package org.platypus.erp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
@MappedSuperclass
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public abstract class AbstractEntity implements TotoEntity, Serializable{
    private static final long serialVersionUID = 1L;
    public static final String FIELD_NAME = "name";
    public static final String FIELD_CODE = "code";
    public static final String FIELD_ID = "id";
    public static final String FIELD_VERSION = "version";
    public static final String FIELD_CREATE_DATE = "CREATE_DATE";
    public static final String FIELD_WRITE_DATE = "WRITE_DATE";

    @Transient
    @JsonIgnore
    public final String tableName;

    @Id
    @NotNull
    @Column(unique=true, name = FIELD_ID)
    @GeneratedValue(strategy = GenerationType.TABLE)
    @JsonProperty(FIELD_ID)
    private long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = FIELD_NAME)
    @JsonProperty(FIELD_NAME)
    protected String name;

    @Size(max = 100)
    @Column(name = FIELD_CODE)
    @JsonProperty(FIELD_CODE)
    protected String code;

    @NotNull
    @Version
    @Column(name = FIELD_VERSION)
    @JsonProperty(FIELD_VERSION)
    private long version;

    @NotNull
    @Column(updatable = false, name= FIELD_CREATE_DATE)
    @JsonProperty(FIELD_CREATE_DATE)
    private LocalDateTime createDate;

    //    TODO don't work with java8 api Data/Time'
//    @Future
    @Column(updatable = true, insertable = false, name= FIELD_WRITE_DATE)
    @JsonProperty(FIELD_WRITE_DATE)
    private LocalDateTime writeDate;

    public AbstractEntity() {
        tableName = findTableAnnotation(this.getClass());
        EntityRegistry.INSTANCE.put(tableName, this.getClass());
    }

    private String findTableAnnotation(Class<?> clazz){
        if (clazz != null){
            Table table = clazz.getAnnotation(Table.class);
            if(table == null) {
                return findTableAnnotation(clazz.getSuperclass());
            } else {
                return table.name();
            }
        } else {
            throw new NullPointerException(this.getClass().getName() + " can't be used without @javax.persistence.Table");
        }
    }

    @PreUpdate
    private void preUpdate(){
        writeDate = LocalDateTime.now();
    }

    @PrePersist
    private void preInsert(){
        id = 0;
        version = 0;
        createDate = null;
        writeDate = null;
        createDate = LocalDateTime.now();
    }

    @PreRemove
    private void preDelete(){

    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public LocalDateTime getWriteDate() {
        return writeDate;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    public long getVersion() {
        return version;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
