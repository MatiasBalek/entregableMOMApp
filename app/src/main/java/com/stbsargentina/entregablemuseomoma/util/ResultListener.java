package com.stbsargentina.entregablemuseomoma.util;

public interface ResultListener<T> {
    //el método finish es la llamada que me avisa cuando el pedido terminó,
    // devolviendome la información del tipo pedido en el parámetro result
    void finish(T result);
}