package org.platypus.api.module;


import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;
import org.platypus.api.BaseModel;

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
public interface PlatypusCompleteModuleInfo extends ModuleInfo, ModelOfModuleInfo, RecordOfModuleInfo {

    String getLongDecription();

    String getShortDecription();

    Set<Locale> getI18n();

    Set<String> getRefData();

    Set<String> getDemoData();

    Set<String> getViews();

    Set<String> getMenus();


    Map<Class<? extends BaseModel>, Class<?>> getServices();
}
