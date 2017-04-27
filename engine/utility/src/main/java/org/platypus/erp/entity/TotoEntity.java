package org.platypus.erp.entity;

import java.time.LocalDateTime;

/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
public interface TotoEntity extends Identifiable, Namable, Codable, TableName {

    LocalDateTime getCreateDate();

    LocalDateTime getWriteDate();

}
