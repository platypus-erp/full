package org.platypus.builder.core.records.manager;

import org.apache.commons.lang3.StringUtils;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.builder.core.records.manager.astvisitor.AstModel;
import orp.platypus.impl.module.MetaInfoRecordCollectionImpl;
import orp.platypus.impl.module.MetaInfoRecordImpl;

import java.util.Optional;

/**
 * @author chmuchme
 * @since 0.1
 * on 07/05/17.
 */
public class AstModelHelper {

    public static Optional<MetaInfoRecordCollection> convertToRecordCollection(String currentModuleName, AstModel astModel){
        if (!astModel.isRootModel() || !astModel.isValidModel()){
            return Optional.empty();
        }
        String recordClassName = StringUtils.capitalize(currentModuleName)
                + StringUtils.capitalize(astModel.getClassName())
                + "RecordCollection";
        MetaInfoRecordCollectionImpl rcImpl = new MetaInfoRecordCollectionImpl(
                astModel.getPkg() + ".generated.records",
                recordClassName,
                astModel.getModelName(),
                astModel.getClassName(),
                astModel.getPkg()
        );
        return Optional.of(rcImpl);
    }
    public static Optional<MetaInfoRecord> convertToRecord(String currentModuleName, AstModel astModel){
        if (!astModel.isValidModel()){
            return Optional.empty();
        }
        String recordClassName = StringUtils.capitalize(currentModuleName)
                + StringUtils.capitalize(astModel.getClassName())
                + "Record";
        MetaInfoRecordImpl i = new MetaInfoRecordImpl(
                astModel.getPkg() + ".generated.records",
                recordClassName,
                astModel.getModelName(),
                astModel.getClassName(),
                astModel.getPkg()
        );
        return Optional.of(i);
    }


}
