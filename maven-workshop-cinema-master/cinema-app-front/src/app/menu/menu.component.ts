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

  isReader: boolean;
  isCreator: boolean;
  isAdmin: boolean;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(private breakpointObserver: BreakpointObserver, private loginService: LoginService) {
  }

  ngOnInit() {
    this.loginService.userRoles.subscribe(userRoles => {
      this.isReader = userRoles.includes('ROLE_READER');
      this.isCreator = userRoles.includes('ROLE_CREATOR');
      this.isAdmin = userRoles.includes('ROLE_ADMIN');
    });
  }
}
