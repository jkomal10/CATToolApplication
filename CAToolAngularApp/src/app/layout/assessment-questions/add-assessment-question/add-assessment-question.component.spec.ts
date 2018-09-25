import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAssessmentQuestionComponent } from './add-assessment-question.component';

describe('AddAssessmentQuestionComponent', () => {
  let component: AddAssessmentQuestionComponent;
  let fixture: ComponentFixture<AddAssessmentQuestionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddAssessmentQuestionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAssessmentQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
