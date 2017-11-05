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
public class SuggestResponseRealmProxy extends com.gig.gio.search_by_counterparty.model.SuggestResponse
    implements RealmObjectProxy, SuggestResponseRealmProxyInterface {

    static final class SuggestResponseColumnInfo extends ColumnInfo {
        long idIndex;
        long valueIndex;
        long unrestricted_valueIndex;
        long dataIndex;
        long isBookmarkIndex;

        SuggestResponseColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("SuggestResponse");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.valueIndex = addColumnDetails("value", objectSchemaInfo);
            this.unrestricted_valueIndex = addColumnDetails("unrestricted_value", objectSchemaInfo);
            this.dataIndex = addColumnDetails("data", objectSchemaInfo);
            this.isBookmarkIndex = addColumnDetails("isBookmark", objectSchemaInfo);
        }

        SuggestResponseColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new SuggestResponseColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final SuggestResponseColumnInfo src = (SuggestResponseColumnInfo) rawSrc;
            final SuggestResponseColumnInfo dst = (SuggestResponseColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.valueIndex = src.valueIndex;
            dst.unrestricted_valueIndex = src.unrestricted_valueIndex;
            dst.dataIndex = src.dataIndex;
            dst.isBookmarkIndex = src.isBookmarkIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("value");
        fieldNames.add("unrestricted_value");
        fieldNames.add("data");
        fieldNames.add("isBookmark");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private SuggestResponseColumnInfo columnInfo;
    private ProxyState<com.gig.gio.search_by_counterparty.model.SuggestResponse> proxyState;

    SuggestResponseRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SuggestResponseColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.gig.gio.search_by_counterparty.model.SuggestResponse>(this);
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
    @SuppressWarnings("cast")
    public String realmGet$unrestricted_value() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.unrestricted_valueIndex);
    }

    @Override
    public void realmSet$unrestricted_value(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.unrestricted_valueIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.unrestricted_valueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.unrestricted_valueIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.unrestricted_valueIndex, value);
    }

    @Override
    public com.gig.gio.search_by_counterparty.model.Data realmGet$data() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.dataIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.gig.gio.search_by_counterparty.model.Data.class, proxyState.getRow$realm().getLink(columnInfo.dataIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$data(com.gig.gio.search_by_counterparty.model.Data value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("data")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.dataIndex);
                return;
            }
            if (!RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
            if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            }
            row.getTable().setLink(columnInfo.dataIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.dataIndex);
            return;
        }
        if (!(RealmObject.isManaged(value) && RealmObject.isValid(value))) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.dataIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isBookmark() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isBookmarkIndex);
    }

    @Override
    public void realmSet$isBookmark(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isBookmarkIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isBookmarkIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("SuggestResponse");
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("value", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("unrestricted_value", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("data", RealmFieldType.OBJECT, "Data");
        builder.addPersistedProperty("isBookmark", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static SuggestResponseColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new SuggestResponseColumnInfo(schemaInfo);
    }

    public static String getTableName() {
        return "class_SuggestResponse";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.gig.gio.search_by_counterparty.model.SuggestResponse createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.gig.gio.search_by_counterparty.model.SuggestResponse obj = null;
        if (update) {
            Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.SuggestResponse.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.SuggestResponse.class), false, Collections.<String> emptyList());
                    obj = new io.realm.SuggestResponseRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("data")) {
                excludeFields.add("data");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.SuggestResponseRealmProxy) realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.SuggestResponse.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.SuggestResponseRealmProxy) realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.SuggestResponse.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final SuggestResponseRealmProxyInterface objProxy = (SuggestResponseRealmProxyInterface) obj;
        if (json.has("value")) {
            if (json.isNull("value")) {
                objProxy.realmSet$value(null);
            } else {
                objProxy.realmSet$value((String) json.getString("value"));
            }
        }
        if (json.has("unrestricted_value")) {
            if (json.isNull("unrestricted_value")) {
                objProxy.realmSet$unrestricted_value(null);
            } else {
                objProxy.realmSet$unrestricted_value((String) json.getString("unrestricted_value"));
            }
        }
        if (json.has("data")) {
            if (json.isNull("data")) {
                objProxy.realmSet$data(null);
            } else {
                com.gig.gio.search_by_counterparty.model.Data dataObj = DataRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("data"), update);
                objProxy.realmSet$data(dataObj);
            }
        }
        if (json.has("isBookmark")) {
            if (json.isNull("isBookmark")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isBookmark' to null.");
            } else {
                objProxy.realmSet$isBookmark((boolean) json.getBoolean("isBookmark"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.gig.gio.search_by_counterparty.model.SuggestResponse createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.gig.gio.search_by_counterparty.model.SuggestResponse obj = new com.gig.gio.search_by_counterparty.model.SuggestResponse();
        final SuggestResponseRealmProxyInterface objProxy = (SuggestResponseRealmProxyInterface) obj;
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
            } else if (name.equals("unrestricted_value")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$unrestricted_value((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$unrestricted_value(null);
                }
            } else if (name.equals("data")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$data(null);
                } else {
                    com.gig.gio.search_by_counterparty.model.Data dataObj = DataRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$data(dataObj);
                }
            } else if (name.equals("isBookmark")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isBookmark((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isBookmark' to null.");
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

    public static com.gig.gio.search_by_counterparty.model.SuggestResponse copyOrUpdate(Realm realm, com.gig.gio.search_by_counterparty.model.SuggestResponse object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.gig.gio.search_by_counterparty.model.SuggestResponse) cachedRealmObject;
        }

        com.gig.gio.search_by_counterparty.model.SuggestResponse realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.SuggestResponse.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstLong(pkColumnIndex, ((SuggestResponseRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.SuggestResponse.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.SuggestResponseRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.gig.gio.search_by_counterparty.model.SuggestResponse copy(Realm realm, com.gig.gio.search_by_counterparty.model.SuggestResponse newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.gig.gio.search_by_counterparty.model.SuggestResponse) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.gig.gio.search_by_counterparty.model.SuggestResponse realmObject = realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.SuggestResponse.class, ((SuggestResponseRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        SuggestResponseRealmProxyInterface realmObjectSource = (SuggestResponseRealmProxyInterface) newObject;
        SuggestResponseRealmProxyInterface realmObjectCopy = (SuggestResponseRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$value(realmObjectSource.realmGet$value());
        realmObjectCopy.realmSet$unrestricted_value(realmObjectSource.realmGet$unrestricted_value());

        com.gig.gio.search_by_counterparty.model.Data dataObj = realmObjectSource.realmGet$data();
        if (dataObj == null) {
            realmObjectCopy.realmSet$data(null);
        } else {
            com.gig.gio.search_by_counterparty.model.Data cachedata = (com.gig.gio.search_by_counterparty.model.Data) cache.get(dataObj);
            if (cachedata != null) {
                realmObjectCopy.realmSet$data(cachedata);
            } else {
                realmObjectCopy.realmSet$data(DataRealmProxy.copyOrUpdate(realm, dataObj, update, cache));
            }
        }
        realmObjectCopy.realmSet$isBookmark(realmObjectSource.realmGet$isBookmark());
        return realmObject;
    }

    public static long insert(Realm realm, com.gig.gio.search_by_counterparty.model.SuggestResponse object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.SuggestResponse.class);
        long tableNativePtr = table.getNativePtr();
        SuggestResponseColumnInfo columnInfo = (SuggestResponseColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.SuggestResponse.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((SuggestResponseRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((SuggestResponseRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, ((SuggestResponseRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$value = ((SuggestResponseRealmProxyInterface) object).realmGet$value();
        if (realmGet$value != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
        }
        String realmGet$unrestricted_value = ((SuggestResponseRealmProxyInterface) object).realmGet$unrestricted_value();
        if (realmGet$unrestricted_value != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.unrestricted_valueIndex, rowIndex, realmGet$unrestricted_value, false);
        }

        com.gig.gio.search_by_counterparty.model.Data dataObj = ((SuggestResponseRealmProxyInterface) object).realmGet$data();
        if (dataObj != null) {
            Long cachedata = cache.get(dataObj);
            if (cachedata == null) {
                cachedata = DataRealmProxy.insert(realm, dataObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.dataIndex, rowIndex, cachedata, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isBookmarkIndex, rowIndex, ((SuggestResponseRealmProxyInterface) object).realmGet$isBookmark(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.SuggestResponse.class);
        long tableNativePtr = table.getNativePtr();
        SuggestResponseColumnInfo columnInfo = (SuggestResponseColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.SuggestResponse.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.gig.gio.search_by_counterparty.model.SuggestResponse object = null;
        while (objects.hasNext()) {
            object = (com.gig.gio.search_by_counterparty.model.SuggestResponse) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((SuggestResponseRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((SuggestResponseRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, ((SuggestResponseRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$value = ((SuggestResponseRealmProxyInterface) object).realmGet$value();
            if (realmGet$value != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
            }
            String realmGet$unrestricted_value = ((SuggestResponseRealmProxyInterface) object).realmGet$unrestricted_value();
            if (realmGet$unrestricted_value != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.unrestricted_valueIndex, rowIndex, realmGet$unrestricted_value, false);
            }

            com.gig.gio.search_by_counterparty.model.Data dataObj = ((SuggestResponseRealmProxyInterface) object).realmGet$data();
            if (dataObj != null) {
                Long cachedata = cache.get(dataObj);
                if (cachedata == null) {
                    cachedata = DataRealmProxy.insert(realm, dataObj, cache);
                }
                table.setLink(columnInfo.dataIndex, rowIndex, cachedata, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isBookmarkIndex, rowIndex, ((SuggestResponseRealmProxyInterface) object).realmGet$isBookmark(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.gig.gio.search_by_counterparty.model.SuggestResponse object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.SuggestResponse.class);
        long tableNativePtr = table.getNativePtr();
        SuggestResponseColumnInfo columnInfo = (SuggestResponseColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.SuggestResponse.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((SuggestResponseRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((SuggestResponseRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, ((SuggestResponseRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$value = ((SuggestResponseRealmProxyInterface) object).realmGet$value();
        if (realmGet$value != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.valueIndex, rowIndex, false);
        }
        String realmGet$unrestricted_value = ((SuggestResponseRealmProxyInterface) object).realmGet$unrestricted_value();
        if (realmGet$unrestricted_value != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.unrestricted_valueIndex, rowIndex, realmGet$unrestricted_value, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.unrestricted_valueIndex, rowIndex, false);
        }

        com.gig.gio.search_by_counterparty.model.Data dataObj = ((SuggestResponseRealmProxyInterface) object).realmGet$data();
        if (dataObj != null) {
            Long cachedata = cache.get(dataObj);
            if (cachedata == null) {
                cachedata = DataRealmProxy.insertOrUpdate(realm, dataObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.dataIndex, rowIndex, cachedata, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.dataIndex, rowIndex);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isBookmarkIndex, rowIndex, ((SuggestResponseRealmProxyInterface) object).realmGet$isBookmark(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.SuggestResponse.class);
        long tableNativePtr = table.getNativePtr();
        SuggestResponseColumnInfo columnInfo = (SuggestResponseColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.SuggestResponse.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.gig.gio.search_by_counterparty.model.SuggestResponse object = null;
        while (objects.hasNext()) {
            object = (com.gig.gio.search_by_counterparty.model.SuggestResponse) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((SuggestResponseRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((SuggestResponseRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, ((SuggestResponseRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$value = ((SuggestResponseRealmProxyInterface) object).realmGet$value();
            if (realmGet$value != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.valueIndex, rowIndex, realmGet$value, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.valueIndex, rowIndex, false);
            }
            String realmGet$unrestricted_value = ((SuggestResponseRealmProxyInterface) object).realmGet$unrestricted_value();
            if (realmGet$unrestricted_value != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.unrestricted_valueIndex, rowIndex, realmGet$unrestricted_value, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.unrestricted_valueIndex, rowIndex, false);
            }

            com.gig.gio.search_by_counterparty.model.Data dataObj = ((SuggestResponseRealmProxyInterface) object).realmGet$data();
            if (dataObj != null) {
                Long cachedata = cache.get(dataObj);
                if (cachedata == null) {
                    cachedata = DataRealmProxy.insertOrUpdate(realm, dataObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.dataIndex, rowIndex, cachedata, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.dataIndex, rowIndex);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isBookmarkIndex, rowIndex, ((SuggestResponseRealmProxyInterface) object).realmGet$isBookmark(), false);
        }
    }

    public static com.gig.gio.search_by_counterparty.model.SuggestResponse createDetachedCopy(com.gig.gio.search_by_counterparty.model.SuggestResponse realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.gig.gio.search_by_counterparty.model.SuggestResponse unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.gig.gio.search_by_counterparty.model.SuggestResponse();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.gig.gio.search_by_counterparty.model.SuggestResponse) cachedObject.object;
            }
            unmanagedObject = (com.gig.gio.search_by_counterparty.model.SuggestResponse) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        SuggestResponseRealmProxyInterface unmanagedCopy = (SuggestResponseRealmProxyInterface) unmanagedObject;
        SuggestResponseRealmProxyInterface realmSource = (SuggestResponseRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$value(realmSource.realmGet$value());
        unmanagedCopy.realmSet$unrestricted_value(realmSource.realmGet$unrestricted_value());

        // Deep copy of data
        unmanagedCopy.realmSet$data(DataRealmProxy.createDetachedCopy(realmSource.realmGet$data(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$isBookmark(realmSource.realmGet$isBookmark());
        return unmanagedObject;
    }

    static com.gig.gio.search_by_counterparty.model.SuggestResponse update(Realm realm, com.gig.gio.search_by_counterparty.model.SuggestResponse realmObject, com.gig.gio.search_by_counterparty.model.SuggestResponse newObject, Map<RealmModel, RealmObjectProxy> cache) {
        SuggestResponseRealmProxyInterface realmObjectTarget = (SuggestResponseRealmProxyInterface) realmObject;
        SuggestResponseRealmProxyInterface realmObjectSource = (SuggestResponseRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$value(realmObjectSource.realmGet$value());
        realmObjectTarget.realmSet$unrestricted_value(realmObjectSource.realmGet$unrestricted_value());
        com.gig.gio.search_by_counterparty.model.Data dataObj = realmObjectSource.realmGet$data();
        if (dataObj == null) {
            realmObjectTarget.realmSet$data(null);
        } else {
            com.gig.gio.search_by_counterparty.model.Data cachedata = (com.gig.gio.search_by_counterparty.model.Data) cache.get(dataObj);
            if (cachedata != null) {
                realmObjectTarget.realmSet$data(cachedata);
            } else {
                realmObjectTarget.realmSet$data(DataRealmProxy.copyOrUpdate(realm, dataObj, true, cache));
            }
        }
        realmObjectTarget.realmSet$isBookmark(realmObjectSource.realmGet$isBookmark());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SuggestResponse = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{value:");
        stringBuilder.append(realmGet$value() != null ? realmGet$value() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{unrestricted_value:");
        stringBuilder.append(realmGet$unrestricted_value() != null ? realmGet$unrestricted_value() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{data:");
        stringBuilder.append(realmGet$data() != null ? "Data" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isBookmark:");
        stringBuilder.append(realmGet$isBookmark());
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
        SuggestResponseRealmProxy aSuggestResponse = (SuggestResponseRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSuggestResponse.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSuggestResponse.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSuggestResponse.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
