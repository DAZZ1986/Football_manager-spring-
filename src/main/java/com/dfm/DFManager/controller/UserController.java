package com.dfm.DFManager.controller;

import com.dfm.DFManager.model.User;
import com.dfm.DFManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired  //какое-то связывание с конструктором
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }




    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();           //GET - тянем из БД на фронт через атрибут для отображения
        model.addAttribute("usersAtt", users);  //это атрибут "usersAtt", который мы заполняем на фронте из БД, GET запросом.
        return "user-list";
    }



    @GetMapping("/user-create")
    public String createUserFrom(User userObjParamCreate, Model model) {  //Model-это некий аналог мапы в java, в который мы пихаем какие-то атрибуты.
        User aaa = new User();  //в данном методе/шаге, мы создали юзера и установили ему имя по умолчанию и отдали эти данные на фронт!
        aaa.setFirstNameAAA("aaaaaaaaaaaaaaa111");
        model.addAttribute("userObjParamCreate", aaa);  //если нам нужно что-то передать/отобразить на фронте,
        //то нам нужно передать эти данные через модель, в виде атрибута. Вытащили из БД через "aaa" и запихнули в атрибут "userObjParamCreate" и отдали на фронт.
        return "/user-create";
    }
    @PostMapping("/user-create")                        //тут POST и поэтому объект с фронта сохраняем в БД
    public String createUser(User userObjParamCr) {
        userService.saveUser(userObjParamCr);
        return "redirect:/users";
    }


    //удаляем из БД по запросу с фронта
    @GetMapping("user-delete/{id}")  //в фигурных скобках {id} означает что это переменная которую мы должны суда передать
    public String deleteUser(@PathVariable("id") Long id) {  //и вот эта переменная которая указывается в пути @PathVariable("id")
        userService.deleteById(id); //и при нажатии на фронте мы суда передаем переменную id из ее пути и далее отдаем этот id в БД для поиска и удаления юзера
        return "redirect:/users";
    }



    @GetMapping("/user-update/{id}")    //Это точка входа - тоесть урл при переходе на фронте попадем в это метод
    public String updateUserFrom(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id); //вытащили из БД, переложили в новую переменную и через атрибут отдали на фронт для отображения!
        model.addAttribute("userObjParamUpdate", user); //имя этого атрибута должно совпадать с именем
        return "/user-update";                //объекта th:object="${userObjParamUpdate} в html файле  user-update.html
    }
    @PostMapping("/user-update")
    public String updateUser(User userObjParamUp) {//с фронта принимаем и сохраняем/обновляем в БД
        userService.saveUser(userObjParamUp);      //тоесть тут по сути приняли в параметре модель с фронта и через объект
        //класса с логикой userService дотянулись до метода saveUser() и по сути сделали какуюто логику с данным объектом с фронта,
        //в нашем случае мы без логики/обработки просто сохранили объект в БД.
        return "redirect:/users";
    }

}













