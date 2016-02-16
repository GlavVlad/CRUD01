package glavvlad.crud01.contoller;

import glavvlad.crud01.model.User;
import glavvlad.crud01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String start(@ModelAttribute User user, BindingResult result, ModelMap model) {
        List<User> users = service.userForOnePage(1);
        int pages = service.numberOfPages();
        model.addAttribute("users", users);
        model.addAttribute("pages", pages);
        return "index";
    }

    @RequestMapping(value = {"pages"}, method = RequestMethod.GET)
    public String paging(@ModelAttribute User user, BindingResult result, ModelMap model, @RequestParam("page") String page) {
        int nPage;
        if (page == null || page.length() == 0) {
            nPage = 1;
        } else {
            nPage = Integer.parseInt(page);
        }
        List<User> users = service.userForOnePage(nPage);
        int pages = service.numberOfPages();
        model.addAttribute("users", users);
        model.addAttribute("pages", pages);
        return "index";
    }

    @RequestMapping(value = {"edit"}, method = RequestMethod.GET)
    public String edit(ModelMap model, @RequestParam("id") String id) {
        User user = service.getUser(Integer.parseInt(id));
        model.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping(value = {"edit"}, method = RequestMethod.POST)
    public String edited(ModelMap model, @ModelAttribute("user") User user) {
        service.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(@ModelAttribute("user") User user) {
        return "add";
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.POST)
    public String added(ModelMap model, @ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = {"delete"}, method = RequestMethod.GET)
    public String delete(ModelMap model, @RequestParam("id") String id) {
        service.deleteUser(Integer.parseInt(id));
        return "redirect:/";
    }

    @RequestMapping(value = {"search"}, method = RequestMethod.POST)
    public String search(@ModelAttribute User user, BindingResult result, ModelMap model) {
        List<User> users = service.searchUser(user.getName());
        model.addAttribute("users", users);
        return "index";
    }
}