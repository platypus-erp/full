package orp.platypus.impl.module;

import org.apache.commons.io.IOUtils;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.MetaInfoModel;
import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.api.module.PlatypusVersion;
import org.platypus.api.views.View;
import org.platypus.sample.depends.desc.LongDescLoader;
import org.platypus.sample.depends.desc.ShortDescLoader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/03/17.
 */
public abstract class AbstractModule implements PlatypusCompleteModuleInfo {
    private final String technicalName;
    private final String name;
    private final String version;
    private final Set<String> depends;
    private final PlatypusVersion platypusVersion;
    private final Map<String, MetaInfoModel> metaInfoModelMap;
    private final Map<String, MetaInfoRecord> metaInfoRecordMap;
    private final Map<String, MetaInfoRecordCollection> metaInfoRecordCollectionMap;
    private final Set<Locale> supportedLocal;

    public AbstractModule(String technicalName, String name, String version, PlatypusVersion platypusVersion, Set<String> depends) {
        this.technicalName = technicalName;
        this.name = name;
        this.version = version;
        this.platypusVersion = platypusVersion;
        this.depends = depends;
        this.metaInfoModelMap = new HashMap<>();
        this.metaInfoRecordMap = new HashMap<>();
        this.metaInfoRecordCollectionMap = new HashMap<>();
        this.supportedLocal = new HashSet<>();
    }

    protected void addModel(MetaInfoModel model){
        metaInfoModelMap.put(model.getName(), model);
    }

    protected void addLocal(Locale locale){
        supportedLocal.add(locale);
    }

    protected void addRecord(MetaInfoRecord record){
        metaInfoRecordMap.put(record.getModelTarget(), record);
    }

    protected void addRecordCollection(MetaInfoRecordCollection recordCollection){
        metaInfoRecordCollectionMap.put(recordCollection.getModelTarget(), recordCollection);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String techincalName() {
        return technicalName;
    }

    @Override
    public Map<String, MetaInfoModel> getModel() {
        return metaInfoModelMap;
    }

    @Override
    public String version() {
        return version;
    }

    @Override
    public PlatypusVersion platypusVersion() {
        return platypusVersion;
    }

    @Override
    public String getLongDecription() {
        return toStr(new LongDescLoader().getAsStream("",""));
    }

    @Override
    public Set<String> depends() {
        return depends;
    }

    @Override
    public String getShortDecription() {
        return toStr(new ShortDescLoader().getAsStream("",""));

    }

    private String toStr(InputStream s){
        if(s == null){
            return "";
        }else {
            try {
                return IOUtils.toString(s, Charset.defaultCharset());
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    @Override
    public Map<String, MetaInfoRecordCollection> getRecordCollection() {
        return null;
    }

    @Override
    public Set<String> getRefData() {
        return null;
    }

    @Override
    public Set<String> getDemoData() {
        return null;
    }

    @Override
    public Map<String, MetaInfoRecord> getRecord() {
        return null;
    }

    @Override
    public Set<Locale> getI18n() {
        return supportedLocal;
    }

    @Override
    public Map<String, View> getViews() {
        return null;
    }

    @Override
    public Map<String, View> getMenus() {
        return null;
    }
}
