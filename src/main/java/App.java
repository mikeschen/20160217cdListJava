import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String [] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String,Object>model = new HashMap<String, Object>();
      model.put("cds", request.session().attribute("cds"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap<String,Object>model = new HashMap<String, Object>();
      ArrayList<Cd> cds = request.session().attribute("cds");
      if (cds == null) {
        cds = new ArrayList<Cd>();
        request.session().attribute("cds", cds);
      }
      String newArtist = request.queryParams("artist");
      Cd newCd = new Cd(newArtist);

      cds.add(newCd);
      model.put("cds", cds);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
