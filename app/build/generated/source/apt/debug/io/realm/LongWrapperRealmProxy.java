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
public class LongWrapperRealmProxy extends com.gig.gio.search_by_counterparty.common.LongWrapper
    implements RealmObjectProxy, LongWrapperRealmProxyInterface {

    static final class LongWrapperColumnInfo extends ColumnInfo {
        long valueIndex;

        LongWrapperColumnInfo(OsSchemaInfo schemaInfo) {
            super(1);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("LongWrapper");
            this.valueIndex = addColumnDetails("value", objectSchemaInfo);
        }

        LongWrapperColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new LongWrapperColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final LongWrapperColumnInfo src = (LongWrapperColumnInfo) rawSrc;
            final LongWrapperColumnInfo dst = (LongWrapperColumnInfo) rawDst;
            dst.valueIndex = src.valueIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("value");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private LongWrapperColumnInfo columnInfo;
    private ProxyState<com.gig.gio.search_by_counterparty.common.LongWrapper> proxyState;

    LongWrapperRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (LongWrapperColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.gig.gio.search_by_counterparty.common.LongWrapper>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$value() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.valueIndex);
    }

    @Override
    public void realmSet$value(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.valueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.valueIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("LongWrapper");
        builder.addPersistedProperty("value", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static LongWrapperColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new LongWrapperColumnInfo(schemaInfo);
    }

    public static String getTableName() {
        return "class_LongWrapper";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.gig.gio.search_by_counterparty.common.LongWrapper createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.gig.gio.search_by_counterparty.common.LongWrapper obj = realm.createObjectInternal(com.gig.gio.search_by_counterparty.common.LongWrapper.class, true, excludeFields);

        final LongWrapperRealmProxyInterface objProxy = (LongWrapperRealmProxyInterface) obj;
        if (json.has("value")) {
            if (json.isNull("value")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'value' to null.");
            } else {
                objProxy.realmSet$value((long) json.getLong("value"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.gig.gio.search_by_counterparty.common.LongWrapper createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.gig.gio.search_by_counterparty.common.LongWrapper obj = new com.gig.gio.search_by_counterparty.common.LongWrapper();
        final LongWrapperRealmProxyInterface objProxy = (LongWrapperRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("value")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$value((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'value' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.gig.gio.search_by_counterparty.common.LongWrapper copyOrUpdate(Realm realm, com.gig.gio.search_by_counterparty.common.LongWrapper object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.gig.gio.search_by_counterparty.common.LongWrapper) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.gig.gio.search_by_counterparty.common.LongWrapper copy(Realm realm, com.gig.gio.search_by_counterparty.common.LongWrapper newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.gig.gio.search_by_counterparty.common.LongWrapper) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.gig.gio.search_by_counterparty.common.LongWrapper realmObject = realm.createObjectInternal(com.gig.gio.search_by_counterparty.common.LongWrapper.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        LongWrapperRealmProxyInterface realmObjectSource = (LongWrapperRealmProxyInterface) newObject;
        LongWrapperRealmProxyInterface realmObjectCopy = (LongWrapperRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$value(realmObjectSource.realmGet$value());
        return realmObject;
    }

    public static long insert(Realm realm, com.gig.gio.search_by_counterparty.common.LongWrapper object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.common.LongWrapper.class);
        long tableNativePtr = table.getNativePtr();
        LongWrapperColumnInfo columnInfo = (LongWrapperColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.common.LongWrapper.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.valueIndex, rowIndex, ((LongWrapperRealmProxyInterface) object).realmGet$value(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.common.LongWrapper.class);
        long tableNativePtr = table.getNativePtr();
        LongWrapperColumnInfo columnInfo = (LongWrapperColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.common.LongWrapper.class);
        com.gig.gio.search_by_counterparty.common.LongWrapper object = null;
        while (objects.hasNext()) {
            object = (com.gig.gio.search_by_counterparty.common.LongWrapper) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.valueIndex, rowIndex, ((LongWrapperRealmProxyInterface) object).realmGet$value(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.gig.gio.search_by_counterparty.common.LongWrapper object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.common.LongWrapper.class);
        long tableNativePtr = table.getNativePtr();
        LongWrapperColumnInfo columnInfo = (LongWrapperColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.common.LongWrapper.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.valueIndex, rowIndex, ((LongWrapperRealmProxyInterface) object).realmGet$value(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.common.LongWrapper.class);
        long tableNativePtr = table.getNativePtr();
        LongWrapperColumnInfo columnInfo = (LongWrapperColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.common.LongWrapper.class);
        com.gig.gio.search_by_counterparty.common.LongWrapper object = null;
        while (objects.hasNext()) {
            object = (com.gig.gio.search_by_counterparty.common.LongWrapper) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.valueIndex, rowIndex, ((LongWrapperRealmProxyInterface) object).realmGet$value(), false);
        }
    }

    public static com.gig.gio.search_by_counterparty.common.LongWrapper createDetachedCopy(com.gig.gio.search_by_counterparty.common.LongWrapper realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.gig.gio.search_by_counterparty.common.LongWrapper unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.gig.gio.search_by_counterparty.common.LongWrapper();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.gig.gio.search_by_counterparty.common.LongWrapper) cachedObject.object;
            }
            unmanagedObject = (com.gig.gio.search_by_counterparty.common.LongWrapper) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        LongWrapperRealmProxyInterface unmanagedCopy = (LongWrapperRealmProxyInterface) unmanagedObject;
        LongWrapperRealmProxyInterface realmSource = (LongWrapperRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$value(realmSource.realmGet$value());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("LongWrapper = proxy[");
        stringBuilder.append("{value:");
        stringBuilder.append(realmGet$value());
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
        LongWrapperRealmProxy aLongWrapper = (LongWrapperRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aLongWrapper.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aLongWrapper.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aLongWrapper.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
