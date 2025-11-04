package io.opentelemetry;

import com.google.gson.Gson;
import io.opentelemetry.model.Driver;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Drivers drive fast. Sometimes they are also furious!
 */
public class DriverClient {
  private final OkHttpClient okhttp = new OkHttpClient();
  private final Gson gson;

  public DriverClient(Gson gson) {
    this.gson = gson;
  }

  Driver getRandomDriver() throws IOException {
    Request request = new Request.Builder()
        .url("http://lima-toofurious.internal:3001/driver")
        .build();
      try (Response response = okhttp.newCall(request).execute()) {
        String body = response.body().string();
        return gson.fromJson(body, Driver.class);
      }
  }

}
