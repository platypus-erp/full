package org.platypus.erp.module.base.models.generated.jpa;

import org.platypus.api.fields.LongField;
import org.platypus.api.fields.impl.LongFieldImpl;
import org.platypus.api.query.QueryPath;
import org.platypus.erp.module.base.models.generated.records.BasePartnerRecord;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(
        name = ImplPartnerJPA.MODEL_NAME
)
@Entity
public class ImplPartnerJPA implements BasePartnerRecord {
    private QueryPath path = QueryPath.basic(MODEL_NAME, "id");

    public static final String MODEL_NAME = "partner";

    @Column(
            name = "\"id\"",
            nullable = true,
            insertable = true,
            updatable = true
    )
    private long id = 0;


    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    @Override
    public boolean bool() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public QueryPath getPath() {
        return path;
    }
    @Override
    public QueryPath resolve(QueryPath queryPath) {
        return getPath().resolve(queryPath);
    }
    @Override
    public void setPath(QueryPath queryPath) {
        this.path = queryPath;
    }

    @Override
    public LongField id() {
        return new LongFieldImpl(MODEL_NAME, "id", this::getPath, this::getId, this::setId);
    }
}