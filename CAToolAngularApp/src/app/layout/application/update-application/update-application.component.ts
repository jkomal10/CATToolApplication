import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { Application } from '../Application';
import { ApplicationService } from '../application.service';

@Component({
  selector: 'app-update-application',
  templateUrl: './update-application.component.html',
  styleUrls: ['./update-application.component.scss']
})
export class UpdateApplicationComponent implements OnInit {
application= new Application();
  app : any;
  
  constructor(private router: Router, private applicationService: ApplicationService) { }
  
  ngOnInit() {

    this.applicationService.question.subscribe(data => {this.app= data;}); 
    //this.router.navigate(['/application/update-application']);
    
  }
  updateActive(application) {
    console.log('*******onsubmit application**********'+application.applicationId);
    this.applicationService.updateApplication(application)
      .subscribe(
        // data => {
        //   console.log(data);
        //   this.application = data as Application;
        //   console.log('*********************'+this.app);
        // },
        // error => console.log(error)
      );
  }
  onSubmit(formvalues){
    this.application=formvalues;
      this.updateActive(this.application);
  }

}
