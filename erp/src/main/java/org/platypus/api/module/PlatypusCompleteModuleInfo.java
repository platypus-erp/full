package org.platypus.api.module;


import java.util.Locale;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface PlatypusCompleteModuleInfo extends ModuleInfo, ModelOfModuleInfo, RecordOfModuleInfo {

    String getLongDecription();

    String getShortDecription();

    Set<Locale> getI18n();

    Set<String> getRefData();

    Set<String> getDemoData();

    Set<String> getViews();

    Set<String> getMenus();


}
