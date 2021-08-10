package com.aviation.apiautomation.helpers.response;

import com.aviation.apiautomation.helpers.statusCode.ErrorCodeHelper;
import io.restassured.response.Response;

import static com.sun.activation.registries.LogSupport.log;
import static org.hamcrest.CoreMatchers.hasItem;

public class DataHelper {
    private DataHelper() {
    }


    public static void containsValue(String type,Response response, String subType, String value) {
        final String arrivalString="arrival";
        if (response.getStatusCode() != 200)
            describeTheErrorCode(response);
        else if (subType.isEmpty()) {
                // Attributes: flight_date/ flight_status
                switch (subType.toLowerCase()) {
                    case "flight_date":
                    case "flight date":
                    case "date":
                        response.then().assertThat().body("data.flight_date", hasItem(value));
                        break;
                    case "flight_status":
                    case "flight status":
                    case "status":
                        response.then().assertThat().body("data.flight_status", hasItem(value));
                        break;
                    default:
                        log("No information on this");
                        break;

                }
            } else if (type.toLowerCase().equalsIgnoreCase("departure")) {

                // Attributes: airport": "San Francisco International",
                //                "timezone": "America/Los_Angeles",
                //                "iata": "SFO",
                //                "icao": "KSFO",
                //                "terminal": "2",
                //                "gate": "D11",
                //                "delay": 13,
                //                "scheduled": "2019-12-12T04:20:00+00:00",
                //                "estimated": "2019-12-12T04:20:00+00:00",
                //                "actual": "2019-12-12T04:20:13+00:00",
                //                "estimated_runway": "2019-12-12T04:20:13+00:00",
                //                "actual_runway": "2019-12-12T04:20:13+00:00"
                handleOtherArrivalDepartureResponse(arrivalString, response, value, subType);

            } else if (type.toLowerCase().equalsIgnoreCase(arrivalString)) {
                // attributes: "airport": "Dallas/Fort Worth International",
                //                "timezone": "America/Chicago",
                //                "iata": "DFW",
                //                "icao": "KDFW",
                //                "terminal": "A",
                //                "gate": "A22",
                //                "baggage": "A17",
                //                "delay": 0,
                //                "scheduled": "2019-12-12T04:20:00+00:00",
                //                "estimated": "2019-12-12T04:20:00+00:00",
                //                "actual": null,
                //                "estimated_runway": null,
                //                "actual_runway": null

                handleOtherArrivalDepartureResponse(arrivalString, response, value, subType);
            } else if (type.toLowerCase().equalsIgnoreCase("airline")) {
                //attributes: "name": "American Airlines",
                //                "iata": "AA",
                //                "icao": "AAL"

                response.then().assertThat().body("data.airline" + subType.toLowerCase(), hasItem(value));

            } else if (type.toLowerCase().contains("flight")) {
                //attributes: "number": "1004",
                //                "iata": "AA1004",
                //                "icao": "AAL1004",
                //                "codeshared": null

                response.then().assertThat().body("data.flight" + subType.toLowerCase(), hasItem(value));

            } else if (type.toLowerCase().contains("aircraft")) {
                // attributes: "registration": "N160AN",
                //               "iata": "A321",
                //               "icao": "A321",
                //               "icao24": "A0F1BB"

                response.then().assertThat().body("data.aircraft" + subType.toLowerCase(), hasItem(value));

            } else if (type.toLowerCase().contains("live")) {
                //attributes:"updated": "2019-12-12T10:00:00+00:00",
                //                "latitude": 36.28560000,
                //                "longitude": -106.80700000,
                //                "altitude": 8846.820,
                //                "direction": 114.340,
                //                "speed_horizontal": 894.348,
                //                "speed_vertical": 1.188,
                //                "is_ground": false

                switch (subType.toLowerCase()) {
                    case "speed_horizontal":
                    case "speed horizontal":
                    case "horizontal":
                        response.then().assertThat().body("data.live.speed_horizontal", hasItem(value));
                        break;
                    case "speed_vertical":
                    case "speed vertical":
                    case "vertical":
                        response.then().assertThat().body("data.live.speed_vertical", hasItem(value));
                        break;
                    default:
                        response.then().assertThat().body("data.live" + subType.toLowerCase(), hasItem(value));
                        break;

                }
            }
    }

    private static void describeTheErrorCode(Response response) {
        response.then().log().ifError();
        log("Error code: "+ response.getStatusCode() +" Type "+response.getStatusLine() +" ie., "
                    + ErrorCodeHelper.valueOf("ERROR_CODE_HELPER_" +response.getStatusCode() +"_"+ response.getStatusLine()));

    }


    private static void handleOtherArrivalDepartureResponse(String flightType,Response response,String value,String attribute) {
        final String dataString="data.";
        switch(attribute.toLowerCase())
        {
            case "estimated_runway":
            case "estimated runway":
                response.then().assertThat().body(dataString+flightType+".estimated_runway", hasItem(value));
                break;
            case "actual_runway":
            case "actual runway":
                response.then().assertThat().body(dataString+flightType+".actual_runway", hasItem(value));
                break;
            default: response.then().assertThat().body(dataString+flightType+attribute.toLowerCase(), hasItem(value));
                break;

        }
    }


}
