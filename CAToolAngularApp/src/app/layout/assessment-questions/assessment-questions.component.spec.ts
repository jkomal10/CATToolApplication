import { async, ComponentFixture, TestBed } from '@angular/core/testing'
import { RouterTestingModule } from '@angular/router/testing'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'

import { AssessmentQuestionsComponent } from './assessment-questions.component'
import {AssessmentQuestionsModule} from './assessment-questions.module'

describe('AssessmentQuestionsComponent', () => {
  let component: AssessmentQuestionsComponent;
  let fixture: ComponentFixture<AssessmentQuestionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        AssessmentQuestionsModule,
        RouterTestingModule,
        BrowserAnimationsModule,
      ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssessmentQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
