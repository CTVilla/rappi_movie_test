package ctorres.developer.movievisor.common

sealed class Resource<T> (val data: T? = null, val msg: String? = null) {
    class onSuccess<T>(data: T): Resource<T>(data)
    class onError<T>(msg: String, data: T? =null): Resource<T>(data, msg)
    class onLoading<T>(data: T? = null): Resource<T>(data)
}