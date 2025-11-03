package io.opentelemetry;

import com.google.gson.Gson;
import io.opentelemetry.model.BuildKit;
import io.opentelemetry.model.Car;
import io.opentelemetry.model.Driver;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KitBuilderServlet extends HttpServlet {

  private final Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

      //TODO: Make these call the dependent services...
      Car car = getCar();
      String color = getColor();
      Driver driver = getDriver();
      BuildKit buildKit = new BuildKit(car, color, driver);

      String body = gson.toJson(buildKit);
      resp.setStatus(HttpServletResponse.SC_OK);
      resp.setContentType("application/json");
      resp.getWriter().println(body);
  }

  private Car getCar() {
    return new Car(1999, "Toyota", "Camry");
  }

  private String getColor() {
    return "#FF0000";
  }

  private Driver getDriver(){
    return new Driver("Jimmy", "Driver", 22);
  }
}
