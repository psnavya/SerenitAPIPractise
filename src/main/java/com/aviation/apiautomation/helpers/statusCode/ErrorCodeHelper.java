package com.aviation.apiautomation.helpers.statusCode;

public enum ErrorCodeHelper {
    ERROR_CODE_HELPER_401_invalid_access_key ("An invalid API access key was supplied."),
    ERROR_CODE_HELPER_401_missing_access_key("No API access key was supplied."),
    ERROR_CODE_HELPER_401_inactive_user("The given user account is inactive."),
    ERROR_CODE_HELPER_403_https_access_restricted("HTTPS access is not supported on the current subscription plan."),
    ERROR_CODE_HELPER_403_function_access_restricted("The given API endpoint is not supported on the current subscription plan."),
    ERROR_CODE_HELPER_404_invalid_api_function("The given API endpoint does not exist."),
    ERROR_CODE_HELPER_404_404_not_found("Resource not found."),
    ERROR_CODE_HELPER_429_usage_limit_reached("The given user account has reached its monthly allowed request volume."),
    ERROR_CODE_HELPER_429_rate_limit_reached("The given user account has reached the rate limit."),
    ERROR_CODE_HELPER_500_internal_error("An internal error occurred.");

    String errorCodeDetails;
    ErrorCodeHelper(String key) {
        this.errorCodeDetails=errorCodeDetails;

    }
    public String getEndpoint() {
        return errorCodeDetails;
    }
}
