package ch.noseryoung.drinks.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserWeb {

    @Autowired
    private UserService userService;

    @GetMapping("/login/{name}")
    public User getUserByLogin(@PathVariable("name") String name) {
        UserDetails userDetails = userService.loadUserByUsername(name);

        if (userDetails instanceof UserService.UserDetailsImpl userDetailsImpl) {
            return userDetailsImpl.user();
        } throw new RuntimeException("User details implementation is not as expected.");
    }
}
