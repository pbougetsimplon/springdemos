import {Component, OnInit, ViewChild} from '@angular/core';
import { DataService } from '../services/data.service';
import { User } from '../model/user.model';
// import { MatPaginator, MatTableDataSource, PageEvent, MatSort } from '@angular/material';
// import { MatFormFieldModule, MatInputModule, MatPaginatorModule, MatTableModule, MatSortModule } from '@angular/material';
// import {MatHeaderCell} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})

export class UserListComponent implements OnInit {

  userList: User[] = [];

  constructor(private dataService: DataService,
           //   private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.dataService.getUserList().subscribe(users => this.userList = users);

  }


  onUpdate(username: string) {
    console.log("onUpdate");
    this.router.navigate(['user-edit/' + username]);
  }

  onDelete(username: string) {

    if (confirm("Confirmez-vous la suppression du compte user  " + username + "?")) {
     //    this.dataService.delete(username);
      console.log("onDelete");
    }
  }
    // applyFilter(filterValue: string) {
    //   this.myDataSource.filter = filterValue.trim().toLowerCase();
    // }
}
