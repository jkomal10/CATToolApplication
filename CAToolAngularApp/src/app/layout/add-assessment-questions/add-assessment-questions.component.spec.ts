import { async, ComponentFixture, TestBed } from '@angular/core/testing'
import { RouterTestingModule } from '@angular/router/testing'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'

import { AddAssessmentQuestionsComponent } from './add-assessment-questions.component'
import { AddAssessmentQuestionsModule } from './add-assessment-questions.module'

describe('AddAssessmentQuestionsComponent', () => {
  let component: AddAssessmentQuestionsComponent;
  let fixture: ComponentFixture<AddAssessmentQuestionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        AddAssessmentQuestionsModule,
        RouterTestingModule,
        BrowserAnimationsModule,
      ],
      declarations: [ AddAssessmentQuestionsComponent ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAssessmentQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
