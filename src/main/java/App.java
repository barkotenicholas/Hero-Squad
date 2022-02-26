import models.Hero;
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

        post("/success",(request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String squadName = request.queryParams("heroName");
            model.put("hero",squadName);
            return new ModelAndView(model,"herosuccess.hbs");

         },new HandlebarsTemplateEngine());

        post("/hero/:id",(request, response) -> {

            int id = Integer.parseInt(request.params(":id"));
            System.out.println("Id is"+id);
            String heroName = request.queryParams("heroName");
            String heroWeakness = request.queryParams("heroWeakness");
            String heroStrength = request.queryParams("heroStrength");
            int age = Integer.parseInt(request.queryParams("heroAge"));

            Hero hero = new Hero(heroName,age,heroStrength,heroWeakness);
            Squad squad = Squad.findById(id);

            squad.addHeroes(hero);

            Map<String,Object> model = new HashMap<>();
            model.put("hero",heroName);

            return new ModelAndView(model,"herosuccess.hbs");
        },new HandlebarsTemplateEngine());


        get("/hero/new/:id",(request, response) -> {

            int squadId = Integer.parseInt(request.params(":id"));
            Map<String,Object> model = new HashMap<>();
            String squadName = Squad.findById(squadId).getName();
            model.put("squad",squadId);
            model.put("squadName",squadName);
            return new ModelAndView(model,"addhero.hbs");
        }, new HandlebarsTemplateEngine());


        get("/hero/:id",(request, response) -> {

            int id = Integer.parseInt(request.params(":id"));
            Squad one = Squad.findById(id);
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = one.allHeroes();
            model.put("hero",heroes);
            model.put("squad",one);
            return new ModelAndView(model,"hero.hbs");
        },new HandlebarsTemplateEngine());
    }
}
