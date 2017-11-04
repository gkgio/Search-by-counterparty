package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.gig.gio.search_by_counterparty.model.Opf.class);
        modelClasses.add(com.gig.gio.search_by_counterparty.model.SuggestResponse.class);
        modelClasses.add(com.gig.gio.search_by_counterparty.model.Address.class);
        modelClasses.add(com.gig.gio.search_by_counterparty.model.State.class);
        modelClasses.add(com.gig.gio.search_by_counterparty.model.AddressData.class);
        modelClasses.add(com.gig.gio.search_by_counterparty.model.Data.class);
        modelClasses.add(com.gig.gio.search_by_counterparty.model.ResponseData.class);
        modelClasses.add(com.gig.gio.search_by_counterparty.common.LongWrapper.class);
        modelClasses.add(com.gig.gio.search_by_counterparty.model.Management.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>();
        infoMap.put(com.gig.gio.search_by_counterparty.model.Opf.class, io.realm.OpfRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.gig.gio.search_by_counterparty.model.SuggestResponse.class, io.realm.SuggestResponseRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.gig.gio.search_by_counterparty.model.Address.class, io.realm.AddressRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.gig.gio.search_by_counterparty.model.State.class, io.realm.StateRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.gig.gio.search_by_counterparty.model.AddressData.class, io.realm.AddressDataRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.gig.gio.search_by_counterparty.model.Data.class, io.realm.DataRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.gig.gio.search_by_counterparty.model.ResponseData.class, io.realm.ResponseDataRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.gig.gio.search_by_counterparty.common.LongWrapper.class, io.realm.LongWrapperRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.gig.gio.search_by_counterparty.model.Management.class, io.realm.ManagementRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
            return io.realm.OpfRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
            return io.realm.SuggestResponseRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
            return io.realm.AddressRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
            return io.realm.StateRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
            return io.realm.AddressDataRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
            return io.realm.DataRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
            return io.realm.ResponseDataRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
            return io.realm.LongWrapperRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
            return io.realm.ManagementRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
            return io.realm.OpfRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
            return io.realm.SuggestResponseRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
            return io.realm.AddressRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
            return io.realm.StateRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
            return io.realm.AddressDataRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
            return io.realm.DataRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
            return io.realm.ResponseDataRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
            return io.realm.LongWrapperRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
            return io.realm.ManagementRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
            return io.realm.OpfRealmProxy.getTableName();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
            return io.realm.SuggestResponseRealmProxy.getTableName();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
            return io.realm.AddressRealmProxy.getTableName();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
            return io.realm.StateRealmProxy.getTableName();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
            return io.realm.AddressDataRealmProxy.getTableName();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
            return io.realm.DataRealmProxy.getTableName();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
            return io.realm.ResponseDataRealmProxy.getTableName();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
            return io.realm.LongWrapperRealmProxy.getTableName();
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
            return io.realm.ManagementRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
                return clazz.cast(new io.realm.OpfRealmProxy());
            }
            if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
                return clazz.cast(new io.realm.SuggestResponseRealmProxy());
            }
            if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
                return clazz.cast(new io.realm.AddressRealmProxy());
            }
            if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
                return clazz.cast(new io.realm.StateRealmProxy());
            }
            if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
                return clazz.cast(new io.realm.AddressDataRealmProxy());
            }
            if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
                return clazz.cast(new io.realm.DataRealmProxy());
            }
            if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
                return clazz.cast(new io.realm.ResponseDataRealmProxy());
            }
            if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
                return clazz.cast(new io.realm.LongWrapperRealmProxy());
            }
            if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
                return clazz.cast(new io.realm.ManagementRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
            return clazz.cast(io.realm.OpfRealmProxy.copyOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.Opf) obj, update, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
            return clazz.cast(io.realm.SuggestResponseRealmProxy.copyOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.SuggestResponse) obj, update, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
            return clazz.cast(io.realm.AddressRealmProxy.copyOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.Address) obj, update, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
            return clazz.cast(io.realm.StateRealmProxy.copyOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.State) obj, update, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
            return clazz.cast(io.realm.AddressDataRealmProxy.copyOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.AddressData) obj, update, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
            return clazz.cast(io.realm.DataRealmProxy.copyOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.Data) obj, update, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
            return clazz.cast(io.realm.ResponseDataRealmProxy.copyOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.ResponseData) obj, update, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
            return clazz.cast(io.realm.LongWrapperRealmProxy.copyOrUpdate(realm, (com.gig.gio.search_by_counterparty.common.LongWrapper) obj, update, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
            return clazz.cast(io.realm.ManagementRealmProxy.copyOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.Management) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
            io.realm.OpfRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.Opf) object, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
            io.realm.SuggestResponseRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.SuggestResponse) object, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
            io.realm.AddressRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.Address) object, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
            io.realm.StateRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.State) object, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
            io.realm.AddressDataRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.AddressData) object, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
            io.realm.DataRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.Data) object, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
            io.realm.ResponseDataRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.ResponseData) object, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
            io.realm.LongWrapperRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.common.LongWrapper) object, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
            io.realm.ManagementRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.Management) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
                io.realm.OpfRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.Opf) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
                io.realm.SuggestResponseRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.SuggestResponse) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
                io.realm.AddressRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.Address) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
                io.realm.StateRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.State) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
                io.realm.AddressDataRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.AddressData) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
                io.realm.DataRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.Data) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
                io.realm.ResponseDataRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.ResponseData) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
                io.realm.LongWrapperRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.common.LongWrapper) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
                io.realm.ManagementRealmProxy.insert(realm, (com.gig.gio.search_by_counterparty.model.Management) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
                    io.realm.OpfRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
                    io.realm.SuggestResponseRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
                    io.realm.AddressRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
                    io.realm.StateRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
                    io.realm.AddressDataRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
                    io.realm.DataRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
                    io.realm.ResponseDataRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
                    io.realm.LongWrapperRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
                    io.realm.ManagementRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
            io.realm.OpfRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.Opf) obj, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
            io.realm.SuggestResponseRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.SuggestResponse) obj, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
            io.realm.AddressRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.Address) obj, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
            io.realm.StateRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.State) obj, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
            io.realm.AddressDataRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.AddressData) obj, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
            io.realm.DataRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.Data) obj, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
            io.realm.ResponseDataRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.ResponseData) obj, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
            io.realm.LongWrapperRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.common.LongWrapper) obj, cache);
        } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
            io.realm.ManagementRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.Management) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
                io.realm.OpfRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.Opf) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
                io.realm.SuggestResponseRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.SuggestResponse) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
                io.realm.AddressRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.Address) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
                io.realm.StateRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.State) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
                io.realm.AddressDataRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.AddressData) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
                io.realm.DataRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.Data) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
                io.realm.ResponseDataRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.ResponseData) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
                io.realm.LongWrapperRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.common.LongWrapper) object, cache);
            } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
                io.realm.ManagementRealmProxy.insertOrUpdate(realm, (com.gig.gio.search_by_counterparty.model.Management) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
                    io.realm.OpfRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
                    io.realm.SuggestResponseRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
                    io.realm.AddressRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
                    io.realm.StateRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
                    io.realm.AddressDataRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
                    io.realm.DataRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
                    io.realm.ResponseDataRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
                    io.realm.LongWrapperRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
                    io.realm.ManagementRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
            return clazz.cast(io.realm.OpfRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
            return clazz.cast(io.realm.SuggestResponseRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
            return clazz.cast(io.realm.AddressRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
            return clazz.cast(io.realm.StateRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
            return clazz.cast(io.realm.AddressDataRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
            return clazz.cast(io.realm.DataRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
            return clazz.cast(io.realm.ResponseDataRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
            return clazz.cast(io.realm.LongWrapperRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
            return clazz.cast(io.realm.ManagementRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
            return clazz.cast(io.realm.OpfRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
            return clazz.cast(io.realm.SuggestResponseRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
            return clazz.cast(io.realm.AddressRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
            return clazz.cast(io.realm.StateRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
            return clazz.cast(io.realm.AddressDataRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
            return clazz.cast(io.realm.DataRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
            return clazz.cast(io.realm.ResponseDataRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
            return clazz.cast(io.realm.LongWrapperRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
            return clazz.cast(io.realm.ManagementRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Opf.class)) {
            return clazz.cast(io.realm.OpfRealmProxy.createDetachedCopy((com.gig.gio.search_by_counterparty.model.Opf) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.SuggestResponse.class)) {
            return clazz.cast(io.realm.SuggestResponseRealmProxy.createDetachedCopy((com.gig.gio.search_by_counterparty.model.SuggestResponse) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Address.class)) {
            return clazz.cast(io.realm.AddressRealmProxy.createDetachedCopy((com.gig.gio.search_by_counterparty.model.Address) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.State.class)) {
            return clazz.cast(io.realm.StateRealmProxy.createDetachedCopy((com.gig.gio.search_by_counterparty.model.State) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.AddressData.class)) {
            return clazz.cast(io.realm.AddressDataRealmProxy.createDetachedCopy((com.gig.gio.search_by_counterparty.model.AddressData) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Data.class)) {
            return clazz.cast(io.realm.DataRealmProxy.createDetachedCopy((com.gig.gio.search_by_counterparty.model.Data) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.ResponseData.class)) {
            return clazz.cast(io.realm.ResponseDataRealmProxy.createDetachedCopy((com.gig.gio.search_by_counterparty.model.ResponseData) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.common.LongWrapper.class)) {
            return clazz.cast(io.realm.LongWrapperRealmProxy.createDetachedCopy((com.gig.gio.search_by_counterparty.common.LongWrapper) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.gig.gio.search_by_counterparty.model.Management.class)) {
            return clazz.cast(io.realm.ManagementRealmProxy.createDetachedCopy((com.gig.gio.search_by_counterparty.model.Management) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
