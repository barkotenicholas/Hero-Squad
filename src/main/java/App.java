import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class App {

    public static void main(String[] args) {

        get("/",(request, response) -> new ModelAndView(new HashMap<>(),"index.hbs"),new HandlebarsTemplateEngine());

        get("/squad/new",(request, response) -> {

            return new ModelAndView(new HashMap<>(),"squad.hbs");
        },new HandlebarsTemplateEngine());

        get("/squad",(request, response) -> {
            ArrayList<Squad> squads = Squad.getAll();
            Map<String,Object> model = new HashMap<>();
            model.put("squad",squads);
            return new ModelAndView(model,"squadlist.hbs");
        },new HandlebarsTemplateEngine());

        post("/squad",(request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String squadName = request.queryParams("squadName");
            String squadPurpose = request.queryParams("squadPurpose");
            int squadSize = Integer.parseInt(request.queryParams("size"));

            Squad squad = new Squad(squadName,squadSize,squadPurpose);

            model.put("squadName",squadName);

            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());


        get("/hero",(request, response) -> {

            return new ModelAndView(new HashMap<>(),"hero.hbs");
        },new HandlebarsTemplateEngine());
    }
}
