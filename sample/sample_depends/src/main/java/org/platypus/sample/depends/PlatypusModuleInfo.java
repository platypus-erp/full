package org.platypus.sample.depends;

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
public class PlatypusModuleInfo implements PlatypusCompleteModuleInfo {
    @Override
    public String getName() {
        return "Sample Module with all platypus and community depends";
    }

    @Override
    public Map<String, MetaInfoModel> getModel() {
        return Collections.emptyMap();
    }

    @Override
    public String techincalName() {
        return "sample_depends";
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
        return Collections.singleton("base");
    }

    @Override
    public String getLongDecription() {
        return "long-desc.adoc";
    }

    @Override
    public String getShortDecription() {
        return "short-desc.adoc";
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
