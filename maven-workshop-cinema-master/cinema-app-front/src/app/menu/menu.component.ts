import {Component, OnChanges, OnInit} from '@angular/core';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {LoginService} from '../services/login.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  // Différents rôles d'internautes connectés
  isReader: boolean;
  isCreator: boolean;
  isAdmin: boolean;
  identifiant: string;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(private breakpointObserver: BreakpointObserver, private loginService: LoginService) {
  }

  ngOnInit() {
    // quels sont les connections avec les différents rôles ?
    this.loginService.userRoles.subscribe(userRoles => {
        this.isReader = userRoles.includes('ROLE_READER');
        this.isCreator = userRoles.includes('ROLE_CREATOR');
        this.isAdmin = userRoles.includes('ROLE_ADMIN');
    });
    // Récupérer l'identifiant
    this.identifiant= sessionStorage.getItem("username");

  }

  // Déconnection
  logout()
  {
    this.identifiant='';
    this.loginService.signOut();
  }

  // état de la connection
  isLogged(): boolean
  {
    return this.loginService.loggedIn;
  }
}
