package wad.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wad.domain.Account;
import wad.repository.AccountRepository;

@Controller
public class RegisterController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String get(@ModelAttribute Account account) {
        return "rekisteroityminen";
    }

    @PostMapping("/register")
    public String postNews(@Valid @ModelAttribute Account account, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rekisteroityminen";
        }
        if (this.accountRepository.findByUsername(account.getUsername()) != null) {
            bindingResult.addError(new ObjectError("varattu",
                    "Username is already taken\nChoose another username"));
            return "rekisteroityminen";
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        this.accountRepository.save(account);
        return "redirect:/login";
    }
}
