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
public class ManagementRealmProxy extends com.gig.gio.search_by_counterparty.model.Management
    implements RealmObjectProxy, ManagementRealmProxyInterface {

    static final class ManagementColumnInfo extends ColumnInfo {
        long idIndex;
        long nameIndex;
        long postIndex;

        ManagementColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Management");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.postIndex = addColumnDetails("post", objectSchemaInfo);
        }

        ManagementColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ManagementColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ManagementColumnInfo src = (ManagementColumnInfo) rawSrc;
            final ManagementColumnInfo dst = (ManagementColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.postIndex = src.postIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("post");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private ManagementColumnInfo columnInfo;
    private ProxyState<com.gig.gio.search_by_counterparty.model.Management> proxyState;

    ManagementRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ManagementColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.gig.gio.search_by_counterparty.model.Management>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$post() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.postIndex);
    }

    @Override
    public void realmSet$post(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.postIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.postIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.postIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.postIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Management");
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("post", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ManagementColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ManagementColumnInfo(schemaInfo);
    }

    public static String getTableName() {
        return "class_Management";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.gig.gio.search_by_counterparty.model.Management createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.gig.gio.search_by_counterparty.model.Management obj = null;
        if (update) {
            Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Management.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Management.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ManagementRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.ManagementRealmProxy) realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.Management.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ManagementRealmProxy) realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.Management.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final ManagementRealmProxyInterface objProxy = (ManagementRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("post")) {
            if (json.isNull("post")) {
                objProxy.realmSet$post(null);
            } else {
                objProxy.realmSet$post((String) json.getString("post"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.gig.gio.search_by_counterparty.model.Management createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.gig.gio.search_by_counterparty.model.Management obj = new com.gig.gio.search_by_counterparty.model.Management();
        final ManagementRealmProxyInterface objProxy = (ManagementRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("post")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$post((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$post(null);
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

    public static com.gig.gio.search_by_counterparty.model.Management copyOrUpdate(Realm realm, com.gig.gio.search_by_counterparty.model.Management object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.gig.gio.search_by_counterparty.model.Management) cachedRealmObject;
        }

        com.gig.gio.search_by_counterparty.model.Management realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Management.class);
            long pkColumnIndex = table.getPrimaryKey();
            String value = ((ManagementRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Management.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.ManagementRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.gig.gio.search_by_counterparty.model.Management copy(Realm realm, com.gig.gio.search_by_counterparty.model.Management newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.gig.gio.search_by_counterparty.model.Management) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.gig.gio.search_by_counterparty.model.Management realmObject = realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.Management.class, ((ManagementRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        ManagementRealmProxyInterface realmObjectSource = (ManagementRealmProxyInterface) newObject;
        ManagementRealmProxyInterface realmObjectCopy = (ManagementRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$post(realmObjectSource.realmGet$post());
        return realmObject;
    }

    public static long insert(Realm realm, com.gig.gio.search_by_counterparty.model.Management object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Management.class);
        long tableNativePtr = table.getNativePtr();
        ManagementColumnInfo columnInfo = (ManagementColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Management.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ManagementRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((ManagementRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$post = ((ManagementRealmProxyInterface) object).realmGet$post();
        if (realmGet$post != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.postIndex, rowIndex, realmGet$post, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Management.class);
        long tableNativePtr = table.getNativePtr();
        ManagementColumnInfo columnInfo = (ManagementColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Management.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.gig.gio.search_by_counterparty.model.Management object = null;
        while (objects.hasNext()) {
            object = (com.gig.gio.search_by_counterparty.model.Management) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((ManagementRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((ManagementRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$post = ((ManagementRealmProxyInterface) object).realmGet$post();
            if (realmGet$post != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.postIndex, rowIndex, realmGet$post, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.gig.gio.search_by_counterparty.model.Management object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Management.class);
        long tableNativePtr = table.getNativePtr();
        ManagementColumnInfo columnInfo = (ManagementColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Management.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ManagementRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((ManagementRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$post = ((ManagementRealmProxyInterface) object).realmGet$post();
        if (realmGet$post != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.postIndex, rowIndex, realmGet$post, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.postIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Management.class);
        long tableNativePtr = table.getNativePtr();
        ManagementColumnInfo columnInfo = (ManagementColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Management.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.gig.gio.search_by_counterparty.model.Management object = null;
        while (objects.hasNext()) {
            object = (com.gig.gio.search_by_counterparty.model.Management) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((ManagementRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((ManagementRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$post = ((ManagementRealmProxyInterface) object).realmGet$post();
            if (realmGet$post != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.postIndex, rowIndex, realmGet$post, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.postIndex, rowIndex, false);
            }
        }
    }

    public static com.gig.gio.search_by_counterparty.model.Management createDetachedCopy(com.gig.gio.search_by_counterparty.model.Management realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.gig.gio.search_by_counterparty.model.Management unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.gig.gio.search_by_counterparty.model.Management();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.gig.gio.search_by_counterparty.model.Management) cachedObject.object;
            }
            unmanagedObject = (com.gig.gio.search_by_counterparty.model.Management) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        ManagementRealmProxyInterface unmanagedCopy = (ManagementRealmProxyInterface) unmanagedObject;
        ManagementRealmProxyInterface realmSource = (ManagementRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$post(realmSource.realmGet$post());
        return unmanagedObject;
    }

    static com.gig.gio.search_by_counterparty.model.Management update(Realm realm, com.gig.gio.search_by_counterparty.model.Management realmObject, com.gig.gio.search_by_counterparty.model.Management newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ManagementRealmProxyInterface realmObjectTarget = (ManagementRealmProxyInterface) realmObject;
        ManagementRealmProxyInterface realmObjectSource = (ManagementRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$post(realmObjectSource.realmGet$post());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Management = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{post:");
        stringBuilder.append(realmGet$post() != null ? realmGet$post() : "null");
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
        ManagementRealmProxy aManagement = (ManagementRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aManagement.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aManagement.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aManagement.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
