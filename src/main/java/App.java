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
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("artists/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/artists-new.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artists", (request, response) -> {
      HashMap<String,Object>model = new HashMap<String, Object>();
      model.put("cds", Cd.all());
      model.put("template", "templates/artists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artists/:id",  (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Cd cd = Cd.find(Integer.parseInt(request.params(":id")));
      model.put("cd", cd);
      model.put("albums", Album.all());
      model.put("template", "templates/albums.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    post("/artists", (request, response) -> {
      HashMap<String,Object>model = new HashMap<String, Object>();
      String userArtistName = request.queryParams("artist");
      // for (Cd cd : Cd.all()) {
      //   String name = cd.getName();
      // }
      Cd newCd = new Cd(userArtistName);
      model.put("cds", Cd.all());
      model.put("template", "templates/artists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/artists/:id", (request, response) -> {
      HashMap<String,Object>model = new HashMap<String, Object>();
      Cd cd = Cd.find(Integer.parseInt(request.params(":id")));

      String userAlbumName = request.queryParams("albumname");

      // for(Album album : Album.all()) {
      // String name = album.getName();
      // }
      Album newAlbum = new Album(userAlbumName, cd);
      model.put("albums", Album.all());
      model.put("template", "templates/albums.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
