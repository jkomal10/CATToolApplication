import { Component, OnInit } from '@angular/core';
import { Customer } from './Customer';
import { AddAssessmentQuestionService } from './add-assessment-question.service';

@Component({
  selector: 'app-add-assessment-question',
  templateUrl: './add-assessment-question.component.html',
  styleUrls: ['./add-assessment-question.component.scss']
})
export class AddAssessmentQuestionComponent implements OnInit {

  customer: Customer = new Customer();
  submitted = false;

  constructor(private customerService: AddAssessmentQuestionService) { }

  ngOnInit() {
  }

  newCustomer(): void {
    this.submitted = false;
    this.customer = new Customer();
  }

  save() {
    this.customerService.createCustomer(this.customer)
      .subscribe(data => console.log(data), error => console.log(error));
    this.customer = new Customer();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
