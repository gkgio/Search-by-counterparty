package com.gig.gio.search_by_counterparty.network;

import com.gig.gio.search_by_counterparty.model.SuggestResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by georgy on 15.10.2017.
 * Gig
 */

public interface NetworkService {
    @POST("suggestions/api/4_1/rs/suggest/party")
    Observable<Response<List<SuggestResponse>>> getSuggestion(@Body String request);
}
