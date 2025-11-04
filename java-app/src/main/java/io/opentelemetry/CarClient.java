package io.opentelemetry;

import com.google.gson.Gson;
import io.opentelemetry.model.Car;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * I can fetch cars with the best of them!
 */
public class CarClient {
  private final OkHttpClient okhttp = new OkHttpClient();
  private final Gson gson;

  public CarClient(Gson gson) {
    this.gson = gson;
  }

  Car getRandomCar() throws IOException {
    Request request = new Request.Builder()
        .url("http://lima-toofurious.internal:3000/car")
        .build();
      try (Response response = okhttp.newCall(request).execute()) {
        String body = response.body().string();
        return gson.fromJson(body, Car.class);
      }
  }

}
