package com.gig.gio.search_by_counterparty.network;

import com.gig.gio.search_by_counterparty.model.RequestData;
import com.gig.gio.search_by_counterparty.model.ResponseData;
import com.gig.gio.search_by_counterparty.model.SuggestResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public interface NetworkService {
    @POST("/api/v2/suggest/party")
    Observable<Response<ResponseData>> getSuggestion(@Header("Authorization") String token, @Body RequestData query);
}
