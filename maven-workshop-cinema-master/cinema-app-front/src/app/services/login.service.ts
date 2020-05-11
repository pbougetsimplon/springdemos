import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../model/user.model';
import {JsonWebToken} from '../model/jwt.model';
import {Router} from '@angular/router';
import {environment} from '../../environments/environment';
import * as jwt_decode from 'jwt-decode';
import {BehaviorSubject} from 'rxjs';
import {conditionallyCreateMapObjectLiteral} from '@angular/compiler/src/render3/view/util';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  userRoles: BehaviorSubject<string[]> = new BehaviorSubject([]);
  logged: boolean;

  constructor(private httpClient: HttpClient, private router: Router) {
    this.getUserRoles();
    this.logged = false;
  }

  public get loggedIn(): boolean {
    return sessionStorage.getItem(environment.accessToken) !== null;
  }

  signIn(user: User) {
    this.httpClient.post<JsonWebToken>(environment.apiUrl + 'user/sign-in', user).subscribe(
      token => {
        sessionStorage.setItem(environment.accessToken, token.token);
        sessionStorage.setItem('username', user.username);
        this.logged = true; // connecté
        console.log('username ='+sessionStorage.getItem('username'));
        this.getUserRoles();
        this.router.navigate(['']); // on redirige vers la page d'accueil
      },
      error => console.log('Erreur pendant la connection !'));
  }

  signOut() {
    sessionStorage.removeItem(environment.accessToken); // on détruit le token
    sessionStorage.removeItem('username');  // on détruit le username
    this.logged=false;
    this.router.navigate(['login']); // on retourne vers la page de login
  }

  private getUserRoles() {
    if (sessionStorage.getItem(environment.accessToken)) {
      const decodedToken = jwt_decode(sessionStorage.getItem(environment.accessToken));
      const authorities: Array<any> = decodedToken.auth;
      this.userRoles.next(authorities.map(authority => authority.authority));
    }
  }

}
