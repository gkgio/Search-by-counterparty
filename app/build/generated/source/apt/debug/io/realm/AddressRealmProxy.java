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
public class AddressRealmProxy extends com.gig.gio.search_by_counterparty.model.Address
    implements RealmObjectProxy, AddressRealmProxyInterface {

    static final class AddressColumnInfo extends ColumnInfo {
        long idIndex;
        long valueIndex;
        long AddressDataIndex;

        AddressColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Address");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.valueIndex = addColumnDetails("value", objectSchemaInfo);
            this.AddressDataIndex = addColumnDetails("AddressData", objectSchemaInfo);
        }

        AddressColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new AddressColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final AddressColumnInfo src = (AddressColumnInfo) rawSrc;
            final AddressColumnInfo dst = (AddressColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.valueIndex = src.valueIndex;
            dst.AddressDataIndex = src.AddressDataIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("value");
        fieldNames.add("AddressData");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private AddressColumnInfo columnInfo;
    private ProxyState<com.gig.gio.search_by_counterparty.model.Address> proxyState;

    AddressRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (AddressColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.gig.gio.search_by_counterparty.model.Address>(this);
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
    public String realmGet$value() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.valueIndex);
    }

    @Override
    public void realmSet$value(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.valueIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.valueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.valueIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.valueIndex, value);
    }

    @Override
    public com.gig.gio.search_by_counterparty.model.AddressData realmGet$AddressData() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.AddressDataIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.gig.gio.search_by_counterparty.model.AddressData.class, proxyState.getRow$realm().getLink(columnInfo.AddressDataIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$AddressData(com.gig.gio.search_by_counterparty.model.AddressData value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("AddressData")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.AddressDataIndex);
                return;
            }
            if (!RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
            if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            }
            row.getTable().setLink(columnInfo.AddressDataIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.AddressDataIndex);
            return;
        }
        if (!(RealmObject.isManaged(value) && RealmObject.isValid(value))) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.AddressDataIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Address");
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("value", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("AddressData", RealmFieldType.OBJECT, "AddressData");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static AddressColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new AddressColumnInfo(schemaInfo);
    }

    public static String getTableName() {
        return "class_Address";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.gig.gio.search_by_counterparty.model.Address createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.gig.gio.search_by_counterparty.model.Address obj = null;
        if (update) {
            Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Address.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Address.class), false, Collections.<String> emptyList());
                    obj = new io.realm.AddressRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("AddressData")) {
                excludeFields.add("AddressData");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.AddressRealmProxy) realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.Address.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.AddressRealmProxy) realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.Address.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final AddressRealmProxyInterface objProxy = (AddressRealmProxyInterface) obj;
        if (json.has("value")) {
            if (json.isNull("value")) {
                objProxy.realmSet$value(null);
            } else {
                objProxy.realmSet$value((String) json.getString("value"));
            }
        }
        if (json.has("AddressData")) {
            if (json.isNull("AddressData")) {
                objProxy.realmSet$AddressData(null);
            } else {
                com.gig.gio.search_by_counterparty.model.AddressData AddressDataObj = AddressDataRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("AddressData"), update);
                objProxy.realmSet$AddressData(AddressDataObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.gig.gio.search_by_counterparty.model.Address createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.gig.gio.search_by_counterparty.model.Address obj = new com.gig.gio.search_by_counterparty.model.Address();
        final AddressRealmProxyInterface objProxy = (AddressRealmProxyInterface) obj;
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
            } else if (name.equals("value")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$value((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$value(null);
                }
            } else if (name.equals("AddressData")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$AddressData(null);
                } else {
                    com.gig.gio.search_by_counterparty.model.AddressData AddressDataObj = AddressDataRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$AddressData(AddressDataObj);
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

    public static com.gig.gio.search_by_counterparty.model.Address copyOrUpdate(Realm realm, com.gig.gio.search_by_counterparty.model.Address object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.gig.gio.search_by_counterparty.model.Address) cachedRealmObject;
        }

        com.gig.gio.search_by_counterparty.model.Address realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Address.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstLong(pkColumnIndex, ((AddressRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Address.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.AddressRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.gig.gio.search_by_counterparty.model.Address copy(Realm realm, com.gig.gio.search_by_counterparty.model.Address newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.gig.gio.search_by_counterparty.model.Address) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.gig.gio.search_by_counterparty.model.Address realmObject = realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.Address.class, ((AddressRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        AddressRealmProxyInterface realmObjectSource = (AddressRealmProxyInterface) newObject;
        AddressRealmProxyInterface realmObjectCopy = (AddressRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$value(realmObjectSource.realmGet$value());

        com.gig.gio.search_by_counterparty.model.AddressData AddressDataObj = realmObjectSource.realmGet$AddressData();
        if (AddressDataObj == null) {
            realmObjectCopy.realmSet$AddressData(null);
        } else {
            com.gig.gio.search_by_counterparty.model.AddressData cacheAddressData = (com.gig.gio.search_by_counterparty.model.AddressData) cache.get(AddressDataObj);
            if (cacheAddressData != null) {
                realmObjectCopy.realmSet$AddressData(cacheAddressData);
            } else {
                realmObjectCopy.realmSet$AddressData(AddressDataRealmProxy.copyOrUpdate(realm, AddressDataObj, update, cache));
            }
        }
        return realmObject;
    }

    public static long insert(Realm realm, com.gig.gio.search_by_counterparty.model.Address object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Address.class);
        long tableNativePtr = table.getNativePtr();
        AddressColumnInfo columnInfo = (AddressColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Address.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((AddressRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((AddressRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, ((AddressRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$value = ((AddressRealmProxyInterface) object).realmGet$value();
        if (realmGet$value != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
        }

        com.gig.gio.search_by_counterparty.model.AddressData AddressDataObj = ((AddressRealmProxyInterface) object).realmGet$AddressData();
        if (AddressDataObj != null) {
            Long cacheAddressData = cache.get(AddressDataObj);
            if (cacheAddressData == null) {
                cacheAddressData = AddressDataRealmProxy.insert(realm, AddressDataObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.AddressDataIndex, rowIndex, cacheAddressData, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Address.class);
        long tableNativePtr = table.getNativePtr();
        AddressColumnInfo columnInfo = (AddressColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Address.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.gig.gio.search_by_counterparty.model.Address object = null;
        while (objects.hasNext()) {
            object = (com.gig.gio.search_by_counterparty.model.Address) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((AddressRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((AddressRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, ((AddressRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$value = ((AddressRealmProxyInterface) object).realmGet$value();
            if (realmGet$value != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
            }

            com.gig.gio.search_by_counterparty.model.AddressData AddressDataObj = ((AddressRealmProxyInterface) object).realmGet$AddressData();
            if (AddressDataObj != null) {
                Long cacheAddressData = cache.get(AddressDataObj);
                if (cacheAddressData == null) {
                    cacheAddressData = AddressDataRealmProxy.insert(realm, AddressDataObj, cache);
                }
                table.setLink(columnInfo.AddressDataIndex, rowIndex, cacheAddressData, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.gig.gio.search_by_counterparty.model.Address object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Address.class);
        long tableNativePtr = table.getNativePtr();
        AddressColumnInfo columnInfo = (AddressColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Address.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((AddressRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((AddressRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, ((AddressRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$value = ((AddressRealmProxyInterface) object).realmGet$value();
        if (realmGet$value != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.valueIndex, rowIndex, false);
        }

        com.gig.gio.search_by_counterparty.model.AddressData AddressDataObj = ((AddressRealmProxyInterface) object).realmGet$AddressData();
        if (AddressDataObj != null) {
            Long cacheAddressData = cache.get(AddressDataObj);
            if (cacheAddressData == null) {
                cacheAddressData = AddressDataRealmProxy.insertOrUpdate(realm, AddressDataObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.AddressDataIndex, rowIndex, cacheAddressData, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.AddressDataIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Address.class);
        long tableNativePtr = table.getNativePtr();
        AddressColumnInfo columnInfo = (AddressColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.Address.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.gig.gio.search_by_counterparty.model.Address object = null;
        while (objects.hasNext()) {
            object = (com.gig.gio.search_by_counterparty.model.Address) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((AddressRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((AddressRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, ((AddressRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$value = ((AddressRealmProxyInterface) object).realmGet$value();
            if (realmGet$value != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.valueIndex, rowIndex, false);
            }

            com.gig.gio.search_by_counterparty.model.AddressData AddressDataObj = ((AddressRealmProxyInterface) object).realmGet$AddressData();
            if (AddressDataObj != null) {
                Long cacheAddressData = cache.get(AddressDataObj);
                if (cacheAddressData == null) {
                    cacheAddressData = AddressDataRealmProxy.insertOrUpdate(realm, AddressDataObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.AddressDataIndex, rowIndex, cacheAddressData, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.AddressDataIndex, rowIndex);
            }
        }
    }

    public static com.gig.gio.search_by_counterparty.model.Address createDetachedCopy(com.gig.gio.search_by_counterparty.model.Address realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.gig.gio.search_by_counterparty.model.Address unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.gig.gio.search_by_counterparty.model.Address();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.gig.gio.search_by_counterparty.model.Address) cachedObject.object;
            }
            unmanagedObject = (com.gig.gio.search_by_counterparty.model.Address) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        AddressRealmProxyInterface unmanagedCopy = (AddressRealmProxyInterface) unmanagedObject;
        AddressRealmProxyInterface realmSource = (AddressRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$value(realmSource.realmGet$value());

        // Deep copy of AddressData
        unmanagedCopy.realmSet$AddressData(AddressDataRealmProxy.createDetachedCopy(realmSource.realmGet$AddressData(), currentDepth + 1, maxDepth, cache));
        return unmanagedObject;
    }

    static com.gig.gio.search_by_counterparty.model.Address update(Realm realm, com.gig.gio.search_by_counterparty.model.Address realmObject, com.gig.gio.search_by_counterparty.model.Address newObject, Map<RealmModel, RealmObjectProxy> cache) {
        AddressRealmProxyInterface realmObjectTarget = (AddressRealmProxyInterface) realmObject;
        AddressRealmProxyInterface realmObjectSource = (AddressRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$value(realmObjectSource.realmGet$value());
        com.gig.gio.search_by_counterparty.model.AddressData AddressDataObj = realmObjectSource.realmGet$AddressData();
        if (AddressDataObj == null) {
            realmObjectTarget.realmSet$AddressData(null);
        } else {
            com.gig.gio.search_by_counterparty.model.AddressData cacheAddressData = (com.gig.gio.search_by_counterparty.model.AddressData) cache.get(AddressDataObj);
            if (cacheAddressData != null) {
                realmObjectTarget.realmSet$AddressData(cacheAddressData);
            } else {
                realmObjectTarget.realmSet$AddressData(AddressDataRealmProxy.copyOrUpdate(realm, AddressDataObj, true, cache));
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
        StringBuilder stringBuilder = new StringBuilder("Address = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{value:");
        stringBuilder.append(realmGet$value() != null ? realmGet$value() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{AddressData:");
        stringBuilder.append(realmGet$AddressData() != null ? "AddressData" : "null");
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
        AddressRealmProxy aAddress = (AddressRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aAddress.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAddress.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aAddress.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
