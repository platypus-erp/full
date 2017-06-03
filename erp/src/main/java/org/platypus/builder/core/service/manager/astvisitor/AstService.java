package org.platypus.builder.core.service.manager.astvisitor;

import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 06/05/17.
 */
public interface AstService {
    Set<BusinessMethodModel> getBusinessMultiNew();
    Set<BusinessMethodModel> getBusinessMultiExtend();
    Set<BusinessMethodModel> getBusinessEmptyNew();
    Set<BusinessMethodModel> getBusinessEmptyExtend();
    Set<BusinessMethodModel> getBusinessOneNew();
    Set<BusinessMethodModel> getBusinessOneExtend();
    Set<BusinessMethodModel> getBusinessUnAuthetificateNew();
    Set<BusinessMethodModel> getBusinessUnAuthetificateExtend();

    String getClassName();
    boolean isRootModel();
    String getModelName();
    String getPkg();
    boolean isValidModel();
}
