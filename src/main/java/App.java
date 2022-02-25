import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;

public class App {

    public static void main(String[] args) {

        get("/",(request, response) -> new ModelAndView(new HashMap<>(),"index.hbs"),new HandlebarsTemplateEngine());

        get("/squad/new",(request, response) -> {
            return new ModelAndView(new HashMap<>(),"squad.hbs");
        },new HandlebarsTemplateEngine());

    }
}
