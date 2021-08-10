package com.aviation.apiautomation.helpers.response;
import com.aviation.apiautomation.helpers.statusCode.ErrorCodeHelper;
import io.restassured.response.Response;

import static com.sun.activation.registries.LogSupport.log;
import static org.hamcrest.Matchers.is;

public class PaginationHelper {
    private PaginationHelper() {
    }

    public static void containsValue(Response response, String type, int value) {

        if(response.getStatusCode()!=200) {
            response.then().log().ifError();
            log("Error code: " + response.getStatusCode() + " Type " + response.getStatusLine() + " ie., "
                    + ErrorCodeHelper.valueOf("ERROR_CODE_HELPER_" + response.getStatusCode() + "_" + response.getStatusLine()));
        }
           else
            // Attributes: limit/ offset/count/total
        {
            String path="pagination."+type.toLowerCase();
            response.then().body(path, is(value));
        }
    }
}
