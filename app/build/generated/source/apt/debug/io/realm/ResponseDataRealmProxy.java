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
public class ResponseDataRealmProxy extends com.gig.gio.search_by_counterparty.model.ResponseData
    implements RealmObjectProxy, ResponseDataRealmProxyInterface {

    static final class ResponseDataColumnInfo extends ColumnInfo {
        long idIndex;
        long suggestionsIndex;

        ResponseDataColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ResponseData");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.suggestionsIndex = addColumnDetails("suggestions", objectSchemaInfo);
        }

        ResponseDataColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ResponseDataColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ResponseDataColumnInfo src = (ResponseDataColumnInfo) rawSrc;
            final ResponseDataColumnInfo dst = (ResponseDataColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.suggestionsIndex = src.suggestionsIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("suggestions");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private ResponseDataColumnInfo columnInfo;
    private ProxyState<com.gig.gio.search_by_counterparty.model.ResponseData> proxyState;
    private RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> suggestionsRealmList;

    ResponseDataRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ResponseDataColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.gig.gio.search_by_counterparty.model.ResponseData>(this);
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
    public RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> realmGet$suggestions() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (suggestionsRealmList != null) {
            return suggestionsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getLinkList(columnInfo.suggestionsIndex);
            suggestionsRealmList = new RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse>(com.gig.gio.search_by_counterparty.model.SuggestResponse.class, osList, proxyState.getRealm$realm());
            return suggestionsRealmList;
        }
    }

    @Override
    public void realmSet$suggestions(RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("suggestions")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> original = value;
                value = new RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse>();
                for (com.gig.gio.search_by_counterparty.model.SuggestResponse item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getLinkList(columnInfo.suggestionsIndex);
        osList.removeAll();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy) linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ResponseData");
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("suggestions", RealmFieldType.LIST, "SuggestResponse");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ResponseDataColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ResponseDataColumnInfo(schemaInfo);
    }

    public static String getTableName() {
        return "class_ResponseData";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.gig.gio.search_by_counterparty.model.ResponseData createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.gig.gio.search_by_counterparty.model.ResponseData obj = null;
        if (update) {
            Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.ResponseData.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.ResponseData.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ResponseDataRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("suggestions")) {
                excludeFields.add("suggestions");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.ResponseDataRealmProxy) realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.ResponseData.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ResponseDataRealmProxy) realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.ResponseData.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final ResponseDataRealmProxyInterface objProxy = (ResponseDataRealmProxyInterface) obj;
        if (json.has("suggestions")) {
            if (json.isNull("suggestions")) {
                objProxy.realmSet$suggestions(null);
            } else {
                objProxy.realmGet$suggestions().clear();
                JSONArray array = json.getJSONArray("suggestions");
                for (int i = 0; i < array.length(); i++) {
                    com.gig.gio.search_by_counterparty.model.SuggestResponse item = SuggestResponseRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$suggestions().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.gig.gio.search_by_counterparty.model.ResponseData createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.gig.gio.search_by_counterparty.model.ResponseData obj = new com.gig.gio.search_by_counterparty.model.ResponseData();
        final ResponseDataRealmProxyInterface objProxy = (ResponseDataRealmProxyInterface) obj;
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
            } else if (name.equals("suggestions")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$suggestions(null);
                } else {
                    objProxy.realmSet$suggestions(new RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.gig.gio.search_by_counterparty.model.SuggestResponse item = SuggestResponseRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$suggestions().add(item);
                    }
                    reader.endArray();
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

    public static com.gig.gio.search_by_counterparty.model.ResponseData copyOrUpdate(Realm realm, com.gig.gio.search_by_counterparty.model.ResponseData object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.gig.gio.search_by_counterparty.model.ResponseData) cachedRealmObject;
        }

        com.gig.gio.search_by_counterparty.model.ResponseData realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.ResponseData.class);
            long pkColumnIndex = table.getPrimaryKey();
            String value = ((ResponseDataRealmProxyInterface) object).realmGet$id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.ResponseData.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.ResponseDataRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.gig.gio.search_by_counterparty.model.ResponseData copy(Realm realm, com.gig.gio.search_by_counterparty.model.ResponseData newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.gig.gio.search_by_counterparty.model.ResponseData) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.gig.gio.search_by_counterparty.model.ResponseData realmObject = realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.ResponseData.class, ((ResponseDataRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        ResponseDataRealmProxyInterface realmObjectSource = (ResponseDataRealmProxyInterface) newObject;
        ResponseDataRealmProxyInterface realmObjectCopy = (ResponseDataRealmProxyInterface) realmObject;


        RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> suggestionsList = realmObjectSource.realmGet$suggestions();
        if (suggestionsList != null) {
            RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> suggestionsRealmList = realmObjectCopy.realmGet$suggestions();
            suggestionsRealmList.clear();
            for (int i = 0; i < suggestionsList.size(); i++) {
                com.gig.gio.search_by_counterparty.model.SuggestResponse suggestionsItem = suggestionsList.get(i);
                com.gig.gio.search_by_counterparty.model.SuggestResponse cachesuggestions = (com.gig.gio.search_by_counterparty.model.SuggestResponse) cache.get(suggestionsItem);
                if (cachesuggestions != null) {
                    suggestionsRealmList.add(cachesuggestions);
                } else {
                    suggestionsRealmList.add(SuggestResponseRealmProxy.copyOrUpdate(realm, suggestionsItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, com.gig.gio.search_by_counterparty.model.ResponseData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.ResponseData.class);
        long tableNativePtr = table.getNativePtr();
        ResponseDataColumnInfo columnInfo = (ResponseDataColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.ResponseData.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ResponseDataRealmProxyInterface) object).realmGet$id();
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

        RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> suggestionsList = ((ResponseDataRealmProxyInterface) object).realmGet$suggestions();
        if (suggestionsList != null) {
            OsList suggestionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.suggestionsIndex);
            for (com.gig.gio.search_by_counterparty.model.SuggestResponse suggestionsItem : suggestionsList) {
                Long cacheItemIndexsuggestions = cache.get(suggestionsItem);
                if (cacheItemIndexsuggestions == null) {
                    cacheItemIndexsuggestions = SuggestResponseRealmProxy.insert(realm, suggestionsItem, cache);
                }
                suggestionsOsList.addRow(cacheItemIndexsuggestions);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.ResponseData.class);
        long tableNativePtr = table.getNativePtr();
        ResponseDataColumnInfo columnInfo = (ResponseDataColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.ResponseData.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.gig.gio.search_by_counterparty.model.ResponseData object = null;
        while (objects.hasNext()) {
            object = (com.gig.gio.search_by_counterparty.model.ResponseData) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((ResponseDataRealmProxyInterface) object).realmGet$id();
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

            RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> suggestionsList = ((ResponseDataRealmProxyInterface) object).realmGet$suggestions();
            if (suggestionsList != null) {
                OsList suggestionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.suggestionsIndex);
                for (com.gig.gio.search_by_counterparty.model.SuggestResponse suggestionsItem : suggestionsList) {
                    Long cacheItemIndexsuggestions = cache.get(suggestionsItem);
                    if (cacheItemIndexsuggestions == null) {
                        cacheItemIndexsuggestions = SuggestResponseRealmProxy.insert(realm, suggestionsItem, cache);
                    }
                    suggestionsOsList.addRow(cacheItemIndexsuggestions);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.gig.gio.search_by_counterparty.model.ResponseData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.ResponseData.class);
        long tableNativePtr = table.getNativePtr();
        ResponseDataColumnInfo columnInfo = (ResponseDataColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.ResponseData.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ResponseDataRealmProxyInterface) object).realmGet$id();
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

        OsList suggestionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.suggestionsIndex);
        suggestionsOsList.removeAll();
        RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> suggestionsList = ((ResponseDataRealmProxyInterface) object).realmGet$suggestions();
        if (suggestionsList != null) {
            for (com.gig.gio.search_by_counterparty.model.SuggestResponse suggestionsItem : suggestionsList) {
                Long cacheItemIndexsuggestions = cache.get(suggestionsItem);
                if (cacheItemIndexsuggestions == null) {
                    cacheItemIndexsuggestions = SuggestResponseRealmProxy.insertOrUpdate(realm, suggestionsItem, cache);
                }
                suggestionsOsList.addRow(cacheItemIndexsuggestions);
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.ResponseData.class);
        long tableNativePtr = table.getNativePtr();
        ResponseDataColumnInfo columnInfo = (ResponseDataColumnInfo) realm.getSchema().getColumnInfo(com.gig.gio.search_by_counterparty.model.ResponseData.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.gig.gio.search_by_counterparty.model.ResponseData object = null;
        while (objects.hasNext()) {
            object = (com.gig.gio.search_by_counterparty.model.ResponseData) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((ResponseDataRealmProxyInterface) object).realmGet$id();
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

            OsList suggestionsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.suggestionsIndex);
            suggestionsOsList.removeAll();
            RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> suggestionsList = ((ResponseDataRealmProxyInterface) object).realmGet$suggestions();
            if (suggestionsList != null) {
                for (com.gig.gio.search_by_counterparty.model.SuggestResponse suggestionsItem : suggestionsList) {
                    Long cacheItemIndexsuggestions = cache.get(suggestionsItem);
                    if (cacheItemIndexsuggestions == null) {
                        cacheItemIndexsuggestions = SuggestResponseRealmProxy.insertOrUpdate(realm, suggestionsItem, cache);
                    }
                    suggestionsOsList.addRow(cacheItemIndexsuggestions);
                }
            }

        }
    }

    public static com.gig.gio.search_by_counterparty.model.ResponseData createDetachedCopy(com.gig.gio.search_by_counterparty.model.ResponseData realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.gig.gio.search_by_counterparty.model.ResponseData unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.gig.gio.search_by_counterparty.model.ResponseData();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.gig.gio.search_by_counterparty.model.ResponseData) cachedObject.object;
            }
            unmanagedObject = (com.gig.gio.search_by_counterparty.model.ResponseData) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        ResponseDataRealmProxyInterface unmanagedCopy = (ResponseDataRealmProxyInterface) unmanagedObject;
        ResponseDataRealmProxyInterface realmSource = (ResponseDataRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());

        // Deep copy of suggestions
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$suggestions(null);
        } else {
            RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> managedsuggestionsList = realmSource.realmGet$suggestions();
            RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> unmanagedsuggestionsList = new RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse>();
            unmanagedCopy.realmSet$suggestions(unmanagedsuggestionsList);
            int nextDepth = currentDepth + 1;
            int size = managedsuggestionsList.size();
            for (int i = 0; i < size; i++) {
                com.gig.gio.search_by_counterparty.model.SuggestResponse item = SuggestResponseRealmProxy.createDetachedCopy(managedsuggestionsList.get(i), nextDepth, maxDepth, cache);
                unmanagedsuggestionsList.add(item);
            }
        }
        return unmanagedObject;
    }

    static com.gig.gio.search_by_counterparty.model.ResponseData update(Realm realm, com.gig.gio.search_by_counterparty.model.ResponseData realmObject, com.gig.gio.search_by_counterparty.model.ResponseData newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ResponseDataRealmProxyInterface realmObjectTarget = (ResponseDataRealmProxyInterface) realmObject;
        ResponseDataRealmProxyInterface realmObjectSource = (ResponseDataRealmProxyInterface) newObject;
        RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> suggestionsList = realmObjectSource.realmGet$suggestions();
        RealmList<com.gig.gio.search_by_counterparty.model.SuggestResponse> suggestionsRealmList = realmObjectTarget.realmGet$suggestions();
        suggestionsRealmList.clear();
        if (suggestionsList != null) {
            for (int i = 0; i < suggestionsList.size(); i++) {
                com.gig.gio.search_by_counterparty.model.SuggestResponse suggestionsItem = suggestionsList.get(i);
                com.gig.gio.search_by_counterparty.model.SuggestResponse cachesuggestions = (com.gig.gio.search_by_counterparty.model.SuggestResponse) cache.get(suggestionsItem);
                if (cachesuggestions != null) {
                    suggestionsRealmList.add(cachesuggestions);
                } else {
                    suggestionsRealmList.add(SuggestResponseRealmProxy.copyOrUpdate(realm, suggestionsItem, true, cache));
                }
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
        StringBuilder stringBuilder = new StringBuilder("ResponseData = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{suggestions:");
        stringBuilder.append("RealmList<SuggestResponse>[").append(realmGet$suggestions().size()).append("]");
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
        ResponseDataRealmProxy aResponseData = (ResponseDataRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aResponseData.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aResponseData.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aResponseData.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
