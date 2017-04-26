package org.platypus.builder.core;

import org.apache.commons.io.IOUtils;
import org.platypus.api.BaseModel;
import org.platypus.api.annotations.ModuleInfo;
import org.platypus.api.annotations.PlatypusVersion;
import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.api.views.View;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/03/17.
 */
public abstract class AbstractModule implements PlatypusCompleteModuleInfo {
    private final String technicalName;
    private final String name;
    private String subpathShortDesc;
    private String shortDesc;
    private String subpathLongDesc;
    private String longdesc;
    private final String version;
    private final Set<String> depends;
    private final PlatypusVersion platypusVersion;
    private final Map<String, MetaInfoModel> metaInfoModelMap;
    private final Map<String, MetaInfoRecord> metaInfoRecordMap;
    private final Map<String, MetaInfoRecordCollection> metaInfoRecordCollectionMap;
    private final Set<Locale> supportedLocal;
    ReflectiveModelParser parser = new ReflectiveModelParser();

    public AbstractModule(String name) {
        ModuleInfo info = this.getClass().getAnnotation(ModuleInfo.class);
        this.technicalName = info.name();
        this.name = name;
        this.version = info.moduleVersion();
        this.platypusVersion = info.version();
        depends = new HashSet<>();
        Collections.addAll(depends, info.depends());
        System.out.println(depends);
        this.metaInfoModelMap = new HashMap<>();
        this.metaInfoRecordMap = new HashMap<>();
        this.metaInfoRecordCollectionMap = new HashMap<>();
        this.supportedLocal = new HashSet<>();
    }

    protected void addModel(BaseModel model) {
        MetaInfoModel m = parser.parse(Objects.requireNonNull(model));
        metaInfoModelMap.put(m.getName(), m);
    }

    protected void setLongDesc(String filename) {
        longdesc = Objects.requireNonNull(filename);
        if (null == getLongDecription()){
            throw new IllegalArgumentException(
                    "Unable to find "+ this.getClass().getPackage().getName() +"::"+ filename);
        }
    }
    protected void setLongDesc(String subpath, String filename) {
        subpathLongDesc = Objects.requireNonNull(subpath);
        longdesc = Objects.requireNonNull(filename);
        if (null == getLongDecription()){
            throw new IllegalArgumentException(
                    "Unable to find "+ this.getClass().getPackage().getName() +"::"+ filename);
        }
    }

    protected void setShortDesc(String filename) {
        shortDesc = Objects.requireNonNull(filename);
        if (null == getLongDecription()){
            throw new IllegalArgumentException(
                    "Unable to find "+ this.getClass().getPackage().getName() +"::"+ filename);
        }
    }
    protected void setShortDesc(String subpath, String filename) {
        subpathShortDesc = Objects.requireNonNull(subpath);
        shortDesc = Objects.requireNonNull(filename);
        if (null == getLongDecription()){
            throw new IllegalArgumentException(
                    "Unable to find "+ this.getClass().getPackage().getName() +"::"+ filename);
        }
    }

    protected void addLocal(Locale locale) {
        supportedLocal.add(locale);
    }

    protected void addRecord(MetaInfoRecord record) {
        metaInfoRecordMap.put(record.getModelTarget(), record);
    }

    protected void addRecordCollection(MetaInfoRecordCollection recordCollection) {
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
        return toStr(getAsStream(subpathLongDesc, shortDesc));
    }

    @Override
    public Set<String> depends() {
        return depends;
    }

    @Override
    public String getShortDecription() {
        return toStr(getAsStream(subpathShortDesc, shortDesc));

    }

    private InputStream getAsStream(String pathTo, String fileNameParam) {
        return this.getClass().getResourceAsStream(pathTo + "/" + fileNameParam);
    }

    private String toStr(InputStream s) {
        if (s == null) {
            return "";
        } else {
            try {
                return IOUtils.toString(s, Charset.defaultCharset());
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    @Override
    public Map<String, MetaInfoRecordCollection> getRecordCollection() {
        return Collections.emptyMap();
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
    public Map<String, MetaInfoRecord> getRecord() {
        return Collections.emptyMap();
    }

    @Override
    public Set<Locale> getI18n() {
        return supportedLocal;
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
