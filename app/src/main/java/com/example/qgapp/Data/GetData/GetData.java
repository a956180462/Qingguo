package com.example.qgapp.Data.GetData;

public interface GetData {
    /*
    以GetDataMethod方式获取数据 -> 指明数据源
    DataBuffer程序内目的数据，并以此创建DataHolder


     */
    String GetDataMethod = "";
    DataHolder DataBuffer(String ... strings);


}
