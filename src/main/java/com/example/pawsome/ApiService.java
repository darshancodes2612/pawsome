package com.example.pawsome;

import retrofit2.Call;
import retrofit2.http.Body;

public interface ApiService {
     Call<Void> postTimeData(@Body TimeData timeData);
}
