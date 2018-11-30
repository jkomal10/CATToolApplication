import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicationAssessmentComponent } from './application-assessment.component';

describe('ApplicationAssessmentComponent', () => {
  let component: ApplicationAssessmentComponent;
  let fixture: ComponentFixture<ApplicationAssessmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApplicationAssessmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplicationAssessmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
