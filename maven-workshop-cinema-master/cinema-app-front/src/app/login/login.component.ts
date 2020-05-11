import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import {LoginService} from '../services/login.service';
import {User} from '../model/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm = this.fb.group({
    username: [null, Validators.required],
    password: [null, Validators.compose([
      Validators.required, Validators.minLength(5), Validators.maxLength(15)])
    ]
  });

  constructor(private fb: FormBuilder, private loginService: LoginService) {}

  onSubmit() {
    const user = new User(); // on instancie un Utilisateur
    user.username = this.loginForm.value.username; // on lui affecte la valeur saisie username dans le formulaire
    user.password = this.loginForm.value.password; // on lui affecte la valeur saisie password dans le formulaire
    this.loginService.signIn(user); // on se connecte
  }
}
