package com.aviation.apiautomation.helpers;

public enum ApiEndPointHelper {
    ENDPOINT_REALTIME_FLIGHTS("com.aviationapi.realTimeFlights"),
    ENDPOINT_AIRLINE_ROUTES("com.aviationapi.airlineRoutes"),
    ENDPOINT_AIRPORTS("com.aviationapi.airports"),
    ENDPOINT_AIRLINES("com.aviationapi.airlines"),
    ENDPOINT_AIRPLANES("com.aviationapi.airplanes"),
    ENDPOINT_AIRCRAFT_TYPES("com.aviationapi.aircraftTypes"),
    ENDPOINT_AVIATION_TAXES("com.aviationapi.aviationTaxes"),
    ENDPOINT_CITIES("com.aviationapi.cities"),
    ENDPOINT_COUNTRIES("com.aviationapi.countries"),
    ENDPOINT_AUTOCOMPLETE("com.aviationapi.autocomplete");

    private String endpoint;
    ApiEndPointHelper(String endpoint) {
        this.endpoint=endpoint;
    }
    public String getEndpoint() {
        return endpoint;
    }
}
