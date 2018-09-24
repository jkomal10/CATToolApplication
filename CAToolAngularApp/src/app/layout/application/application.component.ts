import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.scss']
})
export class ApplicationComponent implements OnInit {

  constructor(public router:Router) { }

  form(){
    this.router.navigate(['/application/add-application']);
  }
  myFunction()
  {
    this.router.navigate(['/application/import-application']);
  }
  
  ngOnInit() {
  }

}
