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

public class KitBuilderServlet extends HttpServlet {

  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private final CarClient carClient = new CarClient(gson);
  private final DriverClient driverClient = new DriverClient(gson);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    Car car = carClient.getRandomCar();
    Driver driver = driverClient.getRandomDriver();
    BuildKit buildKit = new BuildKit(car, driver);

    String body = gson.toJson(buildKit);
    resp.setStatus(HttpServletResponse.SC_OK);
    resp.setContentType("application/json");
    resp.getWriter().println(body);

  }
}