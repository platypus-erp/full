package org.platypus.api.module;


import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface PlatypusCompleteModuleInfo extends ModuleInfo, ModelOfModuleInfo {

    String getLongDecription();

    String getShortDecription();

    Map<String, MetaInfoRecordCollection> getRecordCollection();

    Map<String, ModelOfModulInfo> getRecord();

    Map<Locale, Map<String, String>> getI18n();

    Set<String> getRefData();

    Set<String> getDemoData();

    Map<String, String> getViews();

    Map<String, String> getMenus();


}
