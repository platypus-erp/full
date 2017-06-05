package org.platypus.builder.core;

import org.apache.commons.io.IOUtils;
import org.platypus.api.annotations.ModuleInfo;
import org.platypus.api.annotations.PlatypusVersion;
import org.platypus.api.annotations.record.RecordOf;
import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.api.service.PlatypusService;
import org.platypus.impl.module.MetaInfoRecordCollectionImpl;
import org.platypus.impl.module.MetaInfoRecordImpl;

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
    private String shortDesc;
    private String longdesc;
    private final String version;
    private final Set<String> depends;
    private final Set<String> views;
    private final Set<String> menus;
    private final PlatypusVersion platypusVersion;
    private final Map<String, MetaInfoModel> metaInfoModelMap;
    private final Map<String, MetaInfoRecord> metaInfoRecordMap;
    private final Map<String, MetaInfoRecordCollection> metaInfoRecordCollectionMap;
    private final Set<Locale> supportedLocal;
    final ReflectiveModelParser parser = new ReflectiveModelParser();
    final ReflectiveServiceParser serviceParser = new ReflectiveServiceParser();

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
        this.views = new HashSet<>();
        this.menus = new HashSet<>();
    }

    protected void addModel(Class<?> model) {
        MetaInfoModel m = parser.parse(technicalName, Objects.requireNonNull(model));
        metaInfoModelMap.put(m.getName(), m);
    }

    protected void addRecord(Class<?> record) {
        RecordOf recordOf = record.getAnnotation(RecordOf.class);
        MetaInfoRecord metaInfoRecord = new MetaInfoRecordImpl(
                record.getPackage().getName(),
                record.getSimpleName(),
                recordOf.modelName(),
                recordOf.modelClassName(),
                recordOf.modelPkg());
        metaInfoRecordMap.put(recordOf.modelClassName(), metaInfoRecord);
    }
    protected void addRecordCollection(Class<?> record) {
        RecordOf recordOf = record.getAnnotation(RecordOf.class);
        MetaInfoRecordCollection metaInfoRecord = new MetaInfoRecordCollectionImpl(
                record.getPackage().getName(),
                record.getSimpleName(),
                recordOf.modelName(),
                recordOf.modelClassName(),
                recordOf.modelPkg());
        metaInfoRecordCollectionMap.put(recordOf.modelClassName(), metaInfoRecord);
    }

    protected void addClassService(Class<? extends PlatypusService> classSevice) {
        serviceParser.parse(classSevice);
    }

    protected void setLongDesc(String filename) {
        longdesc = Objects.requireNonNull(filename);
        if (null == getLongDecription()){
            throw new IllegalArgumentException(
                    "Unable to find "+ this.getClass().getPackage().getName() +"::"+ filename);
        }
    }

    protected void setShortDesc(String filename) {
        shortDesc = Objects.requireNonNull(filename);
        if (null == getShortDecription()){
            throw new IllegalArgumentException(
                    "Unable to find "+ this.getClass().getPackage().getName() +"::"+ filename);
        }
    }

    protected void addLocal(Locale locale) {
        supportedLocal.add(locale);
    }

    protected void addView(String relativePathToView) {
        views.add(relativePathToView);
    }
    protected void addMenu(String relativePathToMenu) {
        menus.add(relativePathToMenu);
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
        return toStr(getAsStream(shortDesc));
    }

    @Override
    public Set<String> depends() {
        return depends;
    }

    @Override
    public String getShortDecription() {
        return toStr(getAsStream(shortDesc));

    }

    private InputStream getAsStream(String fileNameParam) {
        return this.getClass().getResourceAsStream(fileNameParam);
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
        return Collections.unmodifiableMap(metaInfoRecordCollectionMap);
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
        return Collections.unmodifiableMap(metaInfoRecordMap);
    }

    @Override
    public Set<Locale> getI18n() {
        return supportedLocal;
    }

    @Override
    public Set<String> getViews() {
        return views;
    }

    @Override
    public Set<String> getMenus() {
        return menus;
    }

    @Override
    public String toString() {
        return technicalName;
    }
}
