package profesorp.oauth2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
	
	 @RequestMapping({"/","index"})
	  public String inicio() {
	    return "index";
	  }

	 @RequestMapping("/webprivado")
	  public String privado() {
	    return "privado";
	  }
	 @RequestMapping("/webpublico")
	  public String loginpub() {
	    return "publico";
	  }
	 @RequestMapping("/webadmin")
	  public String admin() {
	    return "admin";
	  }
	 
	 @CrossOrigin(origins = "http://localhost:4200",
			 methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
	 @RequestMapping("/login")
	  public String login() {
	    return "login";
	  }
}
