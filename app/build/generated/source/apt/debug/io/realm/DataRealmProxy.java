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
        long innIndex;
        long ogrnIndex;
        long opfIndex;
        long stateIndex;
        long addressIndex;

        DataColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Data");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.kppIndex = addColumnDetails("kpp", objectSchemaInfo);
            this.managementIndex = addColumnDetails("management", objectSchemaInfo);
            this.innIndex = addColumnDetails("inn", objectSchemaInfo);
            this.ogrnIndex = addColumnDetails("ogrn", objectSchemaInfo);
            this.opfIndex = addColumnDetails("opf", objectSchemaInfo);
            this.stateIndex = addColumnDetails("state", objectSchemaInfo);
            this.addressIndex = addColumnDetails("address", objectSchemaInfo);
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
            dst.innIndex = src.innIndex;
            dst.ogrnIndex = src.ogrnIndex;
            dst.opfIndex = src.opfIndex;
            dst.stateIndex = src.stateIndex;
            dst.addressIndex = src.addressIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("kpp");
        fieldNames.add("management");
        fieldNames.add("inn");
        fieldNames.add("ogrn");
        fieldNames.add("opf");
        fieldNames.add("state");
        fieldNames.add("address");
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

    @Override
    @SuppressWarnings("cast")
    public String realmGet$inn() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.innIndex);
    }

    @Override
    public void realmSet$inn(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.innIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.innIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.innIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.innIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ogrn() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ogrnIndex);
    }

    @Override
    public void realmSet$ogrn(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ogrnIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ogrnIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ogrnIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ogrnIndex, value);
    }

    @Override
    public com.gig.gio.search_by_counterparty.model.Opf realmGet$opf() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.opfIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.gig.gio.search_by_counterparty.model.Opf.class, proxyState.getRow$realm().getLink(columnInfo.opfIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$opf(com.gig.gio.search_by_counterparty.model.Opf value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("opf")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.opfIndex);
                return;
            }
            if (!RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
            if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            }
            row.getTable().setLink(columnInfo.opfIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.opfIndex);
            return;
        }
        if (!(RealmObject.isManaged(value) && RealmObject.isValid(value))) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.opfIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.gig.gio.search_by_counterparty.model.State realmGet$state() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.stateIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.gig.gio.search_by_counterparty.model.State.class, proxyState.getRow$realm().getLink(columnInfo.stateIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$state(com.gig.gio.search_by_counterparty.model.State value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("state")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.stateIndex);
                return;
            }
            if (!RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
            if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            }
            row.getTable().setLink(columnInfo.stateIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.stateIndex);
            return;
        }
        if (!(RealmObject.isManaged(value) && RealmObject.isValid(value))) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.stateIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.gig.gio.search_by_counterparty.model.Address realmGet$address() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.addressIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.gig.gio.search_by_counterparty.model.Address.class, proxyState.getRow$realm().getLink(columnInfo.addressIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$address(com.gig.gio.search_by_counterparty.model.Address value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("address")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.addressIndex);
                return;
            }
            if (!RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
            if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            }
            row.getTable().setLink(columnInfo.addressIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.addressIndex);
            return;
        }
        if (!(RealmObject.isManaged(value) && RealmObject.isValid(value))) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.addressIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Data");
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("kpp", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("management", RealmFieldType.OBJECT, "Management");
        builder.addPersistedProperty("inn", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ogrn", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("opf", RealmFieldType.OBJECT, "Opf");
        builder.addPersistedLinkProperty("state", RealmFieldType.OBJECT, "State");
        builder.addPersistedLinkProperty("address", RealmFieldType.OBJECT, "Address");
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
        final List<String> excludeFields = new ArrayList<String>(4);
        com.gig.gio.search_by_counterparty.model.Data obj = null;
        if (update) {
            Table table = realm.getTable(com.gig.gio.search_by_counterparty.model.Data.class);
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
            if (json.has("opf")) {
                excludeFields.add("opf");
            }
            if (json.has("state")) {
                excludeFields.add("state");
            }
            if (json.has("address")) {
                excludeFields.add("address");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.DataRealmProxy) realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.Data.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.DataRealmProxy) realm.createObjectInternal(com.gig.gio.search_by_counterparty.model.Data.class, json.getString("id"), true, excludeFields);
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
        if (json.has("inn")) {
            if (json.isNull("inn")) {
                objProxy.realmSet$inn(null);
            } else {
                objProxy.realmSet$inn((String) json.getString("inn"));
            }
        }
        if (json.has("ogrn")) {
            if (json.isNull("ogrn")) {
                objProxy.realmSet$ogrn(null);
            } else {
                objProxy.realmSet$ogrn((String) json.getString("ogrn"));
            }
        }
        if (json.has("opf")) {
            if (json.isNull("opf")) {
                objProxy.realmSet$opf(null);
            } else {
                com.gig.gio.search_by_counterparty.model.Opf opfObj = OpfRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("opf"), update);
                objProxy.realmSet$opf(opfObj);
            }
        }
        if (json.has("state")) {
            if (json.isNull("state")) {
                objProxy.realmSet$state(null);
            } else {
                com.gig.gio.search_by_counterparty.model.State stateObj = StateRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("state"), update);
                objProxy.realmSet$state(stateObj);
            }
        }
        if (json.has("address")) {
            if (json.isNull("address")) {
                objProxy.realmSet$address(null);
            } else {
                com.gig.gio.search_by_counterparty.model.Address addressObj = AddressRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("address"), update);
                objProxy.realmSet$address(addressObj);
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
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
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
            } else if (name.equals("inn")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$inn((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$inn(null);
                }
            } else if (name.equals("ogrn")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ogrn((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ogrn(null);
                }
            } else if (name.equals("opf")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$opf(null);
                } else {
                    com.gig.gio.search_by_counterparty.model.Opf opfObj = OpfRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$opf(opfObj);
                }
            } else if (name.equals("state")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$state(null);
                } else {
                    com.gig.gio.search_by_counterparty.model.State stateObj = StateRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$state(stateObj);
                }
            } else if (name.equals("address")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$address(null);
                } else {
                    com.gig.gio.search_by_counterparty.model.Address addressObj = AddressRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$address(addressObj);
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
            String value = ((DataRealmProxyInterface) object).realmGet$id();
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
        realmObjectCopy.realmSet$inn(realmObjectSource.realmGet$inn());
        realmObjectCopy.realmSet$ogrn(realmObjectSource.realmGet$ogrn());

        com.gig.gio.search_by_counterparty.model.Opf opfObj = realmObjectSource.realmGet$opf();
        if (opfObj == null) {
            realmObjectCopy.realmSet$opf(null);
        } else {
            com.gig.gio.search_by_counterparty.model.Opf cacheopf = (com.gig.gio.search_by_counterparty.model.Opf) cache.get(opfObj);
            if (cacheopf != null) {
                realmObjectCopy.realmSet$opf(cacheopf);
            } else {
                realmObjectCopy.realmSet$opf(OpfRealmProxy.copyOrUpdate(realm, opfObj, update, cache));
            }
        }

        com.gig.gio.search_by_counterparty.model.State stateObj = realmObjectSource.realmGet$state();
        if (stateObj == null) {
            realmObjectCopy.realmSet$state(null);
        } else {
            com.gig.gio.search_by_counterparty.model.State cachestate = (com.gig.gio.search_by_counterparty.model.State) cache.get(stateObj);
            if (cachestate != null) {
                realmObjectCopy.realmSet$state(cachestate);
            } else {
                realmObjectCopy.realmSet$state(StateRealmProxy.copyOrUpdate(realm, stateObj, update, cache));
            }
        }

        com.gig.gio.search_by_counterparty.model.Address addressObj = realmObjectSource.realmGet$address();
        if (addressObj == null) {
            realmObjectCopy.realmSet$address(null);
        } else {
            com.gig.gio.search_by_counterparty.model.Address cacheaddress = (com.gig.gio.search_by_counterparty.model.Address) cache.get(addressObj);
            if (cacheaddress != null) {
                realmObjectCopy.realmSet$address(cacheaddress);
            } else {
                realmObjectCopy.realmSet$address(AddressRealmProxy.copyOrUpdate(realm, addressObj, update, cache));
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
        String primaryKeyValue = ((DataRealmProxyInterface) object).realmGet$id();
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
        String realmGet$inn = ((DataRealmProxyInterface) object).realmGet$inn();
        if (realmGet$inn != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.innIndex, rowIndex, realmGet$inn, false);
        }
        String realmGet$ogrn = ((DataRealmProxyInterface) object).realmGet$ogrn();
        if (realmGet$ogrn != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ogrnIndex, rowIndex, realmGet$ogrn, false);
        }

        com.gig.gio.search_by_counterparty.model.Opf opfObj = ((DataRealmProxyInterface) object).realmGet$opf();
        if (opfObj != null) {
            Long cacheopf = cache.get(opfObj);
            if (cacheopf == null) {
                cacheopf = OpfRealmProxy.insert(realm, opfObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.opfIndex, rowIndex, cacheopf, false);
        }

        com.gig.gio.search_by_counterparty.model.State stateObj = ((DataRealmProxyInterface) object).realmGet$state();
        if (stateObj != null) {
            Long cachestate = cache.get(stateObj);
            if (cachestate == null) {
                cachestate = StateRealmProxy.insert(realm, stateObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.stateIndex, rowIndex, cachestate, false);
        }

        com.gig.gio.search_by_counterparty.model.Address addressObj = ((DataRealmProxyInterface) object).realmGet$address();
        if (addressObj != null) {
            Long cacheaddress = cache.get(addressObj);
            if (cacheaddress == null) {
                cacheaddress = AddressRealmProxy.insert(realm, addressObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.addressIndex, rowIndex, cacheaddress, false);
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
            String primaryKeyValue = ((DataRealmProxyInterface) object).realmGet$id();
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
            String realmGet$inn = ((DataRealmProxyInterface) object).realmGet$inn();
            if (realmGet$inn != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.innIndex, rowIndex, realmGet$inn, false);
            }
            String realmGet$ogrn = ((DataRealmProxyInterface) object).realmGet$ogrn();
            if (realmGet$ogrn != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ogrnIndex, rowIndex, realmGet$ogrn, false);
            }

            com.gig.gio.search_by_counterparty.model.Opf opfObj = ((DataRealmProxyInterface) object).realmGet$opf();
            if (opfObj != null) {
                Long cacheopf = cache.get(opfObj);
                if (cacheopf == null) {
                    cacheopf = OpfRealmProxy.insert(realm, opfObj, cache);
                }
                table.setLink(columnInfo.opfIndex, rowIndex, cacheopf, false);
            }

            com.gig.gio.search_by_counterparty.model.State stateObj = ((DataRealmProxyInterface) object).realmGet$state();
            if (stateObj != null) {
                Long cachestate = cache.get(stateObj);
                if (cachestate == null) {
                    cachestate = StateRealmProxy.insert(realm, stateObj, cache);
                }
                table.setLink(columnInfo.stateIndex, rowIndex, cachestate, false);
            }

            com.gig.gio.search_by_counterparty.model.Address addressObj = ((DataRealmProxyInterface) object).realmGet$address();
            if (addressObj != null) {
                Long cacheaddress = cache.get(addressObj);
                if (cacheaddress == null) {
                    cacheaddress = AddressRealmProxy.insert(realm, addressObj, cache);
                }
                table.setLink(columnInfo.addressIndex, rowIndex, cacheaddress, false);
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
        String primaryKeyValue = ((DataRealmProxyInterface) object).realmGet$id();
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
        String realmGet$inn = ((DataRealmProxyInterface) object).realmGet$inn();
        if (realmGet$inn != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.innIndex, rowIndex, realmGet$inn, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.innIndex, rowIndex, false);
        }
        String realmGet$ogrn = ((DataRealmProxyInterface) object).realmGet$ogrn();
        if (realmGet$ogrn != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ogrnIndex, rowIndex, realmGet$ogrn, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ogrnIndex, rowIndex, false);
        }

        com.gig.gio.search_by_counterparty.model.Opf opfObj = ((DataRealmProxyInterface) object).realmGet$opf();
        if (opfObj != null) {
            Long cacheopf = cache.get(opfObj);
            if (cacheopf == null) {
                cacheopf = OpfRealmProxy.insertOrUpdate(realm, opfObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.opfIndex, rowIndex, cacheopf, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.opfIndex, rowIndex);
        }

        com.gig.gio.search_by_counterparty.model.State stateObj = ((DataRealmProxyInterface) object).realmGet$state();
        if (stateObj != null) {
            Long cachestate = cache.get(stateObj);
            if (cachestate == null) {
                cachestate = StateRealmProxy.insertOrUpdate(realm, stateObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.stateIndex, rowIndex, cachestate, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.stateIndex, rowIndex);
        }

        com.gig.gio.search_by_counterparty.model.Address addressObj = ((DataRealmProxyInterface) object).realmGet$address();
        if (addressObj != null) {
            Long cacheaddress = cache.get(addressObj);
            if (cacheaddress == null) {
                cacheaddress = AddressRealmProxy.insertOrUpdate(realm, addressObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.addressIndex, rowIndex, cacheaddress, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.addressIndex, rowIndex);
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
            String primaryKeyValue = ((DataRealmProxyInterface) object).realmGet$id();
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
            String realmGet$inn = ((DataRealmProxyInterface) object).realmGet$inn();
            if (realmGet$inn != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.innIndex, rowIndex, realmGet$inn, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.innIndex, rowIndex, false);
            }
            String realmGet$ogrn = ((DataRealmProxyInterface) object).realmGet$ogrn();
            if (realmGet$ogrn != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ogrnIndex, rowIndex, realmGet$ogrn, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ogrnIndex, rowIndex, false);
            }

            com.gig.gio.search_by_counterparty.model.Opf opfObj = ((DataRealmProxyInterface) object).realmGet$opf();
            if (opfObj != null) {
                Long cacheopf = cache.get(opfObj);
                if (cacheopf == null) {
                    cacheopf = OpfRealmProxy.insertOrUpdate(realm, opfObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.opfIndex, rowIndex, cacheopf, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.opfIndex, rowIndex);
            }

            com.gig.gio.search_by_counterparty.model.State stateObj = ((DataRealmProxyInterface) object).realmGet$state();
            if (stateObj != null) {
                Long cachestate = cache.get(stateObj);
                if (cachestate == null) {
                    cachestate = StateRealmProxy.insertOrUpdate(realm, stateObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.stateIndex, rowIndex, cachestate, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.stateIndex, rowIndex);
            }

            com.gig.gio.search_by_counterparty.model.Address addressObj = ((DataRealmProxyInterface) object).realmGet$address();
            if (addressObj != null) {
                Long cacheaddress = cache.get(addressObj);
                if (cacheaddress == null) {
                    cacheaddress = AddressRealmProxy.insertOrUpdate(realm, addressObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.addressIndex, rowIndex, cacheaddress, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.addressIndex, rowIndex);
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
        unmanagedCopy.realmSet$inn(realmSource.realmGet$inn());
        unmanagedCopy.realmSet$ogrn(realmSource.realmGet$ogrn());

        // Deep copy of opf
        unmanagedCopy.realmSet$opf(OpfRealmProxy.createDetachedCopy(realmSource.realmGet$opf(), currentDepth + 1, maxDepth, cache));

        // Deep copy of state
        unmanagedCopy.realmSet$state(StateRealmProxy.createDetachedCopy(realmSource.realmGet$state(), currentDepth + 1, maxDepth, cache));

        // Deep copy of address
        unmanagedCopy.realmSet$address(AddressRealmProxy.createDetachedCopy(realmSource.realmGet$address(), currentDepth + 1, maxDepth, cache));
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
        realmObjectTarget.realmSet$inn(realmObjectSource.realmGet$inn());
        realmObjectTarget.realmSet$ogrn(realmObjectSource.realmGet$ogrn());
        com.gig.gio.search_by_counterparty.model.Opf opfObj = realmObjectSource.realmGet$opf();
        if (opfObj == null) {
            realmObjectTarget.realmSet$opf(null);
        } else {
            com.gig.gio.search_by_counterparty.model.Opf cacheopf = (com.gig.gio.search_by_counterparty.model.Opf) cache.get(opfObj);
            if (cacheopf != null) {
                realmObjectTarget.realmSet$opf(cacheopf);
            } else {
                realmObjectTarget.realmSet$opf(OpfRealmProxy.copyOrUpdate(realm, opfObj, true, cache));
            }
        }
        com.gig.gio.search_by_counterparty.model.State stateObj = realmObjectSource.realmGet$state();
        if (stateObj == null) {
            realmObjectTarget.realmSet$state(null);
        } else {
            com.gig.gio.search_by_counterparty.model.State cachestate = (com.gig.gio.search_by_counterparty.model.State) cache.get(stateObj);
            if (cachestate != null) {
                realmObjectTarget.realmSet$state(cachestate);
            } else {
                realmObjectTarget.realmSet$state(StateRealmProxy.copyOrUpdate(realm, stateObj, true, cache));
            }
        }
        com.gig.gio.search_by_counterparty.model.Address addressObj = realmObjectSource.realmGet$address();
        if (addressObj == null) {
            realmObjectTarget.realmSet$address(null);
        } else {
            com.gig.gio.search_by_counterparty.model.Address cacheaddress = (com.gig.gio.search_by_counterparty.model.Address) cache.get(addressObj);
            if (cacheaddress != null) {
                realmObjectTarget.realmSet$address(cacheaddress);
            } else {
                realmObjectTarget.realmSet$address(AddressRealmProxy.copyOrUpdate(realm, addressObj, true, cache));
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
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{kpp:");
        stringBuilder.append(realmGet$kpp() != null ? realmGet$kpp() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{management:");
        stringBuilder.append(realmGet$management() != null ? "Management" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{inn:");
        stringBuilder.append(realmGet$inn() != null ? realmGet$inn() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ogrn:");
        stringBuilder.append(realmGet$ogrn() != null ? realmGet$ogrn() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{opf:");
        stringBuilder.append(realmGet$opf() != null ? "Opf" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{state:");
        stringBuilder.append(realmGet$state() != null ? "State" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address:");
        stringBuilder.append(realmGet$address() != null ? "Address" : "null");
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
