package org.platypus.module.base;

import org.platypus.api.module.MetaInfoModel;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.api.module.PlatypusVersion;
import org.platypus.api.views.View;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/04/17.
 */
public class BasePlatypusModuleInfo implements PlatypusCompleteModuleInfo {
    @Override
    public String getName() {
        return "The base of all platypus plugins";
    }

    @Override
    public Map<String, MetaInfoModel> getModel() {
        return Collections.emptyMap();
    }

    @Override
    public String techincalName() {
        return "base";
    }

    @Override
    public String version() {
        return "1";
    }

    @Override
    public PlatypusVersion platypusVersion() {
        return PlatypusVersion.V1;
    }

    @Override
    public Set<String> depends() {
        return Collections.emptySet();
    }

    @Override
    public String getLongDecription() {
        return null;
    }

    @Override
    public String getShortDecription() {
        return null;
    }

    @Override
    public Map<String, MetaInfoRecordCollection> getRecordCollection() {
        return Collections.emptyMap();
    }

    @Override
    public Map<String, MetaInfoRecord> getRecord() {
        return Collections.emptyMap();
    }

    @Override
    public Set<Locale> getI18n() {
        return Collections.emptySet();
    }

    @Override
    public Set<String> getRefData() {
        return Collections.emptySet();
    }

    @Override
    public Set<String> getDemoData() {
        return Collections.emptySet();
    }

    @Override
    public Map<String, View> getViews() {
        return Collections.emptyMap();
    }

    @Override
    public Map<String, View> getMenus() {
        return Collections.emptyMap();
    }
}
