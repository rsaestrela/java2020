package me.estrela.java2020.records;

record Response<T>(T response, boolean succeeded, String reason, Integer code) {

    private static final String ERROR_PREFIX = "ERR";

    Response {
        if (!succeeded && reason == null || reason.isBlank()) throw new IllegalStateException("Invalid response");
    }

    private Response(T response) {
        this(response, true, null, 0);
    }

    public static <T> Response<T> success(T response) {
        return new Response<>(response);
    }

    public String getErrorCode() {
        return succeeded ? null : ERROR_PREFIX + code;
    }

    @Override
    public String reason() {
        return "Reason:" + reason;
    }

}
