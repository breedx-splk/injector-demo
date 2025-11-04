package io.opentelemetry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.opentelemetry.model.BuildKit;
import io.opentelemetry.model.Car;
import io.opentelemetry.model.Driver;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class KitBuilderServlet extends HttpServlet {

  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private final CarClient carClient = new CarClient(gson);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

      //TODO: Make these call the dependent services...
      Car car = carClient.getRandomCar();
      Driver driver = getDriver();
      BuildKit buildKit = new BuildKit(car, driver);

      String body = gson.toJson(buildKit);
      resp.setStatus(HttpServletResponse.SC_OK);
      resp.setContentType("application/json");
      resp.getWriter().println(body);
  }

  private Driver getDriver(){
    return new Driver("Jimmy", "Driver", 22);
  }
}
