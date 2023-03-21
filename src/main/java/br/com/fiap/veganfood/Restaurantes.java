import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Restaurentes {

    @RequestMapping("/api/restaurantes")
    @ResponseBody
    public String show (){
        return "restaurantes"
    }
}