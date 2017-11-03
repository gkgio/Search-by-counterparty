package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.ProxyUtils;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class DataRealmProxy extends com.gig.gio.search_by_counterparty.model.Data
    implements RealmObjectProxy, DataRealmProxyInterface {

    static final class DataColumnInfo extends ColumnInfo {
        long idIndex;
        long kppIndex;
        long managementIndex;

        DataColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Data");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.kppIndex = addColumnDetails("kpp", objectSchemaInfo);
            this.managementIndex = addColumnDetails("management", objectSchemaInfo);
        }

        DataColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DataColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DataColumnInfo src = (DataColumnInfo) rawSrc;
            final DataColumnInfo dst = (DataColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.kppIndex = src.kppIndex;
            dst.managementIndex = src.managementIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("kpp");
        fieldNames.add("management");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private DataColumnInfo columnInfo;
    private ProxyState<com.gig.gio.search_by_counterparty.model.Data> proxyState;

    DataRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DataColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.gig.gio.search_by_counterparty.model.Data>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$kpp() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.kppIndex);
    }

    @Override
    public void realmSet$kpp(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.kppIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.kppIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.kppIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.kppIndex, value);
    }

    @Override
    public com.gig.gio.search_by_counterparty.model.Management realmGet$management() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.managementIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.gig.gio.search_by_counterparty.model.Management.class, proxyState.getRow$realm().getLink(columnInfo.managementIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$management(com.gig.gio.search_by_counterparty.model.Management value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("management")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.managementIndex);
                return;
            }
            if (!RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
            if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            }
            row.getTable().setLink(columnInfo.managementIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.managementIndex);
            return;
        }
        if (!(RealmObject.isManaged(value) && RealmObject.isValid(value))) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.managementIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Data");
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("kpp", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("management", RealmFieldType.OBJECT, "Management");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DataColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DataColumnInfo(schemaInfo);
    }

    public static String getTableName() {
        return "class_Data";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.gig.gio.search_by_counterparty.model.Data createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.gig.gio.search_by_counterparty.model.Data obj = null;
        if (update) {
            Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Data.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Data.class), false, Collections.<String> emptyList());
                    obj = new io.realm.DataRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("management")) {
                excludeFields.add("management");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.DataRealmProxy) realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.Data.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.DataRealmProxy) realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.Data.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final DataRealmProxyInterface objProxy = (DataRealmProxyInterface) obj;
        if (json.has("kpp")) {
            if (json.isNull("kpp")) {
                objProxy.realmSet$kpp(null);
            } else {
                objProxy.realmSet$kpp((String) json.getString("kpp"));
            }
        }
        if (json.has("management")) {
            if (json.isNull("management")) {
                objProxy.realmSet$management(null);
            } else {
                com.gig.gio.search_by_counterparty.model.Management managementObj = ManagementRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("management"), update);
                objProxy.realmSet$management(managementObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.gig.gio.search_by_counterparty.model.Data createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.gig.gio.search_by_counterparty.model.Data obj = new com.gig.gio.search_by_counterparty.model.Data();
        final DataRealmProxyInterface objProxy = (DataRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("kpp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$kpp((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$kpp(null);
                }
            } else if (name.equals("management")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$management(null);
                } else {
                    com.gig.gio.search_by_counterparty.model.Management managementObj = ManagementRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$management(managementObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.gig.gio.search_by_counterparty.model.Data copyOrUpdate(Realm realm, com.gig.gio.search_by_counterparty.model.Data object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.gig.gio.search_by_counterparty.model.Data) cachedRealmObject;
        }

        com.gig.gio.search_by_counterparty.model.Data realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Data.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstLong(pkColumnIndex, ((DataRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Data.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.DataRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.gig.gio.search_by_counterparty.model.Data copy(Realm realm, com.gig.gio.search_by_counterparty.model.Data newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.gig.gio.search_by_counterparty.model.Data) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.gig.gio.search_by_counterparty.model.Data realmObject = realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.Data.class, ((DataRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        DataRealmProxyInterface realmObjectSource = (DataRealmProxyInterface) newObject;
        DataRealmProxyInterface realmObjectCopy = (DataRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$kpp(realmObjectSource.realmGet$kpp());

        com.gig.gio.search_by_counterparty.model.Management managementObj = realmObjectSource.realmGet$management();
        if (managementObj == null) {
            realmObjectCopy.realmSet$management(null);
        } else {
            com.gig.gio.search_by_counterparty.model.Management cachemanagement = (com.gig.gio.search_by_counterparty.model.Management) cache.get(managementObj);
            if (cachemanagement != null) {
                realmObjectCopy.realmSet$management(cachemanagement);
            } else {
                realmObjectCopy.realmSet$management(ManagementRealmProxy.copyOrUpdate(realm, managementObj, update, cache));
            }
        }
        return realmObject;
    }

    public static long insert(Realm realm, com.gig.gio.search_by_counterparty.model.Data object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Data.class);
        long tableNativePtr = table.getNativePtr();
        DataColumnInfo columnInfo = (DataColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Data.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((DataRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((DataRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, ((DataRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$kpp = ((DataRealmProxyInterface) object).realmGet$kpp();
        if (realmGet$kpp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.kppIndex, rowIndex, realmGet$kpp, false);
        }

        com.gig.gio.search_by_counterparty.model.Management managementObj = ((DataRealmProxyInterface) object).realmGet$management();
        if (managementObj != null) {
            Long cachemanagement = cache.get(managementObj);
            if (cachemanagement == null) {
                cachemanagement = ManagementRealmProxy.insert(realm, managementObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.managementIndex, rowIndex, cachemanagement, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Data.class);
        long tableNativePtr = table.getNativePtr();
        DataColumnInfo columnInfo = (DataColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Data.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.gig.gio.search_by_counterparty.model.Data object = null;
        while (objects.hasNext()) {
            object = (com.gig.gio.search_by_counterparty.model.Data) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((DataRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((DataRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, ((DataRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$kpp = ((DataRealmProxyInterface) object).realmGet$kpp();
            if (realmGet$kpp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.kppIndex, rowIndex, realmGet$kpp, false);
            }

            com.gig.gio.search_by_counterparty.model.Management managementObj = ((DataRealmProxyInterface) object).realmGet$management();
            if (managementObj != null) {
                Long cachemanagement = cache.get(managementObj);
                if (cachemanagement == null) {
                    cachemanagement = ManagementRealmProxy.insert(realm, managementObj, cache);
                }
                table.setLink(columnInfo.managementIndex, rowIndex, cachemanagement, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.gig.gio.search_by_counterparty.model.Data object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Data.class);
        long tableNativePtr = table.getNativePtr();
        DataColumnInfo columnInfo = (DataColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Data.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((DataRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((DataRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, ((DataRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$kpp = ((DataRealmProxyInterface) object).realmGet$kpp();
        if (realmGet$kpp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.kppIndex, rowIndex, realmGet$kpp, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.kppIndex, rowIndex, false);
        }

        com.gig.gio.search_by_counterparty.model.Management managementObj = ((DataRealmProxyInterface) object).realmGet$management();
        if (managementObj != null) {
            Long cachemanagement = cache.get(managementObj);
            if (cachemanagement == null) {
                cachemanagement = ManagementRealmProxy.insertOrUpdate(realm, managementObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.managementIndex, rowIndex, cachemanagement, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.managementIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Data.class);
        long tableNativePtr = table.getNativePtr();
        DataColumnInfo columnInfo = (DataColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Data.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.gig.gio.search_by_counterparty.model.Data object = null;
        while (objects.hasNext()) {
            object = (com.gig.gio.search_by_counterparty.model.Data) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((DataRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((DataRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, ((DataRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$kpp = ((DataRealmProxyInterface) object).realmGet$kpp();
            if (realmGet$kpp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.kppIndex, rowIndex, realmGet$kpp, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.kppIndex, rowIndex, false);
            }

            com.gig.gio.search_by_counterparty.model.Management managementObj = ((DataRealmProxyInterface) object).realmGet$management();
            if (managementObj != null) {
                Long cachemanagement = cache.get(managementObj);
                if (cachemanagement == null) {
                    cachemanagement = ManagementRealmProxy.insertOrUpdate(realm, managementObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.managementIndex, rowIndex, cachemanagement, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.managementIndex, rowIndex);
            }
        }
    }

    public static com.gig.gio.search_by_counterparty.model.Data createDetachedCopy(com.gig.gio.search_by_counterparty.model.Data realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.gig.gio.search_by_counterparty.model.Data unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.gig.gio.search_by_counterparty.model.Data();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.gig.gio.search_by_counterparty.model.Data) cachedObject.object;
            }
            unmanagedObject = (com.gig.gio.search_by_counterparty.model.Data) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        DataRealmProxyInterface unmanagedCopy = (DataRealmProxyInterface) unmanagedObject;
        DataRealmProxyInterface realmSource = (DataRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$kpp(realmSource.realmGet$kpp());

        // Deep copy of management
        unmanagedCopy.realmSet$management(ManagementRealmProxy.createDetachedCopy(realmSource.realmGet$management(), currentDepth + 1, maxDepth, cache));
        return unmanagedObject;
    }

    static com.gig.gio.search_by_counterparty.model.Data update(Realm realm, com.gig.gio.search_by_counterparty.model.Data realmObject, com.gig.gio.search_by_counterparty.model.Data newObject, Map<RealmModel, RealmObjectProxy> cache) {
        DataRealmProxyInterface realmObjectTarget = (DataRealmProxyInterface) realmObject;
        DataRealmProxyInterface realmObjectSource = (DataRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$kpp(realmObjectSource.realmGet$kpp());
        com.gig.gio.search_by_counterparty.model.Management managementObj = realmObjectSource.realmGet$management();
        if (managementObj == null) {
            realmObjectTarget.realmSet$management(null);
        } else {
            com.gig.gio.search_by_counterparty.model.Management cachemanagement = (com.gig.gio.search_by_counterparty.model.Management) cache.get(managementObj);
            if (cachemanagement != null) {
                realmObjectTarget.realmSet$management(cachemanagement);
            } else {
                realmObjectTarget.realmSet$management(ManagementRealmProxy.copyOrUpdate(realm, managementObj, true, cache));
            }
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Data = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{kpp:");
        stringBuilder.append(realmGet$kpp() != null ? realmGet$kpp() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{management:");
        stringBuilder.append(realmGet$management() != null ? "Management" : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataRealmProxy aData = (DataRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aData.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aData.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aData.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
